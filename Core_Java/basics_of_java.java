// Basics of Java: Class, Object, State, and Methods
// Class representing a Book
class Book {
    // Instance variables (state)
    private String bookName;
    private String bookAuthor;

    public Book(String name, String author) {
        this.bookName = name;
        this.bookAuthor = author;
    }

    // Method to display student details
    public void display() {
        System.out.println("Book Name: " + bookName);
        System.out.println("Author Name: " + bookAuthor);
    }
}

class Main {
    public static void main(String[] args) {
        Book book1 = new Book("Harry Potter", "J K Rowling");

        book1.display();
    }
}