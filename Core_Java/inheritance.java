// Abstract class
abstract class Animal {
    // Encapsulated field
    private String name;

    // Constructor
    public Animal(String name) {
        this.name = name;
    }

    // Abstract method
    public abstract void makeSound();

    // Getter method
    public String getName() {
        return name;
    }
}

// Interface
interface Flyable {
    void fly();
}

// Subclass inheriting from Animal and implementing Flyable interface
class Bird extends Animal implements Flyable {
    // Constructor
    public Bird(String name) {
        super(name);
    }

    // Overridden method from Animal class
    @Override
    public void makeSound() {
        System.out.println("Chirp chirp!");
    }

    // Implemented method from Flyable interface
    @Override
    public void fly() {
        System.out.println(getName() + " is flying.");
    }
}

// Subclass inheriting from Animal
class Dog extends Animal {
    // Constructor
    public Dog(String name) {
        super(name);
    }

    // Overridden method from Animal class
    @Override
    public void makeSound() {
        System.out.println("Woof woof!");
    }
}

class Main {
    public static void main(String[] args) {
        // Polymorphism - Animal reference pointing to Bird object
        Animal bird = new Bird("Sparrow");
        bird.makeSound();
        ((Flyable) bird).fly();

        // Polymorphism - Animal reference pointing to Dog object
        Animal dog = new Dog("Buddy");
        dog.makeSound();
    }
}
