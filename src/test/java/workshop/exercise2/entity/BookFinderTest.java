package workshop.exercise2.entity;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;
import workshop.entity.Book;
import workshop.entity.BookFinder;

import java.io.File;
import java.util.Optional;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertThat;

/**
 * Created by tho on 26.10.2015.
 */
public class BookFinderTest {

    @Rule
    public TemporaryFolder tempFolders = new TemporaryFolder();

    @Test
    public void testFindById() throws JsonProcessingException {
        /**
         * TODO: Refactor to JUnit Rules. Don't rely on files in the resources dir anymore. Maybe event write your own JUnit Rule!
         */
        File baseDir = new File("./src/test/resources");
        Optional<Book> actual = new BookFinder(baseDir).findById(123L);
        assertThat(actual, is(not(nullValue())));
        assertThat(actual.get(), is(not(nullValue())));
        assertThat(actual.get().getTitle(), is("Test"));
        assertThat(actual.get().getAuthors().size(), is(2));
    }

    @Test
    public void testFindByIdUnknownId() throws JsonProcessingException {
        /**
         * TODO: Refactor to JUnit Rules. Don't rely on files in the resources dir.
         */
        File baseDir = new File("./src/test/resources");
        Optional<Book> actual = new BookFinder(baseDir).findById(666L);
        assertThat(actual, is(not(nullValue())));
    }
}
