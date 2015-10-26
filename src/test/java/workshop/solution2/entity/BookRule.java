package workshop.solution2.entity;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Assert;
import org.junit.rules.ExternalResource;
import org.junit.rules.TemporaryFolder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import workshop.entity.Book;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by tho on 26.10.2015.
 */
public class BookRule extends ExternalResource {

    private Logger LOGGER = LoggerFactory.getLogger(BookRule.class);

    private List<File> files = new ArrayList<>();

    private File baseDir;
    private TemporaryFolder tmpFolders = new TemporaryFolder();

    public BookRule(TemporaryFolder tmpFolders) {
        this.tmpFolders = tmpFolders;
    }

    public Book newBook(Long id, String title, String... authorIds) {
        try {
            Book book = new Book(id, title, Arrays.asList(authorIds));
            File file = new File(baseDir, "book_" + id + ".json");
            files.add(file);
            new ObjectMapper().writeValue(file, book);
            return book;
        } catch (Exception e) {
            Assert.fail(e.getMessage());
            return null;
        }
    }

    public File getBaseDir() {
        return baseDir;
    }

    @Override
    protected void before() throws Throwable {
        this.baseDir = tmpFolders.newFolder();
    }

    @Override
    protected void after() {
        files.forEach((f) -> {
            if(f.exists()) {
                LOGGER.info("Cleaning file={}", f.getAbsolutePath());
                f.delete();
            }
        });
    }
}
