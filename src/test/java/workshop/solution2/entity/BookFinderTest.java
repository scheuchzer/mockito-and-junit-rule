package workshop.solution2.entity;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;
import workshop.entity.Book;
import workshop.entity.BookFinder;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Optional;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertThat;

/**
 * Created by tho on 26.10.2015.
 */
public class BookFinderTest {

    @Rule
    public TemporaryFolder tempFolders = new TemporaryFolder();

    @Rule
    public BookRule bookRule = new BookRule(tempFolders);

    @Test
    public void testFindById() throws IOException {
        File baseDir = tempFolders.newFolder();
        new ObjectMapper().writeValue(new File(baseDir, "book_123.json"), new Book(123L, "JUnitRules for Dummies", Arrays.asList("Max", "Moritz")));
        Optional<Book> actual = new BookFinder(baseDir).findById(123L);
        assertThat(actual, is(not(nullValue())));
        assertThat(actual.get(), is(not(nullValue())));
        assertThat(actual.get().getTitle(), is("JUnitRules for Dummies"));
        assertThat(actual.get().getAuthors().size(), is(2));
    }

    @Test
    public void testFindByIdWithRule() throws IOException {
        Book expected = bookRule.newBook(123L, "JUnitRules for Dummies", "Max", "Moritz");
        Optional<Book> actual = new BookFinder(bookRule.getBaseDir()).findById(123L);
        assertThat(actual, is(not(nullValue())));
        assertThat(actual.get(), is(not(nullValue())));
        assertThat(actual.get().getTitle(), is(expected.getTitle()));
        assertThat(actual.get().getAuthors().size(), is(expected.getAuthors().size()));
    }

    @Test
    public void testFindByIdUnknownId() throws IOException {
        File baseDir = tempFolders.newFolder();
        Optional<Book> actual = new BookFinder(baseDir).findById(666L);
        assertThat(actual, is(not(nullValue())));
    }

}
