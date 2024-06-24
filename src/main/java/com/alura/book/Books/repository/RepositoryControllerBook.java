package com.alura.book.Books.repository;

public class RepositoryControllerBook {

    private static BooksRepository bookrepository;

    public RepositoryControllerBook(BooksRepository bookrepository) {
        RepositoryControllerBook.bookrepository = bookrepository;
    }

    public static BooksRepository GetBookRepository() {
        return bookrepository;
    }
}
