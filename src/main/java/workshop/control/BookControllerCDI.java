package workshop.control;

import workshop.entity.AuthorFinder;
import workshop.entity.Book;
import workshop.entity.BookFinder;
import workshop.entity.BookRemover;

import javax.inject.Inject;
import java.util.Optional;

/**
 * A Book Controller that uses CDI for wiring.
 * (actually there's no wiring happening in this workshop)
 */
public class BookControllerCDI {
    @Inject
    private BookFinder bookFinder;
    @Inject
    private AuthorFinder authorFinder;
    @Inject
    private BookRemover bookRemover;

    public BookOverview getOverview(Long bookId) {
        Book book = bookFinder.getById(bookId);
        BookOverview overview = new BookOverview();
        overview.setTitle(book.getTitle());
        book.getAuthors().forEach((a) -> overview.getAuthorNames().add(authorFinder.getById(a).getName()));
        return overview;
    }

    public void delete(Long bookId) {
        Optional<Book> book = bookFinder.findById(bookId);
        if (book.isPresent()) {
            bookRemover.remove(book.get().getId());
        }
    }
}
