import java.util.*;
import java.util.regex.*;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.stream.*;

// ----------------- BOOK CLASS (Comparable + String) -------------------
class Book implements Comparable<Book> {

    private String title;
    private String author;
    private int year;

    // Constructor
    Book(String title, String author, int year) {
        // Using String.trim() - String methods
        this.title = title.trim();
        this.author = author.trim();
        this.year = year;
    }

    public String getTitle() {
        return title;
    }

    public int getYear() {
        return year;
    }

    // Comparable for sorting by year
    @Override
    public int compareTo(Book b) {
        return this.year - b.year;
    }

    // ToString method
    public String toString() {
        return title + " by " + author + " (" + year + ")";
    }
}

// ---------- COMPARATOR (Lambda Expression Used Later) ----------------
class BookTitleComparator implements Comparator<Book> {
    public int compare(Book b1, Book b2) {
        return b1.getTitle().compareTo(b2.getTitle());
    }
}

// ------------------------ MAIN CLASS -----------------------------------
public class Unit3 {

    public static void main(String[] args) {

        System.out.println("--- STRING METHODS ---");
        String s = "  Java Collections  ";
        System.out.println("Original: [" + s + "]");
        System.out.println("Trimmed: " + s.trim());
        System.out.println("Upper: " + s.toUpperCase());
        System.out.println("Substring: " + s.substring(2, 6));

        System.out.println("\n--- STRINGBUILDER / STRINGBUFFER ---");
        StringBuilder sb = new StringBuilder("Hello");
        sb.append(" World");
        System.out.println("StringBuilder: " + sb);

        StringBuffer sbf = new StringBuffer("Java");
        sbf.append(" Program");
        System.out.println("StringBuffer: " + sbf);

        System.out.println("\n--- REGEX EXAMPLE: EMAIL VALIDATION ---");
        String email = "aman123@gmail.com";
        boolean valid = Pattern.matches("[a-zA-Z0-9._%+-]+@[a-z]+\\.[a-z]{2,3}", email);
        System.out.println("Email Valid: " + valid);

        System.out.println("\n--- COLLECTIONS WITH GENERICS (List<Book>) ---");

        List<Book> books = new ArrayList<>();
        books.add(new Book("C Programming", "Dennis Ritchie", 1980));
        books.add(new Book("Effective Java", "Joshua Bloch", 2008));
        books.add(new Book("Java Bible", "John", 2010));

        System.out.println("All Books:");
        books.forEach(System.out::println);

        System.out.println("\n--- SORTING USING COMPARABLE (Year) ---");
        Collections.sort(books);
        books.forEach(System.out::println);

        System.out.println("\n--- SORTING USING COMPARATOR (Title) ---");
        Collections.sort(books, new BookTitleComparator());
        books.forEach(System.out::println);

        System.out.println("\n--- LAMBDA EXPRESSION (Filter Books after 2005) ---");
        books.stream()
                .filter(b -> b.getYear() > 2005)
                .forEach(System.out::println);

        System.out.println("\n--- MAP COLLECTION (Book Title → Year) ---");
        Map<String, Integer> map = new HashMap<>();

        for (Book b : books)
            map.put(b.getTitle(), b.getYear());

        System.out.println(map);

        System.out.println("\n--- JAVA 8 DATE & TIME API ---");
        LocalDate today = LocalDate.now();
        System.out.println("Today: " + today);

        LocalDate returnDate = today.plusDays(14);
        System.out.println("Return After 14 Days: " + returnDate);

        DateTimeFormatter f = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        System.out.println("Formatted Return Date: " + returnDate.format(f));

        System.out.println("\n--- STREAMS (List to Upper Case) ---");
        List<String> titlesUpper = books.stream()
                .map(b -> b.getTitle().toUpperCase())
                .toList();

        System.out.println(titlesUpper);
    }
}
