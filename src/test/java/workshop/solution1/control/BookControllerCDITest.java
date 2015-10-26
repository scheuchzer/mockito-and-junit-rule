package workshop.solution1.control;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import workshop.control.BookControllerCDI;
import workshop.control.BookOverview;
import workshop.entity.*;

import java.util.Arrays;
import java.util.Optional;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.anyLong;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.*;

/**
 * Created by tho on 26.10.2015.
 */
@RunWith(MockitoJUnitRunner.class)
public class BookControllerCDITest {

    @Mock
    private BookFinder bookFinder;
    @Mock
    private BookRemover bookRemover;
    @Mock
    private AuthorFinder authorFinder;
    @InjectMocks
    private BookControllerCDI bookController;

    @Test
    public void testGetOverview() {
        when(bookFinder.getById(eq(222L))).thenReturn(new Book(222L, "TestBook", Arrays.asList("author1")));
        when(authorFinder.getById(eq("author1"))).thenReturn(new Author("author1", "Mario"));
        BookOverview actual = bookController.getOverview(222L);
        assertThat(actual.getTitle(), is("TestBook"));
        assertThat(actual.getAuthorNames().get(0), is("Mario"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetOverviewBookNotFound() {
        when(bookFinder.getById(anyLong())).thenThrow(new IllegalArgumentException());
        bookController.getOverview(222L);
    }

    @Test
    public void testDelete() {
        when(bookFinder.findById(eq(111L))).thenReturn(Optional.of(new Book(111L, "TestBook", Arrays.asList("author1"))));
        bookController.delete(111L);
        verify(bookRemover, times(1)).remove(eq(111L));
        verifyNoMoreInteractions(bookRemover);
    }
}
