
// Topic: Inheritance in Java
// Definition: Inheritance is the process by which one class (child/subclass)
// acquires the properties and behaviors (fields and methods) of another class (parent/superclass).
// It supports code reusability and method overriding in Java.

// -------------------------------------------------------
// TYPE 1: Single Inheritance
// Definition: In Single Inheritance, a class inherits from only one parent class.
// Example: Dog inherits properties of Animal.
// -------------------------------------------------------
class Animal {
    void eat() {
        System.out.println("Animal is eating...");
    }
}

class Dog extends Animal {   // Single Inheritance
    void bark() {
        System.out.println("Dog is barking...");
    }
}

// -------------------------------------------------------
// TYPE 2: Multilevel Inheritance
// Definition: In Multilevel Inheritance, a chain of inheritance is created.
// Example: Puppy inherits Dog, and Dog inherits Animal.
// -------------------------------------------------------
class Puppy extends Dog {   // Multilevel Inheritance
    void weep() {
        System.out.println("Puppy is weeping...");
    }
}

// -------------------------------------------------------
// TYPE 3: Hierarchical Inheritance
// Definition: In Hierarchical Inheritance, multiple classes inherit from the same parent class.
// Example: Both Dog and Cat inherit from Animal.
// -------------------------------------------------------
class Cat extends Animal {
    void meow() {
        System.out.println("Cat is meowing...");
    }
}

// -------------------------------------------------------
// TYPE 4: Multiple Inheritance (via Interfaces)
// Definition: Java does not support multiple inheritance with classes (to avoid ambiguity),
// but it allows multiple inheritance through interfaces.
// Example: Class C implements both A and B interfaces.
// -------------------------------------------------------
interface A {
    void showA();
}

interface B {
    void showB();
}

class C implements A, B {  // Multiple Inheritance through interfaces
    public void showA() {
        System.out.println("From Interface A");
    }
    public void showB() {
        System.out.println("From Interface B");
    }
}

// -------------------------------------------------------
// MAIN CLASS
// -------------------------------------------------------
public class InheritanceDemo {
    public static void main(String[] args) {

        // Single Inheritance Example
        System.out.println("---- Single Inheritance ----");
        Dog d = new Dog();
        d.eat();   // inherited from Animal
        d.bark();  // defined in Dog

        // Multilevel Inheritance Example
        System.out.println("\n---- Multilevel Inheritance ----");
        Puppy p = new Puppy();
        p.eat();   // from Animal
        p.bark();  // from Dog
        p.weep();  // from Puppy

        // Hierarchical Inheritance Example
        System.out.println("\n---- Hierarchical Inheritance ----");
        Cat c = new Cat();
        c.eat();   // from Animal
        c.meow();  // from Cat

        // Multiple Inheritance Example
        System.out.println("\n---- Multiple Inheritance (via Interfaces) ----");
        C obj = new C();
        obj.showA();
        obj.showB();
    }
}
