package mk.ukim.finki.wp.lab.service.Implementation;

import mk.ukim.finki.wp.lab.model.Author;
import mk.ukim.finki.wp.lab.repository.AuthorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService implements mk.ukim.finki.wp.lab.service.AuthorService {

    private final AuthorRepository authorRepository1;

    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository1 = authorRepository;
    }

    @Override
    public List<Author> listAuthors() {
        return this.authorRepository1.findAll();
    }

    @Override
    public Author findById(Long id) {
        return this.authorRepository1.findById(id).get();
    }
}
