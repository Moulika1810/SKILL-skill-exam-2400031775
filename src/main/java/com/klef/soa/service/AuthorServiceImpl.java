package com.klef.soa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.klef.soa.entity.Author;
import com.klef.soa.repository.AuthorRepository;

@Service
public class AuthorServiceImpl implements AuthorService
{
    @Autowired
    private AuthorRepository authorRepository;

    @Override
    public String insertAuthor(Author author)
    {
        authorRepository.save(author);
        return "Author Inserted Successfully";
    }

    @Override
    public String updateAuthor(Author author)
    {
        authorRepository.save(author);
        return "Author Updated Successfully";
    }

    @Override
    public String deleteAuthor(Long id)
    {
        authorRepository.deleteById(id);
        return "Author Deleted Successfully";
    }

    @Override
    public List<Author> displayAuthors()
    {
        return authorRepository.findAll();
    }

    @Override
    public Author displayAuthorById(Long id)
    {
        return authorRepository.findById(id).orElse(null);
    }

    @Override
    public List<Author> displayAuthorsByName(String name)
    {
        return authorRepository.findByName(name);
    }

    @Override
    public List<Author> displayAuthorsByType(String type)
    {
        return authorRepository.findByType(type);
    }
}