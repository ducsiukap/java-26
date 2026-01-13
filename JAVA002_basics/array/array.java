package JAVA002_basics.array;

import java.util.Arrays;
import java.util.stream.IntStream;

public class array {
    public static void main(String[] args) {
        // 1. create array
        // 1.1. create an default elems array:
        // type[] arrayName = new type[arraySize];
        int numbers[] = new int[5];
        String[] texts = new String[3];
        System.out.printf("%nnumbers: %s%n", Arrays.toString(numbers));
        // 1.2. create + assign value of element // static initialization
        int[] numbers2 = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        String[] texts2 = { "I", "love", "Java" };
        System.out.printf("%nnumbers2: %s%ntexts2: %s%n", Arrays.toString(numbers2), Arrays.toString(texts2));
        // 1.2. using java.util.stream.IntStream
        int start = 1, end = 10;
        // 1.2.1. .range(start, end).toArray() => [start, end-1]
        System.out.printf("%nIntStream.range(%d, %d).toArray(): \t%s", start, end,
                Arrays.toString(IntStream.range(start, end).toArray()));
        // 1.2.2. .rangeClosed(start, end).toArray() => [start, end]
        System.out.printf("%nIntStream.rangeClosed(%d, %d).toArray(): \t%s", start, end,
                Arrays.toString(IntStream.rangeClosed(start, end).toArray()));
        // 1.2.3. of(args).toArray()
        System.out.printf("%nIntStream.of(%d, %d).toArray(): \t%s", start, end,
                Arrays.toString(IntStream.of(start, end).toArray()));
        int mid = (start + end) >> 1;
        System.out.printf("%nIntStream.of(%d, %d, %d).toArray(): \t%s", start, mid, end,
                Arrays.toString(IntStream.of(start, mid, end).toArray()));
        int mid1, mid2;
        mid1 = (start + mid) >> 1;
        mid2 = (mid + end) >> 1;
        System.out.printf("%nIntStream.of(%d, %d, %d, %d, %d).toArray(): \t%s%n", start, mid1, mid, mid2, end,
                Arrays.toString(IntStream.of(start, mid1, mid, mid2, end).toArray()));

        // 2. Accessing elements
        // using array[index], index starts from 0
        // 2.1. update value => array[index] = value
        System.out.println();
        texts2[1] = "hate";
        for (int i = 0; i < 3; ++i)
            texts[i] = texts2[i];
        // 2.2. get value => array[index]
        for (int i = 0; i < 3; ++i) {
            System.out.printf("%ntexts[%d]: %s", i, texts[i]);
        }
        System.out.println();

        // 3. multi-dimention array
        // example for 2D array
        // 3.1. create
        // type[][] matrixName = new type[rows][cols] // cols cam be specified later
        int[][] matrix = new int[3][];
        // 3.2. accessing
        // with n-D array (n > 1), each row is an (n-1)-D array
        for (int i = 0; i < matrix.length; ++i) {
            int cols = (int) (Math.random() * 10 + 1);
            matrix[i] = IntStream.rangeClosed(1, cols).toArray();
            // or
            // matrix[i] = new int[cols]
            // to init an empty array
        }
        System.out.printf("%n%nmatrix: %s%n", Arrays.deepToString(matrix));
        // typically, each row in a matrix will have the same length.
        // type[][] matrix = new type[rows][cols];
        // for (int i = 0; i < rows; ++i) matrix[i] = new type[cols];

        // 4. get length (for 1D array) or number of row (for nD array):
        // array.length
        System.out.printf("%n%ntexts.length = %d", texts.length);
        System.out.printf("%nmatrix.length = %d%n", matrix.length);

        System.out.println("\n--------------------");
        System.out.println("#vduczz");
    }

}
