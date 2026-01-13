package JAVA002_basics;

import java.util.Scanner;

public class decisionMaking {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 1. If-else statement
        /*-
         if (condition1) {
            // code block 1
         } else if (condition2) {
            // code block 2
         } else if (condition3) {
            // code block 3
         } else {
            // default code block
         }
         */
        // note:
        // - must have only one "if" block
        // - can have maximum one "else" block (0 or 1)
        // - "else if" block are optional and can be multiple
        System.out.print("\nDo you want to get a random integer number in range 1-12? [y/n]: ");
        String userChoice = sc.nextLine().toLowerCase();
        System.out.println();
        int intMonth = (int) (Math.random() * 12) + 1;
        if (userChoice.equals("y") || userChoice.equals("yes") || userChoice.equals("1"))
            System.out.printf("Your random integer number: %d%n", intMonth);
        else {
            if (userChoice.equals("n") || userChoice.equals("no") || userChoice.equals("0"))
                System.out.println("Okey :)");
            else
                System.out.println("Invalid input!");
            System.out.printf("Your can only choose [yes] =), your number is: %d%n", intMonth);
        }
        // get number of days in month
        int daysInMonth;
        if (intMonth == 1 || intMonth == 3 || intMonth == 5 || intMonth == 7 || intMonth == 8 || intMonth == 10
                || intMonth == 12)
            daysInMonth = 31;
        else if (intMonth == 4 || intMonth == 6 || intMonth == 9 || intMonth == 11)
            daysInMonth = 30;
        else
            daysInMonth = 28;

        // 2. Tenary operator
        // condition ? expIfTrue : expIfFalse

        // 3. Switch-case statement
        /*-
         switch (expression) {
            case value1:
                // code block 1
                break;
            case value2, value3, value4:
                // code block 2
                break;
            default:
                // default code block
         }
         */
        // Note:
        // - the expression must return a single value
        // of type: byte, short, int, char, String, or enum
        // - duplicate case values are not allowed
        // - [default] case is optional
        // - break statement is optional. If omitted, execution will
        // continue to the next case (fall-through).
        // Else, execution will go outside the switch-case block after meet matched case
        String monthName;
        switch (intMonth) {
            case 1:
                monthName = "January";
                break;
            case 2:
                monthName = "February";
                break;
            case 3:
                monthName = "March";
                break;
            case 4:
                monthName = "April";
                break;
            case 5:
                monthName = "May";
                break;
            case 6:
                monthName = "June";
                break;
            case 7:
                monthName = "July";
                break;
            case 8:
                monthName = "August";
                break;
            case 9:
                monthName = "September";
                break;
            case 10:
                monthName = "October";
                break;
            case 11:
                monthName = "November";
                break;
            case 12:
                monthName = "December";
                break;
            default:
                monthName = "Invalid month!";
                break;
        }

        System.out.printf("Addition, the %d-th month in year has name is %s and it has %d days!%n",
                intMonth,
                monthName,
                daysInMonth);
        sc.close();
        //
        System.out.println("\n--------------------");
        System.out.println("#vduczz");
    }
}
