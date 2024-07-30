import java.util.Arrays;
import java.util.Scanner;

class Book {
    int bookId;
    String title;
    String author;

    public Book(int bookId, String title, String author) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
    }

    @Override
    public String toString() {
        return "Book ID: " + bookId + ", Title: " + title + ", Author: " + author;
    }
}

class LibraryManagementSystem {
    private Book[] books;
    private int bookCount;

    public LibraryManagementSystem(int capacity) {
        books = new Book[capacity];
        bookCount = 0;
    }

    public void addBook(int bookId, String title, String author) {
        if (bookCount >= books.length) {
            System.out.println("Library capacity reached. Cannot add more books.");
            return;
        }
        books[bookCount++] = new Book(bookId, title, author);
    }

    public Book linearSearchByTitle(String title) {
        for (int i = 0; i < bookCount; i++) {
            if (books[i].title.equalsIgnoreCase(title)) {
                return books[i];
            }
        }
        return null;
    }

    public Book binarySearchByTitle(String title) {
        int left = 0;
        int right = bookCount - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            int comparison = books[mid].title.compareToIgnoreCase(title);
            if (comparison == 0) {
                return books[mid];
            } else if (comparison < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return null;
    }

    public void sortBooksByTitle() {
        Arrays.sort(books, 0, bookCount, (b1, b2) -> b1.title.compareToIgnoreCase(b2.title));
    }

    public void displayBooks() {
        for (int i = 0; i < bookCount; i++) {
            System.out.println(books[i]);
        }
    }

    public static void main(String[] args) {
        LibraryManagementSystem library = new LibraryManagementSystem(10);
        Scanner scanner = new Scanner(System.in);

        library.addBook(1, "The Great Gatsby", "F. Scott Fitzgerald");
        library.addBook(2, "To Kill a Mockingbird", "Harper Lee");
        library.addBook(3, "1984", "George Orwell");
        library.addBook(4, "Pride and Prejudice", "Jane Austen");
        library.addBook(5, "The Catcher in the Rye", "J.D. Salinger");

        System.out.println("Library Inventory:");
        library.displayBooks();

        System.out.print("Enter title to search (Linear Search): ");
        String title = scanner.nextLine();
        Book foundBook = library.linearSearchByTitle(title);
        System.out.println(foundBook != null ? "Book found: " + foundBook : "Book not found.");

        library.sortBooksByTitle();

        System.out.print("Enter title to search (Binary Search): ");
        title = scanner.nextLine();
        foundBook = library.binarySearchByTitle(title);
        System.out.println(foundBook != null ? "Book found: " + foundBook : "Book not found.");

        scanner.close();
    }
}
