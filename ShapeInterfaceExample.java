interface Shape {
    void calculateArea();
}

class Circle implements Shape {
    double radius;

    Circle(double radius) {
        this.radius = radius;
    }

    public void calculateArea() {
        double area = 3.14 * radius * radius;
        System.out.println("Area of Circle: " + area);
    }
}

class Rectangle implements Shape {
    double length;
    double width;

    Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    public void calculateArea() {
        double area = length * width;
        System.out.println("Area of Rectangle: " + area);
    }
}

public class ShapeInterfaceExample {
    public static void main(String[] args) {
        Shape circle = new Circle(5);
        circle.calculateArea();

        Shape rectangle = new Rectangle(4, 6);
        rectangle.calculateArea();
    }
}
