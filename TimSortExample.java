import java.util.*;

class Student {
    private int id;
    private String branch;
    private double cgpa;

    public Student(int id, String branch, double cgpa) {
        this.id = id;
        this.branch = branch;
        this.cgpa = cgpa;
    }

    public int getId() {
        return id;
    }

    public String getBranch() {
        return branch;
    }

    public double getCgpa() {
        return cgpa;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Branch: " + branch + ", CGPA: " + cgpa;
    }
}

public class TimSortExample {

    public static void main(String[] args) {

        ArrayList<Student> students = new ArrayList<>();

        students.add(new Student(101, "CSE", 8.5));
        students.add(new Student(102, "IT", 9.1));
        students.add(new Student(103, "CSE", 9.1));
        students.add(new Student(104, "ECE", 8.5));

        Collections.sort(students, new Comparator<Student>() {
            @Override
            public int compare(Student s1, Student s2) {

                if (Double.compare(s1.getCgpa(), s2.getCgpa()) != 0) {
                    return Double.compare(s2.getCgpa(), s1.getCgpa());
                }

                int result = s1.getBranch().compareTo(s2.getBranch());
                if (result != 0) {
                    return result;
                }

                return Integer.compare(s1.getId(), s2.getId());
            }
        });

        System.out.println("Sorted Students:");
        for (Student s : students) {
            System.out.println(s);
        }
    }
}