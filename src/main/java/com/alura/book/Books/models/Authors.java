package com.alura.book.Books.models;


import jakarta.persistence.*;

import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "author")
public class Authors {
    @Id
    //@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "author_seq")
    //@SequenceGenerator(name = "author_seq", sequenceName = "author_id_seq")
    //@GeneratedValue(strategy = GenerationType.AUTO)
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    //@Column(name = "id")
    private int id;
    @Column(unique = true)
    private String name;
    private int birth_year;
    private int death_year;
    @OneToMany(mappedBy = "authors", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Book> book;

    public Authors() {

    }

    public Authors(AuthorsRecord datosAuthor) {
        //this.id = datosAuthor.id ();
        this.name = datosAuthor.name ();
        this.birth_year = datosAuthor.birth_year ();
        this.death_year = datosAuthor.death_year ();
    }

    public List<Book> getbook() {
        return book;
    }

    public void setbook(List<Book> book) {
        this.book = book;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBirth_year() {
        return birth_year;
    }

    public void setBirth_year(int birth_year) {
        this.birth_year = birth_year;
    }

    public int getDeath_year() {
        return death_year;
    }

    public void setDeath_year(int death_year) {
        this.death_year = death_year;
    }

    @Override
    public String toString() {
        return
                "id=" + id +
                        ", name='" + name + '\'' +
                        ", birth_year=" + birth_year +
                        ", death_year=" + death_year
                ;
    }

    @OneToMany(mappedBy = "authors")
    private Collection<Book> book2;

    public Collection<Book> getBook2() {
        return book2;
    }

    public void setBook2(Collection<Book> book2) {
        this.book2 = book2;
    }
}
