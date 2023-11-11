package mk.ukim.finki.wp.lab.service.Implementation;

import mk.ukim.finki.wp.lab.model.Author;
import mk.ukim.finki.wp.lab.model.Book;
import mk.ukim.finki.wp.lab.repository.AuthorRepository;
import mk.ukim.finki.wp.lab.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService implements mk.ukim.finki.wp.lab.service.BookService {

    private final AuthorRepository authorRepository2;
    private final BookRepository bookRepository;

    public BookService(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository2 = authorRepository;
        this.bookRepository = bookRepository;
    }
    @Override
    public List<Book> listBooks() {
        return bookRepository.findAll();
    }

    @Override
    public Author addAuthorToBook(Long authorId, String isbn) {
        return bookRepository.addAuthorToBook(authorRepository2.findById(authorId).get(), bookRepository.findByIsbn(isbn));
    }

    @Override
    public Book findBookByIsbn(String isbn) {
        return bookRepository.findByIsbn(isbn);
    }

    @Override
    public Book deleteAuthors(Book book) {
      return bookRepository.deleteAuthors(book);
    }


}
