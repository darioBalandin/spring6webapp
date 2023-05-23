package guru.springframework.spring6webapp.service;


import guru.springframework.spring6webapp.domain.Author;
import org.springframework.stereotype.Service;

public interface AuthorService {

    Iterable<Author> findAll();
}
