import java.io.FileWriter;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Scanner;

public class FileReadWrite {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String fileName = "result.txt";

        // Take input
        System.out.print("Enter first number: ");
        double num1 = sc.nextDouble();

        System.out.print("Enter operator (+, -, *, /): ");
        char operator = sc.next().charAt(0);

        System.out.print("Enter second number: ");
        double num2 = sc.nextDouble();

        double result = 0;
        boolean valid = true;

        // Perform calculation
        switch (operator) {
            case '+':
                result = num1 + num2;
                break;

            case '-':
                result = num1 - num2;
                break;

            case '*':
                result = num1 * num2;
                break;

            case '/':
                if (num2 != 0)
                    result = num1 / num2;
                else {
                    System.out.println("Error: Division by zero.");
                    valid = false;
                }
                break;

            default:
                System.out.println("Invalid operator.");
                valid = false;
        }

        // Write result to file
        if (valid) {
            try {
                FileWriter writer = new FileWriter(fileName);
                writer.write("Result: " + result);
                writer.close();
                System.out.println("Result written to " + fileName);
            } catch (IOException e) {
                System.out.println("Error writing to file.");
                e.printStackTrace();
            }

            // Read result from file
            try {
                FileReader reader = new FileReader(fileName);
                BufferedReader bufferedReader = new BufferedReader(reader);
                String line;
                System.out.println("\nReading result from file:");
                while ((line = bufferedReader.readLine()) != null) {
                    System.out.println(line);
                }
                bufferedReader.close();
                reader.close();
            } catch (IOException e) {
                System.out.println("Error reading from file.");
                e.printStackTrace();
            }
        }

        sc.close();
    }
}
