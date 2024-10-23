package Stream;

import java.time.LocalDate;

public class CourseEngagement {
    private final Course course;

    private final LocalDate enrollmentDate;

    private String engagementType;

    private int lastLecture;

    private LocalDate lastActivityDate;


    public CourseEngagement(Course course, LocalDate enrollmentDate, String engagementType) {
        this.course = course;
        this.enrollmentDate = this.lastActivityDate = enrollmentDate;
        this.engagementType = engagementType;
    }

    public String getCourseCode() {
        return course.courseCode();
    }

    public int getEnrollmentYear() {
        return enrollmentDate.getYear();
    }

    public String getEngagementType() {
        return engagementType;
    }

    public void setEngagementType(String engagementType) {
        this.engagementType = engagementType;
    }

    public int getLastLecture() {
        return lastLecture;
    }

    public void setLastLecture(int lastLecture) {
        this.lastLecture = lastLecture;
    }

    public int getLastActivityYear() {
        return lastActivityDate.getYear();
    }

    public void setLastActivityDate(LocalDate lastActivityDate) {
        this.lastActivityDate = lastActivityDate;
    }

    public double getPercentComplete() {
        return lastLecture * 100.0/ course.lectureCount();
    }

}
