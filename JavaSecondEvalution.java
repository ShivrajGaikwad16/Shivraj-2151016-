package JavaSecondEvaluation;

import java.util.ArrayList;
import java.util.List;

class Student {
    private int studentID;
    private String name;
    private String email;
    private String phoneNumber;
    private String address;

    public Student(int studentID, String name, String email, String phoneNumber, String address) {
        this.studentID = studentID;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void displayStudentInfo() {
        System.out.println("Student ID: " + studentID);
        System.out.println("Name: " + name);
        System.out.println("Email: " + email);
        System.out.println("Phone Number: " + phoneNumber);
        System.out.println("Address: " + address);
    }
}

class Course {
    private int courseID;
    private String courseName;
    private String instructor;
    private int credits;
    private int maxCapacity;
    private List<Student> enrolledStudents = new ArrayList<>();

    public Course(int courseID, String courseName, String instructor, int credits, int maxCapacity) {
        this.courseID = courseID;
        this.courseName = courseName;
        this.instructor = instructor;
        this.credits = credits;
        this.maxCapacity = maxCapacity;
    }

    public String getCourseName() {
        return courseName;
    }

    public boolean isCourseFull() {
        return enrolledStudents.size() >= maxCapacity;
    }

    public void enrollStudent(Student student) {
        if (!isCourseFull()) {
            enrolledStudents.add(student);
            System.out.println(student.getName() + " has been enrolled in " + courseName);
        } else {
            System.out.println("Course " + courseName + " is already full.");
        }
    }

    public void displayEnrolledStudents() {
        System.out.println("Students enrolled in " + courseName + ":");
        for (Student student : enrolledStudents) {
            System.out.println(student.getName());
        }
    }

	public boolean isEnrolled(Student student) {
		return enrolledStudents.contains(student);
	}
}

class CollegeManager {
    private List<Student> students = new ArrayList<>();
    private List<Course> courses = new ArrayList<>();

    public void addStudent(Student student) {
        students.add(student);
    }

    public void addCourse(Course course) {
        courses.add(course);
    }

    public void enrollStudentInCourse(Student student, Course course) {
        course.enrollStudent(student);
    }

    public void displayStudentsInCourse(Course course) {
        course.displayEnrolledStudents();
    }

    public void displayCoursesForStudent(Student student) {
        System.out.println(student.getName() + " is enrolled in the following courses:");
        for (Course course : courses) {
            if (course.isEnrolled(student)) {
                System.out.println(course.getCourseName());
            }
        }
    }
}

public class CollegeMngmntSys {
    public static void main(String[] args) {
        CollegeManager collegeManager = new CollegeManager();

        // Creating students
        Student student1 = new Student(1, "Shiv", "shiv@gmail.com", "123-456-7890", "Shivane, Pune-23");
        Student student2 = new Student(2, "Raj", "raj@example.com", "987-654-3210", "Warje, Pune-23");

        // Adding students to the system
        collegeManager.addStudent(student1);
        collegeManager.addStudent(student2);

        // Creating courses
        Course course1 = new Course(101, "Java", "Prof.Vishwanath Taware", 3, 30);
        Course course2 = new Course(102, "Python", "Mrs.Neha Kulkarni", 3, 25);

        // Adding courses to the system
        collegeManager.addCourse(course1);
        collegeManager.addCourse(course2);

        // Enrolling students in courses
        collegeManager.enrollStudentInCourse(student1, course1);
        collegeManager.enrollStudentInCourse(student1, course2);
        collegeManager.enrollStudentInCourse(student2, course1);

        collegeManager.displayStudentsInCourse(course1);

        collegeManager.displayCoursesForStudent(student2);
    }
}