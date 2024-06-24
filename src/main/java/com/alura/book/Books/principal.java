package com.alura.book.Books;

import com.alura.book.Books.funciones.consultarLibroAPI;
import org.json.JSONException;

import java.util.Scanner;

import static com.alura.book.Books.funciones.SearchAuthorsByYears.listAuthorsByYears;
import static com.alura.book.Books.funciones.SearchBookByLang.listBookByLangDB;
import static com.alura.book.Books.funciones.searchAuthorsDB.listAuthorsDB;
import static com.alura.book.Books.funciones.searchBookDB.listBookByTitleDB;
import static com.alura.book.Books.funciones.searchBookDB.listBookDB;


public class principal {
    private final Scanner teclado = new Scanner(System.in);

    consultarLibroAPI consultarLibroTitle = new consultarLibroAPI();

    public void menu() throws JSONException {

        var opcion = -1;
        while (opcion != 0) {
            var menu = """
                    1 - Buscar por Titulo (Consultando Libreria GUTENDEX).
                    2 - Buscar Libros Registrados.
                    3 - Buscar Autores de libros registrados.
                    4 - Buscar Autores Vivos por Anio.
                    5 - Buscar Libros Por Idiomas.
                    6 - Buscar Libro Por Titulo en el Servidor.
                                  
                    0 - Salir
                    """;
            System.out.println(menu);
            opcion = teclado.nextInt();
            teclado.nextLine();

            switch (opcion) {
                case 1:
                    consultarLibroTitle.saveRepositoryTitle ();
                    break;
                case 2:
                    listBookDB();
                    break;
                case 3:
                    listAuthorsDB();
                case 4:
                    listAuthorsByYears();
                    break;
                case 5:
                    listBookByLangDB();
                    break;
                case 6:
                    listBookByTitleDB();
                    break;
                case 0:
                    System.out.println("Operación finalizada. ¡Hasta luego!");
                    break;
                default:
                    System.out.println("""
                            Petición Denegada, Por favor, selecciona una opción válida. 🛠️""");
            }
        }
    }

}
