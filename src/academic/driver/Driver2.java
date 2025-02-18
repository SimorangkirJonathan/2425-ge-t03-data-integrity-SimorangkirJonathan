package academic.driver;

import java.util.Scanner;
import java.util.ArrayList;
import academic.model.Course;
import academic.model.Student;
import academic.model.Enrollment;

/**
 * @autors 12S23030 - Simorangkir Jonathan
 * @autors 12S23046 - Anastasya T.B Siahaan
 */
public class Driver2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Course[] courses = new Course[100];
        Student[] students = new Student[100];
        Enrollment[] enrollments = new Enrollment[100];
        ArrayList<String> invalidCourses = new ArrayList<>();
        ArrayList<String> invalidStudents = new ArrayList<>();
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
                        String courseID = data[1];
                        String courseName = data[2];
                        int sks = Integer.parseInt(data[3]);
                        String grade = data[4];
                        courses[courseCount++] = new Course(courseID, courseName, sks, grade);
                    }
                    break;
                case "student-add":
                    if (data.length == 5) {
                        String nim = data[1];
                        String name = data[2];
                        int year = Integer.parseInt(data[3]);
                        String program = data[4];
                        students[studentCount++] = new Student(nim, name, year, program);
                    }
                    break;
                case "enrollment-add":
                    if (data.length == 5) {
                        String courseID = data[1];
                        String studentID = data[2];
                        String year = data[3];
                        String term = data[4];

                        boolean courseExists = false;
                        boolean studentExists = false;

                        for (int i = 0; i < courseCount; i++) {
                            if (courses[i].getcourseID().equals(courseID)) {
                                courseExists = true;
                                break;
                            }
                        }

                        for (int i = 0; i < studentCount; i++) {
                            if (students[i].getNIM().equals(studentID)) {
                                studentExists = true;
                                break;
                            }
                        }

                        if (!courseExists) {
                            invalidCourses.add(courseID);
                        } else if (!studentExists) {
                            invalidStudents.add(studentID);
                        } else {
                            String status = "None";
                            enrollments[enrollmentCount++] = new Enrollment(courseID, studentID, year, term, status);
                        }
                    }
                    break;
            }
        }
        scanner.close();

        for (String invalidCourse : invalidCourses) {
            System.out.println("invalid course|" + invalidCourse);
        }
        for (String invalidStudent : invalidStudents) {
            System.out.println("invalid student|" + invalidStudent);
        }
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