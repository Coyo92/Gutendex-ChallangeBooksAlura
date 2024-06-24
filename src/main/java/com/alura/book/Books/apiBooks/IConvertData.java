package com.alura.book.Books.apiBooks;


public interface IConvertData {
    <T> T obtenerDatos(String json, Class<T> clase);
}
