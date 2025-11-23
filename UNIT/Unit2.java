// -------------------------------
// UNIT 2 – OOPS MECHANISMS EXAMPLE
// Library Management System
// -------------------------------

// ASSOCIATION → Librarian is associated with Library
class Librarian {
    String name;

    Librarian(String name) {
        this.name = name;
    }

    void manageLibrary() {
        System.out.println(name + " is managing the library.");
    }
}

// BOOK CLASS → Used for Aggregation
class Book {
    String title;
    String author;

    Book(String title, String author) {
        this.title = title;
        this.author = author;
    }
}

// COMPOSITION → A Library has a Permanent Address (cannot exist without
// library)
class Address {
    String city;

    Address(String city) {
        this.city = city;
    }
}

// LIBRARY → Demonstrates Aggregation + Composition
class Library {
    Book[] books; // Aggregation (Books can exist without library)
    Address address; // Composition (Address belongs strongly to library)

    Library(Book[] books, String city) {
        this.books = books;
        this.address = new Address(city); // Composition
    }

    void showBooks() {
        System.out.println("\nBooks in Library:");
        for (Book b : books) {
            System.out.println(b.title + " by " + b.author);
        }
    }
}

// INHERITANCE (Base Class)
class Person {
    String name;

    Person(String name) {
        this.name = name;
    }

    void showRole() {
        System.out.println("Role: Person");
    }
}

// SINGLE INHERITANCE
class Student extends Person {
    Student(String name) {
        super(name);
    }

    @Override
    void showRole() { // Overriding (Runtime Polymorphism)
        System.out.println(name + " is a Student");
    }
}

// MULTILEVEL INHERITANCE
class GraduateStudent extends Student {
    GraduateStudent(String name) {
        super(name);
    }

    @Override
    void showRole() {
        System.out.println(name + " is a Graduate Student");
    }
}

// HIERARCHICAL INHERITANCE
class Teacher extends Person {
    Teacher(String name) {
        super(name);
    }

    @Override
    void showRole() {
        System.out.println(name + " is a Teacher");
    }
}

// ABSTRACT CLASS → Abstraction
abstract class Member {
    abstract void displayDetails();
}

// INTERFACE → For issuing books
interface Issueable {
    void issueBook();
}

// CLASS IMPLEMENTING ABSTRACT CLASS + INTERFACE
class MemberCard extends Member implements Issueable {
    String cardHolder;

    MemberCard(String cardHolder) {
        this.cardHolder = cardHolder;
    }

    @Override
    void displayDetails() {
        System.out.println("Card Holder: " + cardHolder);
    }

    @Override
    public void issueBook() {
        System.out.println(cardHolder + " issued a book.");
    }
}

// METHOD OVERLOADING → Compile-time polymorphism
class FeeCalculator {
    int calculate(int days) {
        return days * 2;
    }

    int calculate(int days, int fineRate) {
        return days * fineRate;
    }
}

// STATIC & FINAL DEMONSTRATION
class LibraryRules {
    static void showTiming() { // static method
        System.out.println("Library timing: 9 AM - 5 PM");
    }

    final void noFoodRule() { // final method -> cannot override
        System.out.println("No food allowed inside the library!");
    }
}

// MAIN CLASS
public class Unit2 {
    public static void main(String[] args) {

        // ASSOCIATION
        Librarian lib = new Librarian("Kumar");
        lib.manageLibrary();

        // AGGREGATION → Books can exist independently
        Book b1 = new Book("Java", "James Gosling");
        Book b2 = new Book("Python", "Guido");
        Book[] bookList = { b1, b2 };

        // COMPOSITION + AGGREGATION
        Library library = new Library(bookList, "Coimbatore");
        library.showBooks();

        // INHERITANCE + POLYMORPHISM
        Person p1 = new Student("Aman");
        Person p2 = new Teacher("Rahul");
        Person p3 = new GraduateStudent("Kishore");

        System.out.println("\nRoles:");
        p1.showRole(); // Runtime polymorphism
        p2.showRole();
        p3.showRole();

        // ABSTRACT CLASS + INTERFACE
        MemberCard card = new MemberCard("Aman");
        card.displayDetails();
        card.issueBook();

        // OVERLOADING
        FeeCalculator fee = new FeeCalculator();
        System.out.println("\nFee = " + fee.calculate(5));
        System.out.println("Fee with fine = " + fee.calculate(5, 10));

        // STATIC & FINAL
        LibraryRules.showTiming();
        LibraryRules rules = new LibraryRules();
        rules.noFoodRule();
    }
}
