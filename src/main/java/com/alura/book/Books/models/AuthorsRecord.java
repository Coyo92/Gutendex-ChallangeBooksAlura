package com.alura.book.Books.models;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record AuthorsRecord(
        @JsonAlias("id") int id,
        @JsonAlias("name") String name,
        @JsonAlias("birth_year") int birth_year,
        @JsonAlias("death_year") int death_year
    ) {
}