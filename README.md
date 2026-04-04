# 📚 Library Management System

A simple desktop-based **Library Management System** built with **Java Swing**. It allows users to add, issue, return, and view books through a clean graphical user interface, with the option to save records to a file.

---

## 🖥️ Features

- **Add Book** – Register a new book with ID, title, and author name
- **Issue Book** – Issue a book by its ID (removes it from the available list)
- **Return Book** – Return a previously issued book back to the library
- **View Books** – Display all currently available books
- **Save to File** – Save all library records to a `library_records.txt` file

---

## 🛠️ Tech Stack

- **Language:** Java
- **GUI Framework:** Java Swing (javax.swing)
- **File I/O:** java.io.FileWriter
- **Data Structure:** ArrayList

---

## 📋 Prerequisites

- Java Development Kit (JDK) **8 or above**
- Any Java IDE (IntelliJ IDEA, Eclipse, NetBeans) or terminal with `javac`

---

## 🚀 How to Run

### Using Terminal / Command Prompt

1. **Clone the repository**
   ```bash
   git clone https://github.com/your-username/library-management-system.git
   cd library-management-system
   ```

2. **Compile the code**
   ```bash
   javac LibraryManagementSystem.java
   ```

3. **Run the application**
   ```bash
   java LibraryManagementSystem
   ```

### Using an IDE

1. Open the project in your preferred Java IDE
2. Locate `LibraryManagementSystem.java`
3. Click **Run** or press `Shift + F10`

---

## 🗂️ Project Structure

```
library-management-system/
│
├── LibraryManagementSystem.java   # Main source file
├── library_records.txt            # Auto-generated on saving records
└── README.md                      # Project documentation
```

---

## 📸 Application Overview

| Field       | Description                        |
|-------------|------------------------------------|
| Book ID     | Unique identifier for the book     |
| Book Title  | Name/title of the book             |
| Author Name | Name of the book's author          |

### Buttons

| Button        | Action                                           |
|---------------|--------------------------------------------------|
| Add Book      | Adds the book to the in-memory library list      |
| Issue Book    | Removes the book from the list (marks as issued) |
| Return Book   | Re-adds the book back to the list                |
| View Books    | Displays all available books in the record area  |
| Save to File  | Saves all displayed records to a `.txt` file     |

---

## ⚠️ Validation

- All three fields (Book ID, Title, Author) must be filled before adding or returning a book
- If any field is empty, a dialog box will prompt: **"Please Enter Valid Details!"**
- If a book ID is not found during issuing, a dialog will show: **"Book Not Found!"**

---

## 📄 Output File

On clicking **Save to File**, all records from the display area are saved to:
```
library_records.txt
```
This file is created in the same directory where the program is run.

---

## 👨‍💻 Author

**M. Aditya Patra**  

---

