/**
 * Represents an attendance record in the system.
 */
public class Attendance {
    private String attendanceId;
    private String date;
    private String status;
    private String studentId;
    private String courseId;

    public Attendance(String attendanceId, String date, String status, String studentId, String courseId) {
        this.attendanceId = attendanceId;
        this.date = date;
        this.status = status;
        this.studentId = studentId;
        this.courseId = courseId;
    }

    @Override
    public String toString() {
        return attendanceId + "," + date + "," + status + "," + studentId + "," + courseId;
    }
}
