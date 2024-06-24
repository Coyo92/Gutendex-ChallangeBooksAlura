package com.alura.book.Books.models;


import java.util.List;

public class Api {
    private List<Book> results;

    public List<Book> getResults() {
        return results;
    }

    public void setResults(List<Book> results) {
        this.results = results;
    }
}
