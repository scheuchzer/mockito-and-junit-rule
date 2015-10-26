package workshop.solution2.control;

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

/**
 * Created by tho on 26.10.2015.
 */
public class BookControllerIT {

    @Rule
    public TemporaryFolder tempFolders = new TemporaryFolder();
    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void testGetOverview() throws IOException {
        File baseDir = tempFolders.newFolder();
        new ObjectMapper().writeValue(new File(baseDir, "book_111.json"), new Book(111L, "JUnitRules for Dummies", Arrays.asList("a1")));
        new ObjectMapper().writeValue(new File(baseDir, "author_a1.json"), new Author("a1", "Foo Bar"));

        BookOverview actual = new BookController(baseDir).getOverview(111L);
        assertThat(actual, is(not(nullValue())));
        assertThat(actual.getTitle(), is("JUnitRules for Dummies"));
        assertThat(actual.getAuthorNames().get(0), is("Foo Bar"));
    }

    @Test
    public void testGetOverviewNotFound() throws IOException {
        File baseDir = tempFolders.newFolder();
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("111");
        new BookController(baseDir).getOverview(111L);
    }
}
