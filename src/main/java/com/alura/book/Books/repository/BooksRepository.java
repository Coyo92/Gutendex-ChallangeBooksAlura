package com.alura.book.Books.repository;
import com.alura.book.Books.models.Book;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@AutoConfiguration
public interface BooksRepository extends JpaRepository<Book,Long> {

    @Query("select 'S' as exist from Book where id = :id ORDER BY id asc LIMIT 1")
    String valExistBook(int id);

    @Query("select a from Book a")
    List<Book> getListBooksDB();

    @Query("select a from Book a where a.title ILIKE %:title%")
    List<Book> getListBooksByTitleDB(String title);

    @Query("select a from Book a where a.languages = :Lang")
    List<Book> getListBooksByLanguageDB(String Lang);
}