import models.Author;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AuthorTest {

    Author author1;
    Author author2;

    @Before
    public void before(){
        author1 = new Author("Irvine", "Welsh");
        author2 = new Author("J.K", "Rowling");
    }

    @Test
    public void canGetFirstName(){
        assertEquals("Irvine", author1.getFirstName());
    }

    @Test
    public void canGetLastName(){
        assertEquals("Rowling", author2.getLastName());
    }
}
