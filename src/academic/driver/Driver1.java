package academic.driver;

import java.util.Scanner;
import academic.model.Course;
import academic.model.Student;
import academic.model.Enrollment;

/**
 * @author 12S23030-Simorangkir Jonathan
 * @author 12S23046-Anastasya T.B Siahaan
 */
public class Driver1 {
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
                        String nim = data[1];
                        String courseID = data[2];
                        int sks = Integer.parseInt(data[3]);
                        String grade = data[4];

                        boolean isDuplicate = isCourseDuplicate(courses, courseCount, courseID);
                        if (!isDuplicate) {
                            courses[courseCount++] = new Course(nim, courseID, sks, grade);
                        }
                    }
                    break;
                case "student-add":
                    if (data.length == 5) {
                        String nim = data[1];
                        String name = data[2];
                        int year = Integer.parseInt(data[3]);
                        String program = data[4];

                        boolean isDuplicate = isStudentDuplicate(students, studentCount, nim);
                        if (!isDuplicate) {
                            students[studentCount++] = new Student(nim, name, year, program);
                        }
                    }
                    break;
                case "enrollment-add":
                    if (data.length == 5) {
                        String nim = data[1];
                        String nim2 = data[2];
                        String year = data[3];
                        String prodi = data[4];
                        String status = "None";

                        boolean isDuplicate = isEnrollmentDuplicate(enrollments, enrollmentCount, nim, nim2, year,
                                prodi);
                        if (!isDuplicate) {
                            enrollments[enrollmentCount++] = new Enrollment(nim, nim2, year, prodi, status);
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

    private static boolean isCourseDuplicate(Course[] courses, int count, String courseID) {
        for (int i = 0; i < count; i++) {
            if (courses[i].getcourseID().equals(courseID)) {
                return true;
            }
        }
        return false;
    }

    private static boolean isStudentDuplicate(Student[] students, int count, String nim) {
        for (int i = 0; i < count; i++) {
            if (students[i].getNIM().equals(nim)) {
                return true;
            }
        }
        return false;
    }

    private static boolean isEnrollmentDuplicate(Enrollment[] enrollments, int count, String nim, String nim2,
            String year, String prodi) {
        for (int i = 0; i < count; i++) {
            if (enrollments[i].getNIM().equals(nim) && enrollments[i].getNIM2().equals(nim2) &&
                    enrollments[i].getTahun().equals(year) && enrollments[i].getProdi().equals(prodi)) {
                return true;
            }
        }
        return false;
    }
}
