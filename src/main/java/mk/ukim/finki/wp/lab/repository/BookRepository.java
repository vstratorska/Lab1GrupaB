package mk.ukim.finki.wp.lab.repository;

import jakarta.annotation.PostConstruct;
import mk.ukim.finki.wp.lab.model.Author;
import mk.ukim.finki.wp.lab.model.Book;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class BookRepository {
    public static List<Book> books = null;
    public static List<Author> b=null;

    @PostConstruct
    public void init() {
        books = new ArrayList<>(5);

         b = new ArrayList<>(); b.add(new Author((long)6, "author6Name", "author6Surname", "author6Bio"));

        books.add(new Book("1111", "book1Title", "book1Genre", 2019, b));
        books.add(new Book("2222", "book2Title", "book2Genre", 2020, b));
        books.add(new Book("3333", "book3Title", "book3Genre", 2021, b));
        books.add(new Book("4444", "book4Title", "book4Genre", 2022, b));
        books.add(new Book("5555", "book5Title", "book5Genre", 2023, b));
    }

    public List<Book> findAll()
    {
    return books;
    }

    public Book findByIsbn(String isbn)
    {
        return books.stream().filter(b-> b.getIsbn().equals(isbn)).findFirst().get();
    }

    public Author addAuthorToBook(Author author, Book book)
    {
        book.getAuthors().add(author);
        return author;
    }

    public Book deleteAuthors(Book book)
    {
        book.getAuthors().clear();
        return book;
    }


}
