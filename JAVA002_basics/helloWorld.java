package JAVA002_basics;

// import necessary libraries
// must at the top of the file
import java.util.Scanner;

// main class
// can be only one public class
// should match the file name
// and include main() method
public class helloWorld {

    // main method
    // entry point of the program
    // program execution starts here
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // printout to console
        System.out.print("Enter your name: ");
        // take input
        String userName = scanner.nextLine();

        // formatted output
        System.out.printf("\nHello, %s!%n", userName);
        // output with endline
        System.out.println("Welcome to 1st Java programming.");

        scanner.close();
        System.out.println("\n--------------------");
        System.out.println("#vduczz");
    }

}
