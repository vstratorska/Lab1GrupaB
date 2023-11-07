package mk.ukim.finki.wp.lab.repository;

import jakarta.annotation.PostConstruct;
import mk.ukim.finki.wp.lab.model.Author;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class AuthorRepository {

    public static List<Author> authors = null;

    @PostConstruct
    public void init() {
        authors = new ArrayList<>(5);

        authors.add(new Author((long)1, "author1Name", "author1Surname", "author1Bio" ));
        authors.add(new Author((long)2, "author2Name", "author2Surname", "author2Bio" ));
        authors.add(new Author((long)3, "author3Name", "author3Surname", "author3Bio" ));
        authors.add(new Author((long)4, "author4Name", "author4Surname", "author4Bio" ));
        authors.add(new Author((long)5, "author5Name", "author5Surname", "author5Bio" ));

    }

    public List<Author> findAll() {
        return authors;
    }

    public Optional<Author> findById(Long id)
    {
        return authors.stream().filter(a-> a.getId().equals(id)).findFirst();
    }

}
