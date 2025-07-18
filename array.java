import java.util.Scanner;
public class array{
    private String userid;
    private String username;
    private String useraddress;
    private String usernumber;
    public array(String userid, String username, String useraddress, String usernumber) {
        this.userid = userid;
        this.username = username;
        this.useraddress = useraddress;
        this.usernumber = usernumber;
    }
    public void displayUserData() {
        System.out.println("User ID: " + userid);
        System.out.println("Username: " + username);
        System.out.println("Address: " + useraddress);
        System.out.println("Phone Number: " + usernumber);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("How many users do you want to create? ");
        int n = sc.nextInt();
        sc.nextLine();

        array[] users = new array[n];

        for (int i = 0; i < n; i++) {
            System.out.println("\nEnter details for User " + (i + 1) + ":");

            System.out.print("User ID: ");
            String id = sc.nextLine();

            System.out.print("Username: ");
            String name = sc.nextLine();

            System.out.print("Address: ");
            String address = sc.nextLine();

            System.out.print("Phone Number: ");
            String number = sc.nextLine();

            users[i] = new array(id, name, address, number);
        }

        for (int i = 0; i < n; i++) {
            System.out.println("User " + (i + 1) + ":");
            users[i].displayUserData();
        }
        sc.close();
    }
}

      