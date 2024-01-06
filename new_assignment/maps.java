package new_assignment;

import java.util.*;

// Student class
class Student {
    private int ID;
    private int age;
    private String name;

    // Constructor
    public Student(int ID, int age, String name) {
        this.ID = ID;
        this.age = age;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{ID=" + ID + ", age=" + age + ", name='" + name + "'}";
    }
}

// Subject class
class Subject {
    private int ID;
    private String name;

    // Constructor
    public Subject(int ID, String name) {
        this.ID = ID;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Subject{ID=" + ID + ", name='" + name + "'}";
    }
}

class Main {
    public static void main(String[] args) {
        // Create a Map<Student, List<Subject>>
        Map<Student, List<Subject>> map = new HashMap<>();

        // Create Student objects
        Student student1 = new Student(1, 20, "John");
        Student student2 = new Student(2, 22, "Alice");

        // Create Subject lists for each student
        List<Subject> subjects1 = new ArrayList<>();
        subjects1.add(new Subject(101, "Math"));
        subjects1.add(new Subject(102, "Science"));

        List<Subject> subjects2 = new ArrayList<>();
        subjects2.add(new Subject(103, "History"));
        subjects2.add(new Subject(104, "English"));

        // Populate the map
        map.put(student1, subjects1);
        map.put(student2, subjects2);

        // Iterate through the map and print key and value
        for (Map.Entry<Student, List<Subject>> entry : map.entrySet()) {
            System.out.println("Key: " + entry.getKey());
            System.out.println("Value: " + entry.getValue());
            System.out.println();  // for better readability
        }
    }
}
