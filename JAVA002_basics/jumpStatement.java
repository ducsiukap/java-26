package JAVA002_basics;

import java.util.Scanner;

public class jumpStatement {
    public static void main(String[] args) throws InterruptedException {
        Scanner sc = new Scanner(System.in);
        int n = 3;

        // 1. `break` statement
        // 1.1. break statement in loop
        // => terminate the nearest enclosing loop
        for (int i = 0; i < n; ++i) {
            System.out.printf("[Outer loop] step: %d:%n", i);
            int innerLoopCount = 0;
            while (true) {
                ++innerLoopCount;
                System.out.println("\t[inner loop] step: " + innerLoopCount);
                //
                if (innerLoopCount >= 3) {
                    System.out.println("\t[inner loop] break! (reach limit)");
                    break;
                }
                // 50% chance to break
                double p = Math.random();
                if (p >= 0.5) {
                    System.out.printf("\t[inner loop] break! (p = %.2f)%n", p);
                    break;
                }
            }
        }
        // 1.2. break statement in switch-case
        // terminate the switch-case block
        // after executing the matched case block

        // 1.3. labeled break
        System.out.println();
        outer: {
            int timeRemaining = 5;
            System.out.print("[`outer` block] Starting inner block");
            while (timeRemaining > 0) {
                System.out.print(".");
                --timeRemaining;
                Thread.sleep(500);
            }
            timeRemaining = 5;
            inner: {
                while (true) {
                    System.out.printf("\n\t[`inner` block] Terminating `inner` block in %d seconds...", timeRemaining);
                    timeRemaining--;
                    Thread.sleep(1000);
                    if (timeRemaining < 1) {
                        break inner;
                        // the code below `break` is never be executed
                        // System.out.println("this line is unreachable");
                    }
                }
            }
            timeRemaining = 8;
            System.out.print("\n[`outer` block] Breaking `outer` block");
            while (timeRemaining > 0) {
                System.out.print(".");
                --timeRemaining;
                Thread.sleep(500);
            }
            break outer;
            // the code below `break` is never be executed
            // System.out.println("this line is unreachable");
        }
        System.out.println("\nGone out from `label` block.");

        // 2. `continue` statement
        // 2.1. `continue` skips the current iteration of the nearest enclosing loop
        n = (int) (Math.random() * 20 + 10);
        System.out.printf("\nEven number in range [0, %d]: ", n);
        for (int i = 0; i <= n; ++i) {
            if ((i & 1) == 1)
                continue;
            else
                System.out.print(i + " ");
            Thread.sleep(300);
        }
        // 2.2. labeled continue
        System.out.println("\n\n");
        System.out.println("Guest a random number game!".toUpperCase());

        game_loop: for (int i = 1; true; ++i) {
            System.out.printf("Round %d:%n", i);
            boolean isUserWin = false;
            int randomNumber = (int) (Math.random() * 10);
            for (int chances = 3; chances > 0; --chances) {
                System.out.printf("Your number (%d time remaining, [s] to skip this round, [c] to stop game): ",
                        chances);
                String userGuest = sc.nextLine();
                if (userGuest.length() != 1)
                    continue;
                if (userGuest.equals("s"))
                    continue game_loop;
                if (userGuest.equals("c"))
                    break game_loop;
                isUserWin = (userGuest.charAt(0) - '0') == randomNumber;
                if (isUserWin)
                    break;
            }
            System.out.printf("You %s!!! (Number to guest: %d)%n", isUserWin ? "WIN" : "LOST", randomNumber);
            System.out.print("Do you want to stop game [y/n] ? ");
            String userChoice = sc.nextLine().toLowerCase();
            if (!userChoice.equals("y") && !userChoice.equals("1") && !userChoice.equals("yes"))
                break;
        }

        // 3. `return` statement
        // return is used to terminate the executing function
        // and reverse control to the function that invoked it
        // and return a value of function's return-type (eg. int, String ...)
        // or nothing with `void` function

        sc.close();
        System.out.println("\n--------------------");
        System.out.println("#vduczz");
    }
}
