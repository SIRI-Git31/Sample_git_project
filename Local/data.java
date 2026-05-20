import java.util.ArrayList;
import java.util.List;

// Student class to store student information
class Student {
    private int id;
    private String name;
    private double gpa;

    // Constructor
    public Student(int id, String name, double gpa) {
        this.id = id;
        this.name = name;
        this.gpa = gpa;
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getGpa() {
        return gpa;
    }

    // Display student info
    public void displayInfo() {
        System.out.println("ID: " + id + ", Name: " + name + ", GPA: " + gpa);
    }
}

// Main class for data management
public class data {
    public static void main(String[] args) {
        // Create a list to store students
        List<Student> students = new ArrayList<>();

        // Add students to the list
        students.add(new Student(101, "Alice Johnson", 3.8));
        students.add(new Student(102, "Bob Smith", 3.5));
        students.add(new Student(103, "Carol White", 3.9));
        students.add(new Student(104, "David Brown", 3.2));

        // Display all students
        System.out.println("=== All Students ===");
        for (Student student : students) {
            student.displayInfo();
        }

        // Calculate average GPA
        System.out.println("\n=== GPA Statistics ===");
        double averageGpa = calculateAverageGpa(students);
        System.out.println("Average GPA: " + averageGpa);

        // Find students with GPA above 3.5
        System.out.println("\n=== Students with GPA > 3.5 ===");
        filterStudentsByGpa(students, 3.5);

        // Find student by name
        System.out.println("\n=== Search by Name ===");
        findStudentByName(students, "Carol White");
    }

    // Method to calculate average GPA
    public static double calculateAverageGpa(List<Student> students) {
        double sum = 0;
        for (Student student : students) {
            sum += student.getGpa();
        }
        return students.size() > 0 ? sum / students.size() : 0;
    }

    // Method to filter students by GPA threshold
    public static void filterStudentsByGpa(List<Student> students, double threshold) {
        for (Student student : students) {
            if (student.getGpa() > threshold) {
                student.displayInfo();
            }
        }
    }

    // Method to search student by name
    public static void findStudentByName(List<Student> students, String name) {
        for (Student student : students) {
            if (student.getName().equals(name)) {
                student.displayInfo();
                return;
            }
        }
        System.out.println("Student not found!");
    }
}
