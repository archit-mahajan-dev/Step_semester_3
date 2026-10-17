package classes_objects.class_problems;
public class CourseConstructorDemo {
    static class Course {
        String code, title;
        Course(String code, String title) { this.code = code; this.title = title; }
    }
    public static void main(String[] args) {
        Course course = new Course("21CSC201J", "Data Structures");
        System.out.println(course.code + " - " + course.title);
    }
}
