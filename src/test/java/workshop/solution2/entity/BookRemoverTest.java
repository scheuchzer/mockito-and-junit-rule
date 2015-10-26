package workshop.solution2.entity;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;
import workshop.entity.Book;
import workshop.entity.BookRemover;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created by tho on 26.10.2015.
 */
public class BookRemoverTest {

    @Rule
    public TemporaryFolder tempFolders = new TemporaryFolder();

    @Test
    public void testRemove() throws IOException {
        File baseDir = tempFolders.newFolder();
        new ObjectMapper().writeValue(new File(baseDir, "book_123.json"), new Book(123L, "JUnitRules for Dummies", Arrays.asList("Max", "Moritz")));
        assertThat(baseDir.list().length, is(1));
        new BookRemover(baseDir).remove(123L);
        assertThat(baseDir.list().length, is(0));
    }
}
