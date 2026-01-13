// Java datatypes
package JAVA002_basics;

public class dataTypes {
    public static void main(String[] args) {
        System.out.println();
        // 1. Primitive data types
        // 1.1. Numeric types
        // 1.1.1. Integer
        // > byte/Byte: 1 byte, range(-128, 127).
        // > short/Short: 2 bytes, rangee(-32.768, 32.767).
        // > int/Integer: 4 bytes.
        // > long/Long: 8 bytes, suffix `L` or `l`.
        System.out.printf("Random int-type number: %d%n", (int) (Math.random() * Integer.MAX_VALUE));
        // 1.1.2. Floating-point
        // > float/Float: 4 bytes, precision up to 7 decimal digits (`f`/`F` suffix)
        // > double/Double: 8 bytes, precision up to 15 decimal digits.
        System.out.printf("Random float-type number: %.7f%n", (float) (Math.random() * Float.MAX_VALUE));
        // 1.2. Non-numeric types
        // > char/Character: 2 bytes, Unicode character.
        // > boolean/Boolean: 1 bit, true or false.

        // 2. Reference datatypes:
        // ussually is a Object.
        // hold address of an object, not the object's data.
        // e.g., String, Array, Class, Interface, Object.

        System.out.println("\n--------------------");
        System.out.println("#vduczz");
    }

}
