package new_assignment;

// Parent class
class Animal {
    // Method in the parent class
    public void makeSound() {
        System.out.println("Animal makes a sound");
    }
}

// Child class inheriting from Animal
class Dog extends Animal {
    // Override the makeSound method in the child class
    @Override
    public void makeSound() {
        System.out.println("Dog barks");
    }
}

class Main {
    public static void main(String[] args) {
        // Create a parent class object
        Animal myAnimal = new Animal();

        // Create a child class object
        Dog myDog = new Dog();

        // Call the makeSound method using the parent class object
        myAnimal.makeSound();  // Output: Animal makes a sound

        // Call the makeSound method using the child class object
        myDog.makeSound();     // Output: Dog barks

        // Using polymorphism to call the method
        Animal anotherAnimal = new Dog();  // Polymorphic object
        anotherAnimal.makeSound();         // Output: Dog barks
    }
}