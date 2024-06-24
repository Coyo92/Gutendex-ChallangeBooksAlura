package com.alura.book.Books.repository;

public class RepositoryControllerAuthor {
    private static AuthorsRepository authorsrepository;

    public RepositoryControllerAuthor(AuthorsRepository authorsrepository) {
        RepositoryControllerAuthor.authorsrepository = authorsrepository;
    }

    public static AuthorsRepository GetAuthorsRepository() {
        return authorsrepository;
    }
}
