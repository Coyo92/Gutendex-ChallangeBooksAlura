package com.alura.book.Books.funciones;

import com.alura.book.Books.models.Book;
import com.alura.book.Books.repository.BooksRepository;
import com.alura.book.Books.repository.RepositoryController;

import java.util.List;
import java.util.Scanner;

import static com.alura.book.Books.funciones.msgList.msgListBooksDB;

public class searchBookDB {

    private static final Scanner searchByTitle = new Scanner(System.in);

    public static void listBookDB() {

        BooksRepository bookrepository = RepositoryController.GetBookRepository ();
        List<Book> listBooks = bookrepository.getListBooksDB ();
        msgListBooksDB (listBooks);

    }

    public static void listBookByTitleDB() {

        boolean validacionTitulo;

        do {

            System.out.print("Ingrese un Titulo para filtrar los Libros en el servidor:  ");
            var searchedBookByTitle = searchByTitle.nextLine ();

            if (searchedBookByTitle != null) {
                validacionTitulo = true;

                BooksRepository bookrepository = RepositoryController.GetBookRepository ();
                List<Book> listBooks = bookrepository.getListBooksByTitleDB (searchedBookByTitle);
                msgListBooksDB (listBooks);
            } else {

                validacionTitulo = false;
                System.out.println ( "Peticion Denegada: Para realizar la consulta debe ingresar un titulo de libro." );
            }

        } while (!validacionTitulo);

    }
}
