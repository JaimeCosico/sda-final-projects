package com.example.agilestore15.services;

import com.example.agilestore15.entities.Author;
import com.example.agilestore15.repositories.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.util.List;


@Service
    public class AuthorService {

        @Autowired
        private AuthorRepository repo;
        private SecureRandom secureRandom = new SecureRandom();

        //adding of new author
        public Author addNewAuthor(Author newAuthor){
            Author author = new Author();
            author.setId(Long.parseLong(String.valueOf(Math.abs(secureRandom.nextInt()))));
            author.setFirstName(newAuthor.getFirstName());
            author.setLastName(newAuthor.getLastName());
            return author;
        }
        //shows all author
        public List<Author> listAllAuthor() {

            return (List<Author>) repo.findAll();
        }

        public void save(Author author) {
            repo.save(author);
        }

    }




