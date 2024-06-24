package com.alura.book.Books.funciones;

import com.alura.book.Books.models.Authors;
import com.alura.book.Books.repository.AuthorsRepository;
import com.alura.book.Books.repository.RepositoryController;

import java.util.List;
import java.util.Scanner;

import static com.alura.book.Books.funciones.msgList.msgListAuthosDB;
import static com.alura.book.Books.funciones.valIsNumberInt.isNumberDouble;
import static com.alura.book.Books.funciones.valIsNumberInt.isNumberInt;

public class SearchAuthorsByYears {

    private static final Scanner searchAuthors = new Scanner(System.in);

    public static void listAuthorsByYears() {

        boolean validacionTitulo;

        do {

            System.out.print("Ingrese una anio para filtrar a todos los autores vivos:  ");
            var searchedAuthorByYear = searchAuthors.nextLine ();

            boolean valYear = !isNumberDouble ( searchedAuthorByYear );

            System.out.println ( "valYear: " + valYear );

            if (searchedAuthorByYear != null && !valYear) {

                validacionTitulo = true;

                AuthorsRepository authorsrepository = RepositoryController.GetAuthorsRepository();
                List<Authors> listAuthors = authorsrepository.getListAuthorsByYearsDB ( Integer.parseInt ( searchedAuthorByYear ) );
                msgListAuthosDB (listAuthors);
            } else {

                validacionTitulo = false;
                System.out.println ( "Peticion Denegada: Para realizar la consulta debe ingresar un Anio." );
            }

        } while (!validacionTitulo);

    }
}
