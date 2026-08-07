package com.klef.soa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.klef.soa.entity.Author;
import com.klef.soa.service.AuthorService;

@RestController
@RequestMapping("/author")
@CrossOrigin("*")
public class AuthorController
{
    @Autowired
    private AuthorService authorService;

    @PostMapping
    public String insertAuthor(@RequestBody Author author)
    {
        return authorService.insertAuthor(author);
    }

    @PutMapping
    public String updateAuthor(@RequestBody Author author)
    {
        return authorService.updateAuthor(author);
    }

    @DeleteMapping("/{id}")
    public String deleteAuthor(@PathVariable Long id)
    {
        return authorService.deleteAuthor(id);
    }

    @GetMapping
    public List<Author> displayAuthors()
    {
        return authorService.displayAuthors();
    }

    @GetMapping("/{id}")
    public Author displayAuthorById(@PathVariable Long id)
    {
        return authorService.displayAuthorById(id);
    }

    @GetMapping("/name/{name}")
    public List<Author> displayAuthorsByName(@PathVariable String name)
    {
        return authorService.displayAuthorsByName(name);
    }

    @GetMapping("/type/{type}")
    public List<Author> displayAuthorsByType(@PathVariable String type)
    {
        return authorService.displayAuthorsByType(type);
    }
}