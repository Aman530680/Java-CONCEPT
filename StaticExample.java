import java.util.Scanner;

public class StaticExample {
    // Static variable (shared by all objects)
    static String collegeName = "SRU Eshwar College";

    // Instance variables
    String name;
    int age;

    // Static block - runs once when the class is loaded
    static {
        System.out.println("Welcome to the Student Registration Program!");
        System.out.println("College: " + collegeName);
        System.out.println("--------------------------------------------");
    }

    // Constructor
    public StaticExample(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Static method
    static void changeCollege(String newCollege) {
        collegeName = newCollege;
    }

    // Instance method
    void display() {
        System.out.println("Student Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("College: " + collegeName);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Taking user input
        System.out.print("Enter your name: ");
        String name = sc.nextLine();

        System.out.print("Enter your age: ");
        int age = sc.nextInt();
        sc.nextLine(); // consume leftover newline

        System.out.print("Do you want to change the college name? (yes/no): ");
        String choice = sc.nextLine();

        if (choice.equalsIgnoreCase("yes")) {
            System.out.print("Enter new college name: ");
            String newCollege = sc.nextLine();
            StaticExample.changeCollege(newCollege); // calling static method
        }

        // Creating object with user input
        StaticExample student = new StaticExample(name, age);

        // Display details
        System.out.println("\n--- Student Details ---");
        student.display();

        sc.close();
    }
}
