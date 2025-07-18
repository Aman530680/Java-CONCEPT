import java.util.Scanner;

public class array1D {
    public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
       System.out.print("Enter size of 1D array: ");
         int n = sc.nextInt();
        int[] oneD = new int[n];

         System.out.println("Enter " + n + " elements:");
         for (int i = 0; i < n; i++) {
             oneD[i] = sc.nextInt();
         }

         System.out.print("1D Array: ");
         for (int num : oneD) {
             System.out.print(num + " ");
         }
     }
 }