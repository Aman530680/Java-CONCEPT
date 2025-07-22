import java.util.Scanner;

class Student {
    int rollNo;
    String name;
    int score1;
    int score2;
    int score3;
    int total;

    Student(int r, String n, int s1, int s2, int s3) {
        rollNo=r;
        name=n;
        score1=s1;
        score2=s2;
        score3=s3;
        total=s1+s2+s3;
    }
}
public class StudentRanking {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        System.out.print("Enter number of students: ");
        int count=sc.nextInt();
        Student[] students=new Student[count];
        for(int i=0;i<count;i++) {
            System.out.println("Enter details for student"+(i+ 1));
            System.out.print("Roll number: ");
            int roll=sc.nextInt();
            System.out.print("Name: ");
            String name=sc.next();
            System.out.print("Score 1: ");
            int s1=sc.nextInt();
            System.out.print("Score 2: ");
            int s2=sc.nextInt();
            System.out.print("Score 3: ");
            int s3=sc.nextInt();
            students[i]=new Student(roll,name,s1,s2,s3);
        }
        
        for (int i = 0; i < count - 1; i++) {
            for (int j = 0; j < count - i - 1; j++) {
                if (students[j].total < students[j + 1].total) {
                    Student temp = students[j];
                    students[j] = students[j + 1];
                    students[j + 1] = temp;
                }
            }
        }

        System.out.println("\nStudent Ranking:");
        for (int i = 0; i < count; i++) {
            System.out.println("Rank " + (i + 1) + ": Roll No " + students[i].rollNo + ", Name: " + students[i].name + ", Total: " + students[i].total);
        }

        sc.close();
    }
}
