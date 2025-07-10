import java.util.Scanner;

public class calculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the Num1 value: ");
        int num1 = sc.nextInt();

        System.out.println("Enter the Num2 value: ");
        int num2 = sc.nextInt();

        System.out.println("Choose the operator: 1.'+' 2.'-' 3.'*' 4.'/' 5.'%' ");
        int choose = sc.nextInt();

        switch (choose) {
            case 1:
                int sum = num1 + num2;
                System.out.println("Sum: " + sum);
                break;
            case 2:
                int sub = num1 - num2;
                System.out.println("Subtraction: " + sub);
                break;
            case 3:
                int mul = num1 * num2;
                System.out.println("Multiplication: " + mul);
                break;
            case 4:
                if (num2 != 0) {
                    double div = (double) num1 / num2;
                    System.out.println("Division: " + div);
                } else {
                    System.out.println("Error: Division by zero.");
                }
                break;
            case 5:
                if (num2 != 0) {
                    int mod = num1 % num2;
                    System.out.println("Modulus: " + mod);
                } else {
                    System.out.println("Error: Division by zero.");
                }
                break;
            default:
                System.out.println("Invalid operator choice.");
        }

        sc.close();
    }
}
