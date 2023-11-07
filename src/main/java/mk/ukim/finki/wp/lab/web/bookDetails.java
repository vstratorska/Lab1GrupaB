package mk.ukim.finki.wp.lab.web;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import mk.ukim.finki.wp.lab.model.Book;
import mk.ukim.finki.wp.lab.service.AuthorService;
import mk.ukim.finki.wp.lab.service.BookService;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.spring6.SpringTemplateEngine;
import org.thymeleaf.web.IWebExchange;
import org.thymeleaf.web.servlet.JakartaServletWebApplication;

import java.io.IOException;

@WebServlet(name = "bookDetailsServlet", urlPatterns = "/details")
public class bookDetails extends HttpServlet {

    private final SpringTemplateEngine springTemplateEngine;
    private final BookService bookService;
    private final AuthorService authorService;


    public bookDetails(SpringTemplateEngine springTemplateEngine, BookService bookService, AuthorService authorService) {
        this.springTemplateEngine = springTemplateEngine;
        this.bookService = bookService;
        this.authorService = authorService;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        IWebExchange webExchange = JakartaServletWebApplication
                .buildApplication(getServletContext())
                .buildExchange(req, resp);

        WebContext context = new WebContext(webExchange);

        Long id= (Long) getServletContext().getAttribute("id");
        String isbn= (String) getServletContext().getAttribute("isbn");

        bookService.addAuthorToBook(id, isbn);
        Book book=bookService.findBookByIsbn(isbn);

        context.setVariable("title", book.getTitle());
        context.setVariable("genre", book.getGenre());
        context.setVariable("year", book.getYear());
        context.setVariable("authors", book.getAuthors());

        springTemplateEngine.process("bookDetails.html",context,resp.getWriter());

    }
}
