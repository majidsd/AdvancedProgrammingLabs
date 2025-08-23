package edu.uofk.data;

import edu.uofk.data.model.Book;

import java.util.Arrays;
import java.util.List;

public class BookDAO { // DAO is Data Access Object
    public static List<Book> getBooks() {
        return generateMockData();
    }

    // this is a database or network request
    private static List<Book> generateMockData() {
        return Arrays.asList(
                new Book("Java: The Complete Reference", "Herbert Schildt & Danny Coward"),
                new Book("Clean Code", "Robert C. Martin"),
                new Book("Fundamentals of Database Systems", "Ramez Elmasri & Shamkant B. Navathe")
        );
    }
}
