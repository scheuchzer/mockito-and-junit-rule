package workshop.exercise1.control;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import workshop.control.BookController;
import workshop.control.BookOverview;
import workshop.entity.Author;
import workshop.entity.AuthorFinder;
import workshop.entity.Book;
import workshop.entity.BookFinder;

import java.util.Arrays;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.when;

/**
 * Created by tho on 26.10.2015.
 */
public class BookControllerTest {

    @Test
    public void testGetOverview() {
        /**
         * TODO: Load the overview of the book with id 222. stub calls to bookFinder and authorFinder.
         */

        BookOverview actual = null;//bookController.getOverview(222L);
        assertThat(actual.getTitle(), is("TestBook"));
        assertThat(actual.getAuthorNames().get(0), is("Mario"));
    }
}
