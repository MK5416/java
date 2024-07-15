package intern;

import java.util.Scanner;

public class task3 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the no of subjects: ");
        int n = scanner.nextInt();

        double sum = 0;

        for (int i = 1; i <= n; i++) {
            System.out.print("Enter score for subject " + i + ": ");
            double subjectScore = scanner.nextDouble();
            sum += subjectScore;
        }

        double averageScore = sum / n; 

        System.out.println("Average Score: " + averageScore);
        scanner.close();
    }

   
    }
