import models.Book;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BookTest {

    Book book1;
    Book book2;

    @Before
    public void before(){
        book1 = new Book("Trainspotting", 1993);
        book2 = new Book("Harry Potter and the Philosopher's Stone", 1997);
    }

    @Test
    public void canGetTitle(){
        assertEquals("Trainspotting", book1.getTitle());
    }

    @Test
    public void canGetReleaseYear(){
        assertEquals(1997, book2.getReleaseYear());
    }


}
