package com.alura.book.Books.repository;

public class RepositoryController {

    private static BooksRepository bookrepository;
    private static AuthorsRepository authorsrepository;

    public RepositoryController(BooksRepository bookrepository, AuthorsRepository authorsrepository) {
        RepositoryController.bookrepository = bookrepository;
        RepositoryController.authorsrepository = authorsrepository;
    }

    public static BooksRepository GetBookRepository() {
        return bookrepository;
    }

    public static AuthorsRepository GetAuthorsRepository() {
        return authorsrepository;
    }
}
