
package com.klef.soa.repository;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;
import org.springframework.boot.jdbc.test.autoconfigure.AutoConfigureTestDatabase;

import com.klef.soa.entity.Author;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class AuthorRepositoryTest {

    @Autowired
    private AuthorRepository authorRepository;

    // Test 1: Find all authors
    @Test
    public void testFindAll() {

        List<Author> authors = authorRepository.findAll();

        assertNotNull(authors);

        System.out.println("Total Authors: " + authors.size());
    }

    // Test 2: Find author by existing ID
    @Test
    public void testFindByIdExisting() {

        Author author = new Author();

        author.setName("Moulika");
        author.setType("Technical");
        author.setStatus("Active");
        author.setLocation("Vijayawada");

        Author savedAuthor = authorRepository.save(author);

        Optional<Author> result =
                authorRepository.findById(savedAuthor.getAuthorId());

        assertTrue(result.isPresent());

        assertEquals("Moulika", result.get().getName());
    }

    // Test 3: Find author by non-existing ID
    @Test
    public void testFindByIdNotExisting() {

        Optional<Author> result =
                authorRepository.findById(999999L);

        assertFalse(result.isPresent());
    }

    // Test 4: Find author by name
    @Test
    public void testFindByName() {

        Author author = new Author();

        author.setName("Moulika");
        author.setType("Technical");
        author.setStatus("Active");
        author.setLocation("Vijayawada");

        authorRepository.save(author);

        List<Author> result =
                authorRepository.findByName("Moulika");

        assertFalse(result.isEmpty());

        assertEquals("Moulika", result.get(0).getName());
    }

    // Test 5: Count authors
    @Test
    public void testCount() {

        authorRepository.deleteAll();

        Author author1 = new Author();

        author1.setName("Author One");
        author1.setType("Technical");
        author1.setStatus("Active");
        author1.setLocation("Vijayawada");

        Author author2 = new Author();

        author2.setName("Author Two");
        author2.setType("Fiction");
        author2.setStatus("Active");
        author2.setLocation("Hyderabad");

        authorRepository.save(author1);
        authorRepository.save(author2);

        long count = authorRepository.count();

        assertEquals(2, count);
    }

    // Test 6: Verify author details
    @Test
    public void testAuthorDetails() {

        Author author = new Author();

        author.setName("Sai");
        author.setType("Technical");
        author.setStatus("Active");
        author.setLocation("Guntur");

        Author savedAuthor = authorRepository.save(author);

        Author result = authorRepository
                .findById(savedAuthor.getAuthorId())
                .orElseThrow();

        assertEquals("Sai", result.getName());
        assertEquals("Technical", result.getType());
        assertEquals("Active", result.getStatus());
        assertEquals("Guntur", result.getLocation());
    }

}
