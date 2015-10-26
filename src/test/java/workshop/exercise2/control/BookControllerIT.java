package workshop.exercise2.control;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.rules.TemporaryFolder;
import workshop.control.BookController;
import workshop.control.BookOverview;
import workshop.entity.Author;
import workshop.entity.Book;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

/**
 * Created by tho on 26.10.2015.
 */
public class BookControllerIT {

    @Test
    public void testGetOverview() throws IOException {
        /**
         * TODO: Refactor to JUnit Rules. Don't rely on files in the resources directory.
         */
        File baseDir = new File("./src/test/resources/exercise2");
        BookOverview actual = new BookController(baseDir).getOverview(111L);
        assertThat(actual, is(not(nullValue())));
        assertThat(actual.getTitle(), is("JUnitRules for Dummies"));
        assertThat(actual.getAuthorNames().get(0), is("Foo Bar"));
    }

    @Test
    public void testGetOverviewNotFound() throws IOException {
        /**
         * TODO: Refactor to JUnit Rules. Remove try/catch, find other ways to assert the error message.
         */
        File baseDir = new File(".");
        try {
            new BookController(baseDir).getOverview(111L);
        } catch(IllegalArgumentException e) {
            assertTrue(e.getMessage().contains("111"));
        }
    }
}
