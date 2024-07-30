import java.util.Arrays;
import java.util.Comparator;

public class LibraryManagementSystem {

    // Book class to represent book details
    public static class Book {
        private String bookId;
        private String title;
        private String author;

        public Book(String bookId, String title, String author) {
            this.bookId = bookId;
            this.title = title;
            this.author = author;
        }

        // Getters and toString method
        public String getBookId() {
            return bookId;
        }

        public String getTitle() {
            return title;
        }

        public String getAuthor() {
            return author;
        }

        @Override
        public String toString() {
            return "Book{" +
                    "bookId='" + bookId + '\'' +
                    ", title='" + title + '\'' +
                    ", author='" + author + '\'' +
                    '}';
        }
    }

    // Linear search implementation
    public static Book linearSearchByTitle(Book[] books, String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                return book;
            }
        }
        return null; // Book not found
    }

    // Binary search implementation
    public static Book binarySearchByTitle(Book[] books, String title) {
        int left = 0;
        int right = books.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int comparison = books[mid].getTitle().compareToIgnoreCase(title);

            if (comparison == 0) {
                return books[mid]; // Book found
            } else if (comparison < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return null; // Book not found
    }

    public static void main(String[] args) {
        // Sample books
        Book[] books = {
            new Book("1", "The Catcher in the Rye", "J.D. Salinger"),
            new Book("2", "To Kill a Mockingbird", "Harper Lee"),
            new Book("3", "1984", "George Orwell"),
            new Book("4", "The Great Gatsby", "F. Scott Fitzgerald"),
            new Book("5", "Moby Dick", "Herman Melville")
        };

        // Sort books by title for binary search
        Arrays.sort(books, Comparator.comparing(Book::getTitle, String.CASE_INSENSITIVE_ORDER));

        // Search for books using linear search
        String titleToSearchLinear = "1984";
        System.out.println("Linear Search:");
        Book foundBookLinear = linearSearchByTitle(books, titleToSearchLinear);
        System.out.println(foundBookLinear != null ? foundBookLinear : "Book not found.");

        // Search for books using binary search
        String titleToSearchBinary = "1984";
        System.out.println("\nBinary Search:");
        Book foundBookBinary = binarySearchByTitle(books, titleToSearchBinary);
        System.out.println(foundBookBinary != null ? foundBookBinary : "Book not found.");
    }
}

