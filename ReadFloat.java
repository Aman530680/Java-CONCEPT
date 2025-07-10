import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class ReadFloat {
    public static void main(String[] args) throws IOException {
        float num;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter a float value: ");
        num = Float.parseFloat(br.readLine());
        System.out.println("You entered: " + num);
    }
}
