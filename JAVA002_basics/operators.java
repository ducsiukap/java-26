package JAVA002_basics;

public class operators {
    public static void main(String[] args) {
        int a, b, c;
        a = (int) (Math.random() * 100); // 0 - 99
        b = (int) (Math.random() * 100); // 0 - 99
        c = (int) (Math.random() * -100) - 1; // -100 - -1

        // Arithmetic Operators
        // +, -, *, /, %
        System.out.printf("%n%d + %d = %d%n", a, b, a + b);
        System.out.printf("%d %% %d = %d%n", a, c, a % c);

        // Unary Operators
        // ++, --
        // x++/x-- => use first, the increment/decrement
        // ++x/--x => increment/decrement first, then use
        System.out.printf("%na=%d, b=%d%n(a++ + b)= %d%n", a, b, a++ + b);
        System.out.printf("// after: a=%d, b=%d%n", a, b);
        System.out.printf("++a + b = %d%n", ++a + b);
        System.out.printf("// after: a=%d, b=%d%n", a, b);

        // Assignment Operators
        // =, +=, -=, *=, /=, %=
        // ++ is += 1
        // -- is -= 1

        // Relational Operators
        // ==, !=, >, >=, <, <=
        // == is equal, != is not equal
        // > is greater than, >= is not less than
        // < is less than, <= is not greater than

        // Logical Operators
        // &&, ||, !
        // && is AND
        // || is OR
        // ! is NOT
        System.out.printf("%n(%d == %d) && (%d > %d) = %b%n", a, b, a, c, (a == b) && (a > c));
        System.out.printf("(%d == %d) || (%d > %d) = %b%n", a, b, a, c, (a == b) || (a > c));

        // Bitwise Operators
        // &, |, ^, ~, <<, >>, >>>
        // >> : right shift excluding sign bit
        // >>> : right shift anything, including sign bit
        System.out.printf("%na=%s (%d), c=%s (%d)%n", Integer.toBinaryString(a), a, Integer.toBinaryString(c), c);
        System.out.printf("a & c = %s (%d)%n", Integer.toBinaryString(a & c), a & c);
        System.out.printf("c >> a = %s (%d)%n", Integer.toBinaryString(c >> a), c >> a);
        System.out.printf("c >>> a = %s (%d)%n", Integer.toBinaryString(c >>> a), c >>> a);

        // Tenary Operator
        // condition ? expIfTrue : expIfFalse
        System.out.printf("%nmax(%d, %d) = %d%n", a, b, a > b ? a : b);

        // Instanceof Operator
        // object instanceof Class // true/false
        Integer intObj = a;
        System.out.printf("%n%b%n", intObj instanceof Integer);
        //
        System.out.println("\n--------------------");
        System.out.println("#vduczz");
    }
}
