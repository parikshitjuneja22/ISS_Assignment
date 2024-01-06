package new_assignment;

import java.util.*;

// Student class
class Student {
    private int ID;
    private String name;
    private String address;

    // Constructor
    public Student(int ID, String name, String address) {
        this.ID = ID;
        this.name = name;
        this.address = address;
    }

    @Override
    public String toString() {
        return "Student{ID=" + ID + ", name='" + name + "', address='" + address + "'}";
    }

    // Override equals and hashCode methods for key uniqueness in Map
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return ID == student.ID;
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(ID);
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
        Student student1 = new Student(1, "John", "123 Street, City");
        Student student2 = new Student(2, "Alice", "456 Avenue, Town");
        Student student3 = new Student(1, "John", "123 Street, City"); // Same key as student1

        // Create Subject lists for each student
        List<Subject> subjects1 = new ArrayList<>();
        subjects1.add(new Subject(101, "Math"));
        subjects1.add(new Subject(102, "Science"));

        List<Subject> subjects2 = new ArrayList<>();
        subjects2.add(new Subject(103, "History"));

        // Populate the map
        map.put(student1, subjects1);
        map.put(student2, subjects2);
        map.put(student3, subjects2); // Adding an object with the same key as student1

        // Iterate through the map and print key and value
        for (Map.Entry<Student, List<Subject>> entry : map.entrySet()) {
            System.out.println("Key: " + entry.getKey());
            System.out.println("Value: " + entry.getValue());
            System.out.println();  // for better readability
        }
    }
}
