package workshop.entity;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.util.Optional;

public class BookFinder {

    private static final Logger LOGGER = LoggerFactory.getLogger(BookFinder.class);
    private File baseDir;

    public BookFinder(File baseDir) {
        this.baseDir = baseDir;
    }

    public Optional<Book> findById(Long id) {
        try {
            File file = new File(baseDir, "book_" + id + ".json");
            LOGGER.info("Loading file={}", file.getAbsolutePath());
            return Optional.of(new ObjectMapper().readValue(file, Book.class));
        } catch (Exception e) {
            LOGGER.info("Book not found. id={}", id, e);
            return Optional.empty();
        }

    }

    public Book getById(Long id) {
        Optional<Book> book = findById(id);
        if (book.isPresent()) {
            return book.get();
        } else {
            throw new IllegalArgumentException("No book with id " + id + " found.");
        }
    }
}
