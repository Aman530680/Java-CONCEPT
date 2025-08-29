public class Vehicle {
    String name;
    String type;

    public Vehicle(String name, String type) {
        this.name = name;
        this.type = type;
    }

    public void start() {
        System.out.println(name + " (" + type + ") is Starting");
    }

    public void stop() {
        System.out.println(name + " (" + type + ") is Stopping");
    }

    public void displayVehicle() {
        System.out.println("Vehicle Name: " + name + ", Type: " + type);
    }
}

class Car extends Vehicle {
    boolean isRunning;
    boolean acOn;

    public Car(String name, String type) {
        super(name, type);
        this.isRunning = false;
        this.acOn = false;
    }

    public void honk() {
        System.out.println(name + " is Honking");
    }

    public void startCar() {
        if (!isRunning) {
            isRunning = true;
            System.out.println(name + " Engine Started");
        } else {
            System.out.println(name + " is already Running");
        }
    }

    public void stopCar() {
        if (isRunning) {
            isRunning = false;
            acOn = false; 
            System.out.println(name + " Engine Stopped");
        } else {
            System.out.println(name + " is already Off");
        }
    }

    public void turnOnAC() {
        if (isRunning) {
            acOn = true;
            System.out.println(name + " AC is Turned ON");
        } else {
            System.out.println("Start the car first before turning on AC");
        }
    }

    public void turnOffAC() {
        if (acOn) {
            acOn = false;
            System.out.println(name + " AC is Turned OFF");
        } else {
            System.out.println("AC is already Off");
        }
    }

    public void status() {
        System.out.println(name + " Running: " + isRunning + ", AC: " + (acOn ? "ON" : "OFF"));
    }
}

class Bike extends Vehicle {
    public Bike(String name, String type) {
        super(name, type);
    }

    public void wheelie() {
        System.out.println(name + " is doing a Wheelie");
    }
}

class Main {
    public static void main(String[] args) {
        Car car = new Car("Honda City", "Car");
        car.displayVehicle();
        car.startCar();
        car.turnOnAC();
        car.status();
        car.honk();
        car.turnOffAC();
        car.stopCar();
        car.status();

        System.out.println("------");

        Bike bike = new Bike("Royal Enfield", "Bike");
        bike.displayVehicle();
        bike.start();
        bike.wheelie();
        bike.stop();
    }
}
