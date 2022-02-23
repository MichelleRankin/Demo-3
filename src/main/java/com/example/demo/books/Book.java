package com.example.demo.books;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.Period;


@Entity
@Table

public class Book {
    @Id
    @SequenceGenerator(
            name = "book_sequence",
            sequenceName = "book_sequence",
            allocationSize = 1
    )

    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "student_sequence"
    )
    private Long id;
    private String name;
    private String author;
    private LocalDate publicationDate;

    @Transient
    private Integer YearsPublished;

    public Book() {
    }

    public Book(Long id,
                String name,
                String author,
                LocalDate publicationDate) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.publicationDate = publicationDate;
    }

    public Book(
                   String name,
                   String author,
                   LocalDate publicationDate) {
        this.name = name;
        this.author = author;
        this.publicationDate = publicationDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String email) {
        this.author = author;
    }

    public LocalDate getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(LocalDate publicationDate) {
        this.publicationDate = publicationDate;
    }

    public Integer getYearsPublished() {

        return Period.between(this.publicationDate, LocalDate.now()).getYears();
    }

    public void setYearsPublished(Integer yearsPublished) {
        this.YearsPublished = yearsPublished;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", published=" + publicationDate +
                ", howOld=" + YearsPublished +
                '}';
    }
}
