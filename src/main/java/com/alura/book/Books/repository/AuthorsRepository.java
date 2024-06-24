package com.alura.book.Books.repository;

import com.alura.book.Books.models.Authors;
import com.alura.book.Books.models.AuthorsRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AuthorsRepository extends JpaRepository<Authors,Long> {

    @Query("select nextval('author_id_seq')")
    int seqAuthors();

    @Query("select 'S' as exist from Authors where name = :name ORDER BY id asc LIMIT 1")
    String valExistAuthor(String name);

    @Query("select id from Authors where name = :name")
    int getIdAuthor(String name);

    @Query("select name from Authors where id = :id")
    String getNameAuthor(int id);

    @Query("select a from Authors a")
    List<Authors> getListAuthorsDB();

    @Query("select b from Authors b where :year between b.birth_year and b.death_year")
    List<Authors> getListAuthorsByYearsDB(int year);

}
