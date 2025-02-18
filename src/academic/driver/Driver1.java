package academic.driver;

import java.util.Scanner;
import java.util.Stack;
import academic.model.Course;
import academic.model.Student;
import academic.model.Enrollment;

/**
 * @author 12S23030 - Simorangkir Jonathan
 * @author 12S23046 - Anastasya T.B Siahaan
 */
public class Driver1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Stack<Course> courseStack = new Stack<>();
        Stack<Student> studentStack = new Stack<>();
        Stack<Enrollment> enrollmentStack = new Stack<>();

        while (true) {
            String input = scanner.nextLine();
            if (input.equals("---")) {
                break;
            }

            String[] data = input.split("#");
            String type = data[0];

            switch (type) {
                case "course-add":
                    if (data.length == 5) {
                        String nim = data[1];
                        String courseID = data[2];
                        int sks = Integer.parseInt(data[3]);
                        String grade = data[4];
                        courseStack.push(new Course(nim, courseID, sks, grade));
                    }
                    break;
                case "student-add":
                    if (data.length == 5) {
                        String nim = data[1];
                        String name = data[2];
                        int year = Integer.parseInt(data[3]);
                        String program = data[4];
                        studentStack.push(new Student(nim, name, year, program));
                    }
                    break;
                case "enrollment-add":
                    if (data.length == 5) {
                        String nim = data[1];
                        String nim2 = data[2];
                        String year = data[3];
                        String term = data[4];
                        String status = "None"; // Nilai default untuk status
                        enrollmentStack.push(new Enrollment(nim, nim2, year, term, status));
                    }
                    break;
            }
        }
        scanner.close();

        while (!courseStack.isEmpty()) {
            System.out.println(courseStack.pop().toString());
        }
        while (!studentStack.isEmpty()) {
            System.out.println(studentStack.pop().toString());
        }
        while (!enrollmentStack.isEmpty()) {
            System.out.println(enrollmentStack.pop().toString());
        }
    }
}