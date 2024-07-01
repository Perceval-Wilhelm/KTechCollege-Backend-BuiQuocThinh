package Bai1.Model;

public class CourseOnline extends Course {
    // Init variables
    private String platform;
    private int duration;

    // Constructor
    public CourseOnline(int courseId, String courseName, String mentorName, int credit, String platform, int duration) {
        super(courseId, courseName, mentorName, credit);
        this.platform = platform;
        this.duration = duration;
    }

    // Getters and Setters
    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public CourseOnline getCourseOnline() {
        return this;
    }

    // Display course in detail
    @Override
    public void showCourseInDetail(){
        System.out.println("Course ID: " + super.getCourseId() + ", Course name: " + super.getCourseName() + ", Mentor Name: " + super.getMentorName() + ", Credit: " + super.getCredit() + ", Platform: " + platform + ", Duration: " + duration);
    }
}
