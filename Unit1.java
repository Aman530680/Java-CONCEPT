
/**
 * Student Management System - UNIT 1 Example
 * This program uses: classes, objects, constructors,
 * methods, arrays, loops, I/O, wrapper classes & access modifiers.
 */

import java.util.Scanner; // For input
import java.util.Arrays; // For sorting array

// CLASS: Student (User-Defined Data Type)
class Student {

    // Private data members → Encapsulation
    private int id;
    private String name;
    private double marks;

    // Constructor (Parameterized)
    public Student(int id, String name, double marks) {
        this.id = id;
        this.name = name;
        this.marks = marks;
    }

    // Getter method (Abstraction)
    public double getMarks() {
        return marks;
    }

    // Method to display student details
    public void display() {
        System.out.println(id + "  " + name + "  " + marks);
    }
}

// MAIN CLASS
public class Unit1 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in); // Scanner for user input

        // Array of Student objects
        System.out.print("Enter number of students: ");
        int n = sc.nextInt();

        Student[] students = new Student[n]; // Array of objects

        // Input using loop
        for (int i = 0; i < n; i++) {
            System.out.println("\nEnter details of Student " + (i + 1));

            System.out.print("Enter ID: ");
            int id = sc.nextInt();

            sc.nextLine(); // Clear buffer
            System.out.print("Enter Name: ");
            String name = sc.nextLine();

            System.out.print("Enter Marks: ");
            double marks = sc.nextDouble();

            students[i] = new Student(id, name, marks); // Object creation
        }

        System.out.println("\n--- Student Details ---");
        for (Student s : students) {
            s.display(); // Calling object method
        }

        // Sorting based on marks (Wrapper class Double used internally)
        Arrays.sort(students, (a, b) -> Double.compare(a.getMarks(), b.getMarks()));

        System.out.println("\n--- Students Sorted by Marks ---");
        for (Student s : students) {
            s.display();
        }

        sc.close(); // Closing scanner
    }
}
