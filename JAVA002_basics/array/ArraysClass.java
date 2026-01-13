package JAVA002_basics.array;

// !!!!!! READ MORE
// https://www.geeksforgeeks.org/java/array-class-in-java/

// import package
import java.util.Arrays;
import java.util.List;

public class ArraysClass {
    public static void main(String[] args) {
        // Arrays s a utility class (in java.util package)
        // that provides a collection of static methods
        // for performing common operations on Java arrays,
        // such as sorting, searching, comparing and converting arrays to strings

        int[] array = java.util.stream.IntStream.rangeClosed(3, 13).toArray();

        // .asList(arr) => convert an array of type T to an object of type List<T>
        System.out.println();
        System.out.println(Arrays.asList(array) instanceof List);
        System.out.println(array);
        System.out.println(Arrays.asList(array));

        // .sort()
        // .binarySearch()
        // .compare()
        // .equals()

        // .copyOf() // deep copy
        System.out.println();
        int[] copied = Arrays.copyOf(array, array.length);
        System.out.println(copied);
        System.out.println(array);

        // printout array's elems
        // for 1D array
        System.out.println();
        System.out.println(Arrays.toString(array));
        // for nD array
        int[][][] array3D = { { array, array }, // 1s row
                { { randNumber(), randNumber() }, {}, { randNumber(), randNumber(), randNumber() } } // 2nd row
        };
        System.out.println(Arrays.deepToString(array3D));

        // .fill()
        // .mismatch()
        // .setAll()
        // .stream()
    }

    private static int randNumber() {
        return (int) (Math.random() * 100 + 1);
    }

}
