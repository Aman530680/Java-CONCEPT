import java.io.*;

public class Filecount {
    public static void main(String[] args) {
        String fileName = "output.txt";
        int lineCount = 0;
        int wordCount = 0;
        int charCount = 0;

        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            String line;

            while ((line = reader.readLine()) != null) {
                lineCount++;
                charCount += line.length();
                String[] words = line.trim().split("\\s+");
                if (!line.trim().isEmpty()) {
                    wordCount += words.length;
                }
            }

            reader.close();

            System.out.println("File: " + fileName);
            System.out.println("Total Lines     : " + lineCount);
            System.out.println("Total Words     : " + wordCount);
            System.out.println("Total Characters: " + charCount);

        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
}
