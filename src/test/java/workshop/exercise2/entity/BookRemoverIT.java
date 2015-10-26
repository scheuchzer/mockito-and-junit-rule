package workshop.exercise2.entity;

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
public class BookRemoverIT {

    @Test
    public void testRemove() throws IOException {
        /**
         * TODO: Refactor to JUnit Rules. Don't rely on files in the resources dir.
         */
        File baseDir = new File("./src/test/resources/exercise2");
        //assertThat(baseDir.list().length, is(1));
        //new BookRemover(baseDir).remove(123L);
        //assertThat(baseDir.list().length, is(0));
    }
}
