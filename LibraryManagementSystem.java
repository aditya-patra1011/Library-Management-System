import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;

public class LibraryManagementSystem extends JFrame implements ActionListener {

    JTextField bookIdField, titleField, authorField;
    JTextArea displayArea;

    JButton addBtn, issueBtn, returnBtn, viewBtn, saveBtn;

    ArrayList<String> books = new ArrayList<>();

    public LibraryManagementSystem() {

        setTitle("Library Management System");
        setSize(650, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));

        // ===== HEADER =====
        JLabel header = new JLabel("Library Management System", JLabel.CENTER);
        header.setFont(new Font("Segoe UI", Font.BOLD, 28));
        header.setOpaque(true);
        header.setBackground(new Color(67, 160, 71));
        header.setForeground(Color.WHITE);
        header.setBorder(BorderFactory.createEmptyBorder(15, 10, 15, 10));
        add(header, BorderLayout.NORTH);

        // ===== FORM PANEL =====
        JPanel formPanel = new JPanel(new GridLayout(3, 2, 10, 10));
        formPanel.setBorder(BorderFactory.createTitledBorder("Book Details"));

        bookIdField = new JTextField();
        titleField = new JTextField();
        authorField = new JTextField();

        formPanel.add(new JLabel("Book ID:"));
        formPanel.add(bookIdField);
        formPanel.add(new JLabel("Book Title:"));
        formPanel.add(titleField);
        formPanel.add(new JLabel("Author Name:"));
        formPanel.add(authorField);

        // ===== BUTTON PANEL =====
        JPanel buttonPanel = new JPanel(new GridLayout(1, 5, 10, 10));

        addBtn = new JButton("Add Book");
        issueBtn = new JButton("Issue Book");
        returnBtn = new JButton("Return Book");
        viewBtn = new JButton("View Books");
        saveBtn = new JButton("Save to File");

        JButton[] buttons = { addBtn, issueBtn, returnBtn, viewBtn, saveBtn };

        for (JButton btn : buttons) {
            btn.setFont(new Font("Segoe UI", Font.BOLD, 13));
            btn.setFocusPainted(false);
            btn.addActionListener(this);
            buttonPanel.add(btn);
        }

        JPanel topPanel = new JPanel(new BorderLayout(10, 10));
        topPanel.add(formPanel, BorderLayout.CENTER);
        topPanel.add(buttonPanel, BorderLayout.SOUTH);
        topPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        add(topPanel, BorderLayout.CENTER);

        // ===== DISPLAY AREA =====
        displayArea = new JTextArea();
        displayArea.setFont(new Font("Consolas", Font.PLAIN, 14));
        displayArea.setEditable(false);
        displayArea.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JScrollPane scrollPane = new JScrollPane(displayArea);
        scrollPane.setBorder(BorderFactory.createTitledBorder("Library Records"));

        add(scrollPane, BorderLayout.SOUTH);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {

        try {
            if (e.getSource() == addBtn) {
                String book = "ID: " + bookIdField.getText()
                        + " | Title: " + titleField.getText()
                        + " | Author: " + authorField.getText();

                if (bookIdField.getText().isEmpty() ||
                        titleField.getText().isEmpty() ||
                        authorField.getText().isEmpty()) {
                    throw new Exception();
                }

                books.add(book);
                displayArea.append("Book Added Successfully\n" + book + "\n\n");
                clearFields();
            }

            else if (e.getSource() == issueBtn) {
                String id = bookIdField.getText();
                boolean found = false;

                for (String book : books) {
                    if (book.contains("ID: " + id)) {
                        displayArea.append("Book Issued: " + book + "\n\n");
                        books.remove(book);
                        found = true;
                        break;
                    }
                }

                if (!found) {
                    JOptionPane.showMessageDialog(this, "Book Not Found!");
                }
                clearFields();
            }

            else if (e.getSource() == returnBtn) {
                String book = "ID: " + bookIdField.getText()
                        + " | Title: " + titleField.getText()
                        + " | Author: " + authorField.getText();

                books.add(book);
                displayArea.append("Book Returned Successfully\n" + book + "\n\n");
                clearFields();
            }

            else if (e.getSource() == viewBtn) {
                displayArea.append("---- ALL BOOKS ----\n");
                for (String book : books) {
                    displayArea.append(book + "\n");
                }
                displayArea.append("\n");
            }

            else if (e.getSource() == saveBtn) {
                FileWriter fw = new FileWriter("library_records.txt");
                fw.write(displayArea.getText());
                fw.close();
                JOptionPane.showMessageDialog(this, "Data Saved Successfully!");
            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Please Enter Valid Details!");
        }
    }

    void clearFields() {
        bookIdField.setText("");
        titleField.setText("");
        authorField.setText("");
    }

    public static void main(String[] args) {
        new LibraryManagementSystem();
    }
}
