public class MethodOverloadingDemo {
    void display(int a) {
        System.out.println("Displaying integer: " + a);
    }

    void display(double a) {
        System.out.println("Displaying double: " + a);
    }

    void display(int a, int b) {
        System.out.println("Displaying sum of integers: " + (a + b));
    }

    void display(String a) {
        System.out.println("Displaying string: " + a);
    }

    public static void main(String[] args) {
        MethodOverloadingDemo obj = new MethodOverloadingDemo();
        obj.display(10);
        obj.display(5.5);
        obj.display(5, 15);
        obj.display("Hello Java");
    }
}
