package mk.ukim.finki.wp.lab.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Author {


    private Long id;
    private String name;
    private String surname;
    private String biography;

}
