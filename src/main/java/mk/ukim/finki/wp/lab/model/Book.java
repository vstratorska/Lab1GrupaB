package mk.ukim.finki.wp.lab.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@AllArgsConstructor
@Data
public class Book {

    private String isbn;
    private String title;
    private String genre;
    private int year;
    private List<Author> authors;

}
