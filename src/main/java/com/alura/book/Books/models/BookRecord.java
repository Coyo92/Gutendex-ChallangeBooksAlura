package com.alura.book.Books.models;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)

public record BookRecord(
        @JsonAlias("id") int id,
        @JsonAlias("title") String title,
        @JsonAlias("authors")List<AuthorsRecord> authors,
        @JsonAlias("languages")List<String> languages,
        @JsonAlias("download_count") Integer download_count,
        @JsonAlias("author_id") Integer author_id
    ) {
}

