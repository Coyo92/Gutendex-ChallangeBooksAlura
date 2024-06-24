package com.alura.book.Books.funciones;

import com.alura.book.Books.models.Authors;
import com.alura.book.Books.models.Book;
import com.alura.book.Books.models.BookRecord;
import com.alura.book.Books.repository.AuthorsRepository;
import com.alura.book.Books.repository.RepositoryController;

import java.util.List;

public class msgList {

    public static void msgListBook(List<BookRecord> books , String filterMessage) {

        int countRegisters = books.size ();
        String msgTitulo = "";
        if (countRegisters > 0) {
            msgTitulo = " Se han encontrado registros " + countRegisters + filterMessage;
        } else {
            msgTitulo = " No se han encontrado registros " + filterMessage;
        }
        System.out.println("***************************************************************************************");
        System.out.println ( msgTitulo );
        System.out.println("***************************************************************************************");
        for (int i = 0; i < countRegisters; i++) {
            System.out.println ( "\n   Titulo: " + books.get ( i ).title ( )
                    + "\n   Autor: " + books.get ( i ).authors ( ).get ( 0 ).name ( )
                    + "\n   Idioma: " + books.get ( i ).languages ().getFirst ()
                    + "\n   Descargas: " + books.get ( i ).download_count ( )
                    + "\n***************************************************************************************"
            );
        }
        System.out.println("***************************************************************************************");
    }

    public static void msgListAuthosDB(List<Authors> authors) {

        int countRegisters = authors.size ();
        String msgTitulo = "";
        if (countRegisters > 0) {
            msgTitulo = " Se han encontrado " + countRegisters + " Autores registrados en la base de datos.";
        } else {
            msgTitulo = " No se han encontrado registros. ";
        }
        System.out.println("***************************************************************************************");
        System.out.println ( msgTitulo );
        System.out.println("***************************************************************************************");
        for (int i = 0; i < countRegisters; i++) {
            System.out.println ( "\n   Autor: " + authors.get ( i ).getName ()
                    + "\n   Fecha de Nacimiento: " + authors.get ( i ).getBirth_year ()
                    + "\n   Fecha de Muerte: " + authors.get ( i ).getDeath_year ()
                    + "\n***************************************************************************************"
            );
        }
        System.out.println("***************************************************************************************");
    }

    public static void msgListBooksDB(List<Book> book) {
        AuthorsRepository authorsrepository = RepositoryController.GetAuthorsRepository();

        int countRegisters = book.size ();
        String msgTitulo = "";
        if (countRegisters > 0) {
            msgTitulo = " Se han encontrado " + countRegisters + " Autores registrados en la base de datos.";
        } else {
            msgTitulo = " No se han encontrado registros. ";
        }
        System.out.println("***************************************************************************************");
        System.out.println ( msgTitulo );
        System.out.println("***************************************************************************************");
        for (int i = 0; i < countRegisters; i++) {
            System.out.println ( "\n   Titulo: " + book.get ( i ).getTitle ()
                    + "\n   Autor: " + authorsrepository.getNameAuthor( book.get ( i ).getAuthor_id () )
                    + "\n   Idioma: " + book.get ( i ).getLanguages ()
                    + "\n   Descargas: " + book.get ( i ).getDownload_count ()
                    + "\n***************************************************************************************"
            );
        }
        System.out.println("***************************************************************************************");
    }
}
