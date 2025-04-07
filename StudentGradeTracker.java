import java.util.ArrayList;
import java.util.Scanner;

public class StudentGradeTracker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> grades = new ArrayList<>();
        
        System.out.println("Enter student grades (enter -1 to stop):");
        
        while (true) {
            System.out.print("Enter grade: ");
            int grade = scanner.nextInt();
            
            if (grade == -1) break; // Stop input if -1 is entered
            
            if (grade >= 0 && grade <= 100) {
                grades.add(grade);
            } else {
                System.out.println("Invalid grade. Enter a value between 0 and 100.");
            }
        }
        
        if (grades.isEmpty()) {
            System.out.println("No grades were entered.");
        } else {
            computeStatistics(grades);
        }
        
        scanner.close();
    }
    
    public static void computeStatistics(ArrayList<Integer> grades) {
        int sum = 0, highest = Integer.MIN_VALUE, lowest = Integer.MAX_VALUE;
        
        for (int grade : grades) {
            sum += grade;
            if (grade > highest) highest = grade;
            if (grade < lowest) lowest = grade;
        }
        
        double average = (double) sum / grades.size();
        
        System.out.println("\nGrade Statistics:");
  
        System.out.println("Average Score: " + String.format("%.2f", average));
        System.out.println("Highest Score: " + highest);
        System.out.println("Lowest Score: " + lowest);
    }
}
