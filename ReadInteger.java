import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class ReadInteger {
    public static void main(String[] args) throws IOException {
        int num;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter an integer: ");
        num = Integer.parseInt(br.readLine());
        System.out.println("You entered: " + num);
    }
}
