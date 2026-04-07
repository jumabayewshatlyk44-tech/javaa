class Library {

    // Inner class
    class Book {
        String title;

        // Constructor
        Book(String title) {
            this.title = title;
        }

        // Method to print book title
        void printTitle() {
            System.out.println("Кітап атауы: " + title);
        }
    }

    public static void main(String[] args) {
        // Create Library object
        Library library = new Library();

        // Create Book object (inner class арқылы)
        Library.Book book = library.new Book("Абай жолы");

        // Call method
        book.printTitle();
    }
}