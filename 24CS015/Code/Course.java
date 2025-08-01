
public class Course {
    private String courseId;
    private String courseName;
    private String instructorName;

    public Course(String courseId, String courseName, String instructorName) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.instructorName = instructorName;
    }

    public String getCourseId() {
        return courseId;
    }

    @Override
    public String toString() {
        return courseId + "," + courseName + "," + instructorName;
    }
}