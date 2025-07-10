import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class ReadChar {
    public static void main(String[] args) throws IOException {
        char ch;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter a character: ");
        ch = (char) br.read();
        System.out.println("You entered: " + ch);
    }
}
