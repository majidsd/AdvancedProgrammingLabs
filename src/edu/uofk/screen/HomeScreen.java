package edu.uofk.screen;

import edu.uofk.data.BookDAO;
import edu.uofk.data.model.Book;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class HomeScreen {
    private final JFrame screenFrame;

    private final JTable booksTable;

    private final JLabel titleLabel;
    private final JTextField titleField;

    private final JLabel authorLabel;
    private final JTextField authorField;

    public HomeScreen() {
        screenFrame = new JFrame("Home Screen");
        screenFrame.setSize( 720, 720);
        screenFrame.setLocationRelativeTo(null); // This to put the login screen into the middle of the computer screen
        screenFrame.setLayout(null);
        screenFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        screenFrame.getContentPane().setBackground(Color.gray);
        screenFrame.setResizable(false); // don't allow a user to maximize the screen

        titleLabel = new JLabel("Title");
        titleLabel.setBounds(80, 80, 75, 25);
        titleLabel.setForeground(Color.WHITE);
        screenFrame.add(titleLabel);

        titleField = new JTextField();
        titleField.setBounds(160, 80, 400, 25);
        screenFrame.add(titleField);

        authorLabel = new JLabel("Author");
        authorLabel.setBounds(80, 120, 75, 25);
        authorLabel.setForeground(Color.WHITE);
        screenFrame.add(authorLabel);

        authorField = new JTextField();
        authorField.setBounds(160, 120, 400, 25);
        screenFrame.add(authorField);

        // books table
        String[] columnNames = { "Title", "Name" };
        List<Book> books = BookDAO.getBooks();
        String[][] booksItems = new String[books.size()][]; // We need 2 dimension array to add the data to JTable
        for (int i=0; i<books.size(); i++){
            booksItems[i] = books.get(i).toArrayStrings();
        }

        booksTable = new JTable(booksItems, columnNames);
        booksTable.setBounds(20, 180, 660, 300);
        // adding it to JScrollPane
        JScrollPane scrollPane = new JScrollPane(booksTable);
        scrollPane.setBounds(20, 180, 660, 300);
        screenFrame.add(scrollPane);

        screenFrame.setVisible(true);
    }
}
