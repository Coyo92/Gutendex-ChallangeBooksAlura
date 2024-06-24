package com.alura.book.Books.funciones;

import com.alura.book.Books.models.Authors;
import com.alura.book.Books.repository.AuthorsRepository;
import com.alura.book.Books.repository.RepositoryController;

import java.util.List;
import java.util.Scanner;

import static com.alura.book.Books.funciones.msgList.msgListAuthosDB;

public class searchAuthorsDB {

    public static void listAuthorsDB() {

        AuthorsRepository authorsrepository = RepositoryController.GetAuthorsRepository();
        List<Authors> listAuthors = authorsrepository.getListAuthorsDB ();
        msgListAuthosDB (listAuthors);

    }
}
