package com.alura.book.Books.models;

public class Menu {
    public static final String BIENVENIDA = """
            ************************************************************************
                                   Challange - Alura OracleOne
                                          API-Gutendex
            ************************************************************************
            """;
    public static final String menu = """
                       ************************************************************************
                        1. Buscar libros por título 
                        2. Listar libros registrados
                        3. Listar autores registrados
                        4. Listar autores vivos en un determinado año
                        5. Listar libros por idiomas
                        6. Buscar libros por título en el servidor
                        
                        0. Salir
                    ************************************************************************
                    """;

    public static void mostrarBienvenida() {
        System.out.println(BIENVENIDA);
    }

    public static void mostrarMenu() {
        System.out.println(menu);
    }

}
