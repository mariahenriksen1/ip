public class Main {
    public static void main(String[] args) {
        Course course = new Course("Introdoctory Programming", 100);

        System.out.println(course.toString());
        course.setEnrolments(-5);
        course.setEnrolments(100);
        System.out.println(course);
    }
    
}
