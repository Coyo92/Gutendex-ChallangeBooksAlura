package com.alura.book.Books.models;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "books")

public class Book {
    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(unique = true)
    private String title;
    private String languages;
    private int download_count;
    @ManyToOne
    private Authors authors;
    int author_id;

    public Book() {
    }

    public Book(BookRecord datosLibro) {
        this.id = datosLibro.id ();
        this.title = datosLibro.title ();
        this.languages = String.valueOf ( datosLibro.languages () );
        this.download_count = datosLibro.download_count ();
        this.authors = getAuthor ();
        this.author_id = getAuthor_id ();
    }

    public Authors getAuthor() {
        return authors;
    }

    public void setAuthor(Authors author) {
        this.authors = author;
    }

    @Override
    public String toString() {
        return //"Book{" +
                "id=" + id +
                        ", title='" + title + '\'' +
                        ", author='" + authors + '\'' +
                        ", languages='" + languages + '\'' +
                        ", download_count='" + download_count +
                        ", author_id='" + author_id
                //+'}'
                ;
    }

    public Authors getAuthors() {
        return authors;
    }

    public void setAuthors(Authors authors) {
        this.authors = authors;
    }

    public int getDownload_count() {
        return download_count;
    }

    public void setDownload_count(int download_count) {
        this.download_count = download_count;
    }

    public int getAuthor_id() {
        return author_id;
    }

    public void setAuthor_id(int author_id) {
        this.author_id = author_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setLanguages(String languages) {
        this.languages = languages;
    }

    public String getLanguages() {
        return languages;
    }

}
