package com.example.demo.books;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service

public class BookService {

    private final BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }


    @GetMapping
    public List<Book> getBooks(){
        return bookRepository.findAll();

    }


    public void addNewBook(Book book) {
        Optional<Book> BookOptional = bookRepository.findBookByAuthor(book.getAuthor());
        if(BookOptional.isPresent()){
            throw new IllegalStateException("Book name taken");
        }
        bookRepository.save(book);

    }

    public void deleteBook(Long bookId) {
        boolean exists = bookRepository.existsById(bookId);
        if (!exists) {

            throw new IllegalStateException("book with id " + bookId + " does not exist");

        }
        bookRepository.deleteById(bookId);
    }

    @Transactional
    public void updateBook(Long bookId,
                              String name,
                              String author) {
        Book book = bookRepository.findById(bookId).orElseThrow(() -> new IllegalStateException(
                "book with id " + bookId + " does not exist"));

        if (name != null &&
                name.length() > 0 &&
                !Objects.equals(book.getName(), name)) {
            book.setName(name);
        }
        Optional<Book> BookOptional = null;
        if (author != null && author.length() > 0 && !Objects.equals(book.getAuthor(), author)) {
            BookOptional = bookRepository.findBookByAuthor(author);

        }
        if (BookOptional.isPresent()) {
            throw new IllegalStateException("pen name taken");

        }
        book.setAuthor(author);

    }
}
