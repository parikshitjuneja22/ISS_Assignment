package new_assignment;

// Parent class A
class A {
    // Private method in class A
    private void display() {
        System.out.println("Method from class A");
    }

    // Public method to access the private method in class A
    public void show() {
        display();
    }
}

// Another different class to use the method from class A
class Main {
    public static void main(String[] args) {
        A objA = new A();

        // Call the public method of class A to access the private method
        objA.show(); // Output: Method from class A
    }
}
