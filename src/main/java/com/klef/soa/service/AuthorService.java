package com.klef.soa.service;

import java.util.List;

import com.klef.soa.entity.Author;

public interface AuthorService {

    String insertAuthor(Author author);

    String updateAuthor(Author author);

    String deleteAuthor(Long id);

    List<Author> displayAuthors();

    Author displayAuthorById(Long id);

    List<Author> displayAuthorsByName(String name);

    List<Author> displayAuthorsByType(String type);
}