// MVCPatternTest.java
public class MVCPatternTest {
    public static void main(String[] args) {
        // Create a Student model
        Student student = new Student("saismruti", "2141013242", "A");

        // Create a StudentView
        StudentView view = new StudentView();

        // Create a StudentController
        StudentController controller = new StudentController(student, view);

        // Update the view with initial details
        controller.updateView();

        // Update student details using controller
        controller.setStudentName("saismruti");
        controller.setStudentId("5005046");
        controller.setStudentGrade("B");

        // Update the view with new details
        controller.updateView();
    }
}
