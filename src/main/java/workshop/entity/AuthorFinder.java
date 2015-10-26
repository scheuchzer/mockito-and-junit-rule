package workshop.entity;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.util.Optional;

public class AuthorFinder {
    private static final Logger LOGGER = LoggerFactory.getLogger(AuthorFinder.class);

    private File baseDir;

    public AuthorFinder(File baseDir) {
        this.baseDir = baseDir;
    }

    public Optional<Author> findById(String id) {
        try {
            File file = new File(baseDir, "author_" + id + ".json");
            LOGGER.info("Loading file={}", file.getAbsolutePath());
            return Optional.of(new ObjectMapper().readValue(file, Author.class));
        } catch (Exception e) {
            LOGGER.info("Book not found. id={}", id, e);
            return Optional.empty();
        }

    }

    public Author getById(String id) {
        Optional<Author> author = findById(id);
        if (author.isPresent()) {
            return author.get();
        } else {
            throw new IllegalArgumentException("No author with id " + id + " found.");
        }
    }
}
