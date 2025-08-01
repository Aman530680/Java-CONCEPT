/**
 * Represents a student in the system.
 */
public class Student {
    private String studentId;
    private String name;
    private String department;
    private String year;
    private String email;

    public Student(String studentId, String name, String department, String year, String email) {
        this.studentId = studentId;
        this.name = name;
        this.department = department;
        this.year = year;
        this.email = email;
    }

    public String getStudentId() {
        return studentId;
    }

    @Override
    public String toString() {
        return studentId + "," + name + "," + department + "," + year + "," + email;
    }
}