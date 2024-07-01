package Bai1.Model;

public abstract class Course {
    // Init variables
    private int courseId;
    private String courseName;
    private String mentorName;
    private int credit;

    // Constructor
    public Course(int courseId, String courseName, String mentorName, int credit) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.mentorName = mentorName;
        this.credit = credit;
    }

    // Getters and Setters
    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getMentorName() {
        return mentorName;
    }

    public void setMentorName(String mentorName) {
        this.mentorName = mentorName;
    }

    public int getCredit() {
        return credit;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }

    // Display course in detail
    public void showCourseInDetail(){
        System.out.println("Course ID: " + courseId + ", Course name: " + courseName + ", Mentor Name: " + mentorName + ", Credit: " + credit);
    }
}
