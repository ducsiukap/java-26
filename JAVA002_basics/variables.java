package JAVA002_basics;

import java.util.Scanner;

public class variables {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 1. Identifiers
        // - Identifier is the name that given to
        // Variables/Methods/Classes/Packages/Interfaces, etc.
        // - Rules:
        // + Allowed: [a-z], [A-Z], [0-9], $, _
        // + Cannot start with a digit
        // + case-sensitive
        // + no-limit on length, but 4-15 + camelCase is recommended
        // + cannot use Java reserved words (keywords + literals)
        System.out.println();
        System.out.print("Enter your name: ");
        String userName = sc.nextLine();
        System.out.printf("Hello, %s!%n", userName);

        // 2. Keywords
        // Java has 53 reserved words, include 50 keywords and 3 literals
        // identifiers have to avoid using these reserved words.
        // read more:
        // https://docs.oracle.com/javase/tutorial/java/nutsandbolts/_keywords.html

        // 3. Variables
        // > variable is a container in memory to store data that can be actual data or
        // reference.
        // 3.1. Variable components
        // - Datatype: type of stored data => defines how is the data being stored and
        // manipulated.
        // - Variable name: identifier to access the variable.
        // - Value: the actual data holded by the variable.
        // 3.2. Variable declaration syntax:
        // dataType variableName [= value];
        int randInt; // declare without value assigned.
        randInt = (int) (Math.random() * 1000);
        float randFloat = (float) (Math.random() * 1303f);
        System.out.println();
        System.out.printf("Random int number: %d%nRandom float number: %.6f%n", randInt, randFloat);
        // 3.3. Types of variables in java
        // 3.3.1. Local variable
        // - declared within a method, constructor, or block.
        // - accessible only within that method, constructor, or block.
        // 3.3.2. Instance variable
        // - declared within a class, but outside any method, constructor, or block.
        // - class properties
        // - accessible from all NON-STATIC methods in the class.
        // 3.3.3. Static variable
        // - same with instance variable, but with `static` keyword.
        // - shared among all instances of the class.
        // Note: khác với instance variable là riêng biệt cho mỗi object,
        // static variable là dùng chung cho tất cả (1 bản cho toàn bộ class)
        // => sửa ở 1 nơi -> tất cả cùng đổi
        sc.close();
        //
        System.out.println("\n--------------------");
        System.out.println("#vduczz");
    }

}
