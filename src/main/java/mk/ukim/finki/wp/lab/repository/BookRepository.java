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
    public static List<Author> books1=null;
    public static List<Author> books2=null;
    public static List<Author> books3=null;
    public static List<Author> books4=null;
    public static List<Author> books5=null;

    @PostConstruct
    public void init() {
        books = new ArrayList<>(5);

        books1=new ArrayList<>(); books1.add(new Author((long)6, "author6Name", "author6Surname", "author6Bio"));
                   books1.add(new Author((long)7, "author7Name", "author7Surname", "author7Bio"));

        books2=new ArrayList<>(); books2.add(new Author((long)8, "author8Name", "author8Surname", "author8Bio"));
        books2.add(new Author((long)9, "author9Name", "author9Surname", "author9Bio"));
        books2.add(new Author((long)10, "author10Name", "author10Surname", "author10Bio"));

        books3=new ArrayList<>(); books3.add(new Author((long)9, "author9Name", "author9Surname", "author9Bio"));

        books4=new ArrayList<>(); books4.add(new Author((long)9, "author9Name", "author9Surname", "author9Bio"));
        books4.add(new Author((long)6, "author6Name", "author6Surname", "author6Bio"));

        books5=new ArrayList<>(); books5.add(new Author((long)10, "author10Name", "author10Surname", "author10Bio"));

        books.add(new Book("1111", "book1Title", "book1Genre", 2019, books1));
        books.add(new Book("2222", "book2Title", "book2Genre", 2020, books2));
        books.add(new Book("3333", "book3Title", "book3Genre", 2021, books3));
        books.add(new Book("4444", "book4Title", "book4Genre", 2022, books4));
        books.add(new Book("5555", "book5Title", "book5Genre", 2023, books5));
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
}
