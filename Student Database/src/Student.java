import java.util.Scanner;

public class Student {

    private static int baseId = 1000;
    private int studentId;
    private String firstName;
    private String lastName;
    private String gradeYear;
    private String courses = "Not enrolled in any courses";
    double payment;
    String stringInput;
    String newString;
    private final double tuitionCost = 600;
    private double tuitionBalance = 0;
    boolean done = true;

    Scanner scan = new Scanner(System.in);

    Student(){

        System.out.print("Student's first name: ");
        firstName = scan.nextLine();

        System.out.print("Student's last name: ");
        lastName = scan.nextLine();

        System.out.println("Input the number according to the student's grade year:");
        System.out.println("1) Freshman");
        System.out.println("2) Sophomore");
        System.out.println("3) Junior");
        System.out.println("4) Senior");

        while(done){
            stringInput = scan.nextLine();
            switch (stringInput) {
                case "1":
                    gradeYear = "Freshman";
                    done = false;
                    break;
                case "2":
                    gradeYear = "Sophomore";
                    done = false;
                    break;
                case "3":
                    gradeYear = "Junior";
                    done = false;
                    break;
                case "4":
                    gradeYear = "Senior";
                    done = false;
                    break;
                default:
                    System.out.println("Invalid selection");
                    break;
            }
        }

        studentId = baseId;
        baseId++;

    }

    public void printStudentId(){
        System.out.println(studentId);
    }

    public void enroll(){

        while(true) {
            System.out.print("Enter course to enroll in (-1 to stop): ");
            stringInput = scan.nextLine();
            if (stringInput.equals("-1")){
                break;
            }
            else {
                if (courses == "Not enrolled in any courses"){
                    courses = stringInput;
                    tuitionBalance += tuitionCost;
                }
                else {
                    courses = courses + "  " + stringInput;
                    tuitionBalance += tuitionCost;
                }
            }
        }

        System.out.println("Enrolled in: " + courses);
    }

    public void removeCourse(){
        if (courses.equals("Not enrolled in any courses")){
            System.out.println("Can not remove a course when not enrolled in any courses");
        }
        else {
            System.out.print("Type in a course to remove: ");
            stringInput = scan.nextLine();
            newString = courses.replace(stringInput, "");
            newString = newString.replace("    ","  ");
            courses = newString;
            tuitionBalance -= 600;
            if( tuitionBalance < 0){
                tuitionBalance = 0;
            }
        }
        printCourses();
    }

    public void printTuitionBalance(){
        System.out.println("Balance is: $" + tuitionBalance);
    }

    public void payTuition(){

        if (tuitionBalance <= 0){
            System.out.print("Tuition balance is empty, cannot make a payment");
        }
        else {
            System.out.print("Payment amount: $");

            while (!scan.hasNextDouble()) {
                scan.next();
                System.out.print("Please enter a number: ");
            }

            payment = scan.nextDouble();
            if (payment > tuitionBalance) {
                System.out.println("Payment is greater than tuition balance, cannot make payment");
                System.out.println();
                printTuitionBalance();
            } else {
                tuitionBalance -= payment;
                System.out.println("Payment made: " + payment);
                printTuitionBalance();
            }
        }
    }

    public void printCourses(){
        System.out.println("Courses: " + courses);
    }

    public void showInfo(){
        System.out.println("STUDENT INFO");
        System.out.println("*************");
        System.out.println("Name: " + firstName + " " + lastName);
        System.out.println("Student ID: " + studentId);
        System.out.println("Grade Year: " + gradeYear);
        printCourses();
        printTuitionBalance();
    }

    public void showName(){
        System.out.println(firstName + " " + lastName);
    }
}
