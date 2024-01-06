package new_assignment;

import java.util.*;

// Class A
class A {
    private int Id;
    private int marks;
    private String subject;

    // Constructor
    public A(int Id, int marks, String subject) {
        this.Id = Id;
        this.marks = marks;
        this.subject = subject;
    }

    // Getter for marks
    public int getMarks() {
        return marks;
    }

    @Override
    public String toString() {
        return "A{Id=" + Id + ", marks=" + marks + ", subject='" + subject + "'}";
    }
}

class Main {
    public static void main(String[] args) {
        // Create a List of class A objects
        List<A> list = new ArrayList<>();
        list.add(new A(1, 75, "Math"));
        list.add(new A(2, 55, "Science"));
        list.add(new A(3, 85, "English"));

        // Filter the list to find objects with marks greater than 60
        List<A> filteredList = new ArrayList<>();
        for (A obj : list) {
            if (obj.getMarks() > 60) {
                filteredList.add(obj);
            }
        }

        // Print the filtered list
        System.out.println("List of objects with marks more than 60:");
        for (A obj : filteredList) {
            System.out.println(obj);
        }
    }
}
