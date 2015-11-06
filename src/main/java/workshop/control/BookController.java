package workshop.control;

import workshop.entity.AuthorFinder;
import workshop.entity.Book;
import workshop.entity.BookFinder;

import java.io.File;

/**
 * A Book Controller  that uses old school manual wiring.¬
 */
public class BookController {

    private BookFinder bookFinder;
    private AuthorFinder authorFinder;

    public BookController(File baseDir) {
        bookFinder = new BookFinder(baseDir);
        authorFinder = new AuthorFinder(baseDir);
    }


    public BookOverview getOverview(Long bookId) {
        Book book = bookFinder.getById(bookId);
        BookOverview overview = new BookOverview();
        overview.setTitle(book.getTitle());
        book.getAuthors().forEach((a) -> overview.getAuthorNames().add(authorFinder.getById(a).getName()));
        return overview;
    }
}
