package workshop.exercise1.control;

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
public class BookControllerCDITest {

    @Test
    public void testGetOverview() {
        /**
         * TODO: Load the overview of the book with id 222. stub calls to bookFinder and authorFinder.
         */

        BookOverview actual = null;//bookController.getOverview(222L);
        assertThat(actual.getTitle(), is("TestBook"));
        assertThat(actual.getAuthorNames().get(0), is("Mario"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetOverviewBookNotFound() {
        /**
         * TODO: Throw an IllegalArgumentException for  any call to the bookFinder
         */
        //bookController.getOverview(222L);
    }

    @Test
    public void testDelete() {
        /**
         * TODO: stub calls to bookFinder. Verify that the bookRemover gets called.
         */
        //bookController.delete(111L);
    }
}
