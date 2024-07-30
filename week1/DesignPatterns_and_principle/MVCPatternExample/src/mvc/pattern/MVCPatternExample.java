package mvc.pattern;

public class MVCPatternExample {
	 public static void main(String[] args) {
	        Student model = retrieveStudentFromDatabase();

	        StudentView view = new StudentView();

	        StudentController controller = new StudentController(model, view);

	        controller.updateView();

	        controller.setStudentName("Barun Kumar Roy");
	        controller.setStudentGrade("A");

	        controller.updateView();
	    }

	    private static Student retrieveStudentFromDatabase() {
	        Student student = new Student();
	        student.setName("Arpita Roy");
	        student.setId("5016964");
	        student.setGrade("A");
	        return student;
	    }

}
