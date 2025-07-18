import java.util.Scanner;

public class array3D {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter depth: ");
        int depth = sc.nextInt();
        System.out.print("Enter rows: ");
        int rows = sc.nextInt();
        System.out.print("Enter columns: ");
        int cols = sc.nextInt();
        int[][][] threeD = new int[depth][rows][cols];

        System.out.println("Enter " + (depth * rows * cols) + " elements:");
        for (int i = 0; i < depth; i++) {
            for (int j = 0; j < rows; j++) {
                for (int k = 0; k < cols; k++) {
                    threeD[i][j][k] = sc.nextInt();
                }
            }
        }

        System.out.println("3D Matrix:");
        for (int i = 0; i < depth; i++) {
            System.out.println("Layer " + (i + 1));
            for (int j = 0; j < rows; j++) {
                for (int k = 0; k < cols; k++) {
                    System.out.print(threeD[i][j][k] + " ");
                }
                System.out.println();
            }
            System.out.println("-----------");
        }
    }
}