import db.DBAuthor;
import db.DBBook;
import models.Author;
import models.Book;

import java.util.List;

public class Runner {

    public static void main(String[] args) {
        Author author1 = new Author("Irvine", "Welsh");
        DBAuthor.save(author1);

        Author author2 = new Author("J.K", "Rowling");
        DBAuthor.save(author2);

        Book book1 = new Book("Trainspotting", 1993);
        DBBook.save(book1);

        Book book2 = new Book("Harry Potter and the Philosopher's Stone", 1997);
        DBBook.save(book2);

        List<Book> books = DBBook.getBooks();

        book2.setTitle("Gary Potter");
        DBBook.update(book2);

        Author foundAuthor = DBAuthor.find(author1.getId());
    }
}
