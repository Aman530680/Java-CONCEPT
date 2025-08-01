import java.io.*;
import java.util.*;

public class AttendanceManagementSystem {
    private static final String STUDENT_FILE= "students.txt";
       private static final String COURSE_FILE="courses.txt";
private static final String ATTENDANCE_FILE="attendance.txt";
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int choice;
        do {
            System.out.println("\n Attendance Management System");
            System.out.println("1.Add Student");
            System.out.println("2.Add Course");
            System.out.println("3. Mark Attendance");
            System.out.println("4.View Attendance Records");
            System.out.println("5.Exit");
            System.out.print("Enter your choice: ");

            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    addStudent(scanner);
                    break;
                case 2:
                    addCourse(scanner);
                    break;
                case 3:
                    markAttendance(scanner);
                    break;
                case 4:
                    viewAttendance(scanner);
                    break;
                case 5:
                    System.out.println("Exiting Thank you!");
                    break;
                default:
                    System.out.println("Invalid choice.Try again.");
            }

        } while (choice!=5);

        scanner.close();
    }

    // Add a new student
    private static void addStudent(Scanner scanner) {
        try {
            System.out.print("Enter Student ID:");
            String id = scanner.nextLine();
            if (recordExists(STUDENT_FILE, id)) {
                System.out.println("Student ID already exists!");
                return;
            }
            System.out.print("Enter Name:");
            String name = scanner.nextLine();
            System.out.print("Enter Department:");
            String dept = scanner.nextLine();
            System.out.print("Enter Year:");
            String year = scanner.nextLine();
            System.out.print("Enter Email:");
            String email = scanner.nextLine();
            Student student = new Student(id,name,dept,year,email);
            writeRecord(STUDENT_FILE, student.toString());
            System.out.println("Student added successfully.");
        } catch (IOException e) {
            System.out.println("Error adding student: "+e.getMessage());
        }
    }
    // Add a new course
    private static void addCourse(Scanner scanner) {
        try {
            System.out.print("Enter Course ID:");
            String id = scanner.nextLine();
            if (recordExists(COURSE_FILE,id)) {
                System.out.println("Course ID already exists!");
                return;
            }
            System.out.print("Enter Course Name:");
            String name=scanner.nextLine();
            System.out.print("Enter Instructor Name:");
            String instructor=scanner.nextLine();
            Course course=new Course(id,name,instructor);
            writeRecord(COURSE_FILE,course.toString());
            System.out.println("Course added successfully.");
        } catch (IOException e) {
            System.out.println("Error adding course: " + e.getMessage());
        }
    }
    // Mark attendance
    private static void markAttendance(Scanner scanner) {
        try {
            System.out.print("Enter Attendance ID:");
            String attendanceId=scanner.nextLine();
            System.out.print("Enter Date (YYYY-MM-DD):");
            String date=scanner.nextLine();
            System.out.print("Enter Status (P/A):");
            String status=scanner.nextLine().toUpperCase();
            System.out.print("Enter Student ID:");
            String studentId=scanner.nextLine();
            System.out.print("Enter Course ID:");
            String courseId=scanner.nextLine();
            if (!recordExists(STUDENT_FILE,studentId)) {
                System.out.println("Student ID does not exist.");
                return;
            }
            if (!recordExists(COURSE_FILE,courseId)) {
                System.out.println("Course ID does not exist.");
                return;
            }
            Attendance attendance=new Attendance(attendanceId,date,status,studentId,courseId);
            writeRecord(ATTENDANCE_FILE,attendance.toString());
            System.out.println("Attendance marked successfully.");
        } catch (IOException e){
            System.out.println("Error marking attendance: "+e.getMessage());
        }
    }
    // View attendance records by student, course, or date
    private static void viewAttendance(Scanner scanner) {
        try {
            System.out.println("View by: 1)Student ID  2)Course ID  3)Date");
            System.out.print("Enter option:");
            int opt=scanner.nextInt();
            scanner.nextLine();
            System.out.print("Enter search value: ");
            String value=scanner.nextLine();

            BufferedReader reader=new BufferedReader(new FileReader(ATTENDANCE_FILE));
            String line;
            boolean found=false;

            while ((line=reader.readLine())!=null) {
                String[] parts=line.split(",");
                switch (opt){
                    case 1:if(parts[3].equals(value)){System.out.println(line);found=true;}break;
                    case 2: if (parts[4].equals(value)){System.out.println(line);found=true;}break;
                    case 3:if(parts[1].equals(value)){System.out.println(line);found=true;} break;
                }
            }
            reader.close();
            if (!found)System.out.println("No records found");
        } catch (IOException e){
            System.out.println("Error reading attendance:"+e.getMessage());
        }
    }
    // write a line to file in append mode
    private static void writeRecord(String fileName,String record)throws IOException {
        BufferedWriter writer=new BufferedWriter(new FileWriter(fileName,true));
        writer.write(record);
        writer.newLine();
        writer.close();
    }
    //  check if an ID already exists in a file
    private static boolean recordExists(String fileName,String id) throws IOException {
        File file = new File(fileName);
        if (!file.exists()) return false;
        BufferedReader reader=new BufferedReader(new FileReader(fileName));
        String line;
        while ((line=reader.readLine())!=null) {
            if (line.startsWith(id+",")) {
                reader.close();
                return true;
            }
        }
        reader.close();
        return false;
    }
} 