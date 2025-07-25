
class A {
    
    public A() {
        System.out.println("Constructor of Class A is called.");
    }

    public void display() {
        System.out.println("This is the display method from Class A.");
    }

    public void greet() {
        System.out.println("Greetings from Class A!");
    }
}

class B extends A {
    public B() {
        super(); 
        System.out.println("Constructor of Class B is called.");
    }

  
    @Override
    public void display() {
        System.out.println("This is the overridden display method from Class B.");
    }

    public void showInfo() {
        System.out.println("This is a new method in Class B.");
    }

    
    public static void main(String[] args) {
    
        B obj = new B();

      
        System.out.println("\n--- Method Calls ---");
        obj.display();   
        obj.greet();     
        obj.showInfo();  
    }
}
