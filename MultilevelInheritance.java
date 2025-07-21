class A {
    void displayA() {
        System.out.println("This is class A");
    }
}

class B extends A {
    void displayB() {
        System.out.println("This is class B");
    }
}

class C extends B {
    void displayC() {
        System.out.println("This is class C");
    }
}

public class MultilevelInheritance {
    public static void main(String[] args) {
        C obj = new C();
        obj.displayA();
        obj.displayB();
        obj.displayC();
    }
}
