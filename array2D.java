import java.util.Scanner;

 public class array2D {
     public static void main(String[] args) {
         Scanner sc = new Scanner(System.in);
         System.out.print("Enter number of rows: ");
         int rows = sc.nextInt();
         System.out.print("Enter number of columns: ");
         int cols = sc.nextInt();
         int[][] twoD = new int[rows][cols];

         System.out.println("Enter " + (rows * cols) + " elements:");
         for (int i = 0; i < rows; i++) {
             for (int j = 0; j < cols; j++) {
                 twoD[i][j] = sc.nextInt();
             }
         }
         System.out.println("2D Matrix:");
         for (int[] row : twoD) {
             for (int num : row) {
                 System.out.print(num + " ");
             }
             System.out.println();
         }
     }
 }

