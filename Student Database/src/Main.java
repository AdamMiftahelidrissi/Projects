import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        boolean running = true;

        String stringInput;

        int intInput = 0;
        int studentSelection;

        int numOfStudents;

        System.out.print("Enter amount of students being added: ");
        while (!scan.hasNextInt()) {
            scan.next();
            System.out.print("Please enter a number: ");
        }

        numOfStudents = scan.nextInt();

        Student[] students = new Student[numOfStudents];
        for (int i = 0; i < numOfStudents; i++){
            students[i] = new Student();
        }

        while (intInput != -1){
            System.out.println();
            System.out.println();
            System.out.println("STUDENT DATABASE");
            System.out.println("*****************");
            for (int i = 0; i < numOfStudents; i++){
                System.out.print(i + 1 + ") ");
                students[i].showName();
            }
            System.out.println("(Press '-1' to quit)");

            System.out.print("Select a student number: ");
            while (!scan.hasNextInt()) {
                scan.next();
                System.out.print("Please enter a number: ");
            }
            intInput = scan.nextInt();
            if(intInput == -1){
                break;
            }
            studentSelection = intInput - 1;

            System.out.println();
            while (intInput != -1 || intInput != 7) {
                System.out.println("1) Enroll in courses");
                System.out.println("2) Show courses");
                System.out.println("3) Remove a course");
                System.out.println("4) Show Tuition balance");
                System.out.println("5) Make a payment");
                System.out.println("6) Show all info");
                System.out.println("7) Return to student selection");
                System.out.println("(Press '-1' to quit)");
                System.out.print("Select an option: ");
                while (!scan.hasNextInt()) {
                    scan.next();
                    System.out.print("Please enter a number: ");
                }
                intInput = scan.nextInt();

                if (intInput == -1 || intInput == 7) {
                    break;
                }

                switch (intInput) {
                    case 1:
                        System.out.println();
                        students[studentSelection].enroll();
                        System.out.println();
                        break;
                    case 2:
                        System.out.println();
                        students[studentSelection].printCourses();
                        System.out.println();
                        break;
                    case 3:
                        System.out.println();
                        students[studentSelection].removeCourse();
                        System.out.println();
                        break;
                    case 4:
                        System.out.println();
                        students[studentSelection].printTuitionBalance();
                        System.out.println();
                        break;
                    case 5:
                        System.out.println();
                        students[studentSelection].payTuition();
                        System.out.println();
                        break;
                    case 6:
                        System.out.println();
                        students[studentSelection].showInfo();
                        System.out.println();
                        break;
                    default:
                        System.out.println("Invalid input");
                        System.out.println();

                }
            }
        }

        System.out.println("Program Closed");
    }
}