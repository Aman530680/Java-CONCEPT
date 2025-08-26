import java.util.Scanner;
public class StaticExample {
    static String collegeName = "SRI Eshwar College";
    String name;
    int age;
    static {
        System.out.println("Welcome to the Student Registration Program!");
        System.out.println("College: " + collegeName);
    }
    public StaticExample(String name, int age) {
        this.name = name;
        this.age = age;
    }
    static void changeCollege(String newCollege) {
        collegeName = newCollege;
    }
    void display() {
        System.out.println("Student Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("College: " + collegeName);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter your name: ");
        String name = sc.nextLine();
        System.out.print("Enter your age: ");
        int age = sc.nextInt();
        sc.nextLine();
        System.out.print("Do you want to change the college name? (yes/no): ");
        String choice = sc.nextLine();
        if (choice.equalsIgnoreCase("yes")) {
            System.out.print("Enter new college name: ");
            String newCollege = sc.nextLine();
            StaticExample.changeCollege(newCollege); 
        }
        StaticExample student = new StaticExample(name, age);
        student.display();
        sc.close();
    }
}
 