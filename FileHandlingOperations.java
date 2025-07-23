import java.io.*;
import java.util.Scanner;

public class FileHandlingOperations {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String fileName = "FileInput.txt";  // You can change the file name here
        File file = new File(fileName);
        int choice;

        do {
            System.out.println("\n📁 File Handling Menu:");
            System.out.println("1. Create File");
            System.out.println("2. Write to File");
            System.out.println("3. Append to File");
            System.out.println("4. Read from File");
            System.out.println("5. Delete File");
            System.out.println("6. File Information");
            System.out.println("7. Exit");
            System.out.print("Enter your choice (1-7): ");
            choice = sc.nextInt();
            sc.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    try {
                        if (file.createNewFile()) {
                            System.out.println("✅ File created: " + file.getName());
                        } else {
                            System.out.println("⚠️ File already exists.");
                        }
                    } catch (IOException e) {
                        System.out.println("❌ Error creating file.");
                    }
                    break;

                case 2:
                    try {
                        System.out.print("Enter text to write: ");
                        String content = sc.nextLine();
                        FileWriter writer = new FileWriter(file);
                        writer.write(content);
                        writer.close();
                        System.out.println("✅ Content written to " + fileName);
                    } catch (IOException e) {
                        System.out.println("❌ Error writing to file.");
                    }
                    break;

                case 3:
                    try {
                        System.out.print("Enter text to append: ");
                        String content = sc.nextLine();
                        FileWriter writer = new FileWriter(file, true);
                        writer.write("\n" + content);
                        writer.close();
                        System.out.println("✅ Content appended to " + fileName);
                    } catch (IOException e) {
                        System.out.println("❌ Error appending to file.");
                    }
                    break;

                case 4:
                    try {
                        FileReader reader = new FileReader(file);
                        BufferedReader bufferedReader = new BufferedReader(reader);
                        String line;
                        System.out.println("\n📖 File Content:");
                        while ((line = bufferedReader.readLine()) != null) {
                            System.out.println(line);
                        }
                        bufferedReader.close();
                        reader.close();
                    } catch (IOException e) {
                        System.out.println("❌ Error reading file or file does not exist.");
                    }
                    break;

                case 5:
                    if (file.delete()) {
                        System.out.println("🗑️ File deleted: " + file.getName());
                    } else {
                        System.out.println("❌ Failed to delete file or file does not exist.");
                    }
                    break;

                case 6:
                    if (file.exists()) {
                        System.out.println("📂 File Info:");
                        System.out.println("Name      : " + file.getName());
                        System.out.println("Path      : " + file.getAbsolutePath());
                        System.out.println("Writable  : " + file.canWrite());
                        System.out.println("Readable  : " + file.canRead());
                        System.out.println("Size      : " + file.length() + " bytes");
                    } else {
                        System.out.println("❌ File does not exist.");
                    }
                    break;

                case 7:
                    System.out.println("👋 Exiting program.");
                    break;

                default:
                    System.out.println("❌ Invalid choice. Enter 1 to 7.");
            }
        } while (choice != 7);

        sc.close();
    }
}
