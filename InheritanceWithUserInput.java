import java.util.Scanner;

class Employee {
    String name;
    int empId;
    double salary;

    void setDetails(String name, int empId, double salary) {
        this.name = name;
        this.empId = empId;
        this.salary = salary;
    }

    void displayDetails() {
        System.out.println("Employee Name: " + name);
        System.out.println("Employee ID: " + empId);
        System.out.println("Salary: " + salary);
    }
}

class Manager extends Employee {
    String department;

    void setDepartment(String department) {
        this.department = department;
    }

    void displayManagerDetails() {
        displayDetails();
        System.out.println("Department: " + department);
    }
}

public class InheritanceWithUserInput {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Manager mgr = new Manager();

        System.out.print("Enter employee name: ");
        String name = sc.nextLine();

        System.out.print("Enter employee ID: ");
        int empId = sc.nextInt();

        System.out.print("Enter salary: ");
        double salary = sc.nextDouble();
        sc.nextLine(); // consume leftover newline

        System.out.print("Enter department: ");
        String department = sc.nextLine();

        mgr.setDetails(name, empId, salary);
        mgr.setDepartment(department);

        System.out.println("\n--- Manager Details ---");
        mgr.displayManagerDetails();

        sc.close();
    }
}
