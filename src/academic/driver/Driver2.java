package academic.driver;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import academic.model.Course;
import academic.model.Student;
import academic.model.Enrollment;

public class Driver2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Arrays to hold courses, students, and enrollments
        Course[] courses = new Course[100];
        Student[] students = new Student[100];
        Enrollment[] enrollments = new Enrollment[100];
        int courseCount = 0, studentCount = 0, enrollmentCount = 0;

        // Set to track valid courses and students
        Set<String> validCourses = new HashSet<>();
        Set<String> validStudents = new HashSet<>();

        // List to store invalid messages in order of occurrence
        List<String> invalidMessages = new ArrayList<>();

        while (scanner.hasNextLine()) {
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
                        validCourses.add(courseID);
                    }
                    break;
                case "student-add":
                    if (data.length == 5) {
                        String NIM = data[1];
                        String nama = data[2];
                        int tahun = Integer.parseInt(data[3]);
                        String prodi = data[4];
                        students[studentCount++] = new Student(NIM, nama, tahun, prodi);
                        validStudents.add(NIM);
                    }
                    break;
                case "enrollment-add":
                    if (data.length == 5) {
                        String courseId = data[1];
                        String studentId = data[2];
                        String academicYear = data[3];
                        String semester = data[4];
                        String status = "None";

                        // Check course and student validity at the time of enrollment
                        if (!validCourses.contains(courseId)) {
                            invalidMessages.add("invalid course|" + courseId);
                        }
                        if (!validStudents.contains(studentId)) {
                            invalidMessages.add("invalid student|" + studentId);
                        }

                        // Only create enrollment if both course and student exist at this point
                        if (validCourses.contains(courseId) && validStudents.contains(studentId)) {
                            enrollments[enrollmentCount++] = new Enrollment(studentId, courseId, academicYear, semester,
                                    status);
                        }
                    }
                    break;
            }
        }

        scanner.close();

        // Output invalid messages in order of occurrence
        for (String message : invalidMessages) {
            System.out.println(message);
        }

        // Output courses in reverse order
        for (int i = courseCount - 1; i >= 0; i--) {
            System.out.println(courses[i]);
        }

        // Output students in reverse order
        for (int i = studentCount - 1; i >= 0; i--) {
            System.out.println(students[i]);
        }

        // Output enrollments in reverse order
        for (int i = enrollmentCount - 1; i >= 0; i--) {
            System.out.println(enrollments[i]);
        }
    }
}