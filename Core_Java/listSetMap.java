import java.util.*;

class Main {
    public static void main(String[] args) {
        // Creating a List of Students
        List<Student> studentList = new ArrayList<>();
        studentList.add(new Student(1, "John"));
        studentList.add(new Student(2, "Alice"));

        // Creating a Set of Students
        Set<Student> studentSet = new HashSet<>();
        studentSet.add(new Student(1, "John"));
        studentSet.add(new Student(2, "Alice"));
        
        // Creating a Map of Students
        Map<Integer, Student> studentMap = new HashMap<>();
        studentMap.put(1, new Student(1, "John"));
        studentMap.put(2, new Student(2, "Alice"));

        // Printing the List of Students
        System.out.println("List of Students:");
        for (Student student : studentList) {
            System.out.println(student.getId() + ": " + student.getName());
        }

        // Printing the Set of Students
        System.out.println("\nSet of Students:");
        for (Student student : studentSet) {
            System.out.println(student.getId() + ": " + student.getName());
        }

        // Printing the Map of Students
        System.out.println("\nMap of Students:");
        for (Map.Entry<Integer, Student> entry : studentMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue().getName());
        }
    }
}

class Student {
    private int id;
    public String name;

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}

class custComparator implements Comparator<Student> {
    @Override
    public int compare(Student s1, Student s2) {
        return s1.name.compareTo(s2.name);
    }
}