package com.alura.book.Books.funciones;

import com.alura.book.Books.models.Book;
import com.alura.book.Books.repository.BooksRepository;
import com.alura.book.Books.repository.RepositoryController;

import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import static com.alura.book.Books.funciones.msgList.msgListBooksDB;

public class SearchBookByLang {

    private static final Scanner searchByLang = new Scanner(System.in);

    public static void listBookByLangDB() {

        boolean validacionTitulo;

        do {

            System.out.print("Ingrese un Idioma para filtrar los Libros:  ");
            var searchedBookByTitle = searchByLang.nextLine ();

            if (searchedBookByTitle != null) {
                validacionTitulo = true;
                BooksRepository bookrepository = RepositoryController.GetBookRepository ();
                List<Book> listBooks = bookrepository.getListBooksByLanguageDB (searchedBookByTitle.toLowerCase( ));
                msgListBooksDB (listBooks);

            } else {

                validacionTitulo = false;
                System.out.println ( "Peticion Denegada: Para realizar la consulta debe ingresar un Idioma." );
            }

        } while (!validacionTitulo);

    }
}
