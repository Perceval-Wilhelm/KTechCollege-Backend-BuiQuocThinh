package Bai1;

public class CourseOnline extends Course {
    // Init variables
    private String platform;
    private int duration;

    // Constructor
    public CourseOnline(String platform, int duration) {
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
}
