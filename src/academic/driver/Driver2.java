package academic.driver;

import java.util.Scanner;
import academic.model.Course;
import academic.model.Student;
import academic.model.Enrollment;

/**
 * @author 12S23030 - Simorangkir Jonathan
 * @author 12S23046 - Anastasya T.B Siahaan
 */
public class Driver2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Course[] courses = new Course[100];
        Student[] students = new Student[100];
        Enrollment[] enrollments = new Enrollment[100];
        int courseCount = 0, studentCount = 0, enrollmentCount = 0;

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
                        String courseId = data[1];
                        String courseName = data[2];
                        int credits = Integer.parseInt(data[3]);
                        String grade = data[4];
                        courses[courseCount++] = new Course(courseId, courseName, credits, grade);
                    }
                    break;
                case "student-add":
                    if (data.length == 5) {
                        String studentId = data[1];
                        String name = data[2];
                        int year = Integer.parseInt(data[3]);
                        String program = data[4];
                        students[studentCount++] = new Student(studentId, name, year, program);
                    }
                    break;
                case "enrollment-add":
                    if (data.length == 5) {
                        String courseId = data[1];
                        String studentId = data[2];
                        String year = data[3];
                        String prodi = data[4];
                        
            
                        boolean courseExists = false;
                        for (int i = 0; i < courseCount; i++) {
                            if (courses[i].getcourseId().equals(courseId)) {
                                courseExists = true;
                                break;
                            }
                        }
                        
                        
                        boolean studentExists = false;
                        for (int i = 0; i < studentCount; i++) {
                            if (students[i].getStudentId().equals(studentId)) {
                                studentExists = true;
                                break;
                            }
                        }
                        
                        if (!courseExists) {
                            System.out.println("invalid course|" + courseId);
                        } else if (!studentExists) {
                            System.out.println("invalid student|" + studentId);
                        } else {
                            enrollments[enrollmentCount++] = new Enrollment(courseId, studentId, year, prodi, "None");
                        }
                    }
                    break;
            }
        }
        scanner.close();

        
        for (int i = 0; i < courseCount; i++) {
            System.out.println(courses[i].toString());
        }
        
        
        for (int i = 0; i < studentCount; i++) {
            System.out.println(students[i].toString());
        }
        
        
        for (int i = 0; i < enrollmentCount; i++) {
            System.out.println(enrollments[i].toString());
        }
    }
}