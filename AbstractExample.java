abstract class Animal {
    abstract void makeSound();
}

class Dog extends Animal {
    void makeSound() {
        System.out.println("Dog barks");
    }
}

class Cat extends Animal {
    void makeSound() {
        System.out.println("Cat meows");
    }
}

public class AbstractExample {
    public static void main(String[] args) {
        Animal d = new Dog();
        d.makeSound();

        Animal c = new Cat();
        c.makeSound();
    }
}
