package workshop.solution1.control;

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
@RunWith(MockitoJUnitRunner.class)
public class BookControllerTest {

    @Mock
    private BookFinder bookFinder;
    @Mock
    private AuthorFinder authorFinder;
    @InjectMocks
    private BookController bookController = new BookController(null);

    @Test
    public void testGetOverview() {
        when(bookFinder.getById(eq(222L))).thenReturn(new Book(222L, "TestBook", Arrays.asList("author1")));
        when(authorFinder.getById(eq("author1"))).thenReturn(new Author("author1", "Mario"));
        BookOverview actual = bookController.getOverview(222L);
        assertThat(actual.getTitle(), is("TestBook"));
        assertThat(actual.getAuthorNames().get(0), is("Mario"));

    }
}
