package new_assignment;

import java.util.*;

// Class A
class A implements Comparable<A> {
    private int id;
    private int marks;
    private String subject;

    // Constructor
    public A(int id, int marks, String subject) {
        this.id = id;
        this.marks = marks;
        this.subject = subject;
    }

    // Getter methods
    public int getId() {
        return id;
    }

    public int getMarks() {
        return marks;
    }

    public String getSubject() {
        return subject;
    }

    @Override
    public int compareTo(A other) {
        // Sort in descending order based on marks for the Math subject
        if (this.subject.equals("Math") && other.subject.equals("Math")) {
            return other.marks - this.marks;
        }
        return 0;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Subject: " + subject + ", Marks: " + marks;
    }
}

class Main {
    public static void main(String[] args) {
        List<A> list = new ArrayList<>();
        
        // Add multiple subjects with corresponding marks
        list.add(new A(1, 90, "Math"));
        list.add(new A(2, 85, "Science"));
        list.add(new A(3, 88, "English"));
        
        // Sort using Comparable (implicit sorting)
        Collections.sort(list);
        
        for (A obj : list) {
            System.out.println(obj);
        }

        // Sort using Comparator (explicit sorting)
        Collections.sort(list, new Comparator<A>() {
            @Override
            public int compare(A o1, A o2) {
                if (o1.getSubject().equals("Math") && o2.getSubject().equals("Math")) {
                    return o2.getMarks() - o1.getMarks();
                }
                return 0;
            }
        });

        for (A obj : list) {
            System.out.println(obj);
        }
    }
}

