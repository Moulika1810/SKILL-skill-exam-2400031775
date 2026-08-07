package com.klef.soa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.klef.soa.entity.Author;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long>
{
    // Derived Query Method 1
	 List<Author> findByName(String name);

	    List<Author> findByType(String type);
}