package JAVA002_basics;

public class loops {
    public static void main(String[] args) {
        int n = (int) (Math.random() * 3 + 2);
        n <<= 1; // n*=2
        ++n;
        System.out.println("n: " + n);

        // 1. `for` loop
        // 1.1. for loop
        // for(initialization; condition; update) {}
        System.out.println();
        for (int i = 1; i <= n; ++i) {
            // calculate component lengths
            int startLength = (i << 1) - 1;
            if (startLength > n)
                startLength = (n << 1) - startLength;
            int spaceLength = (n - startLength) >> 1;
            // init components
            StringBuilder spaces = new StringBuilder();
            for (int j = 0; j < spaceLength; ++j)
                spaces.append(" ");
            StringBuilder stars = new StringBuilder();
            for (int j = 0; j < startLength; ++j)
                stars.append("*");
            // print line
            StringBuilder line = new StringBuilder();
            line.append("|").append(spaces).append(stars).append(spaces).append("|");
            System.out.println(line.toString());
        }
        // 1.2. for-each (for-in) loop
        System.out.println();
        int startLengths[] = new int[n];
        for (int i = 0; i < n; ++i) {
            int startLength = (i << 1) + 1;
            if (startLength > n)
                startLength = (n << 1) - startLength;
            startLengths[i] = startLength;
        }
        // for-each:
        // for (dataType item: collection) {}
        for (int startLength : startLengths) {
            int spaceLength = (n - startLength) >> 1;
            StringBuilder spaces = new StringBuilder();
            for (int j = 0; j < spaceLength; ++j)
                spaces.append(" ");
            StringBuilder stars = new StringBuilder();
            for (int j = 0; j < startLength; ++j)
                stars.append("*");
            StringBuilder line = new StringBuilder();
            line.append("|").append(spaces).append(stars).append(spaces).append("|");
            System.out.println(line.toString());
        }

        // 2. `while` loop
        // while(condition) {}
        int i = 0, j;
        System.out.println();
        while (i < n) {
            int spaceLength = (i << 1) + 1;
            if (spaceLength > n)
                spaceLength = (n << 1) - spaceLength;
            StringBuilder spaces = new StringBuilder();
            j = 0;
            while (j++ < spaceLength) {
                spaces.append(" ");
            }
            int starLength = (n - spaceLength) >> 1;
            StringBuilder stars = new StringBuilder();
            j = 0;
            while (j++ < starLength)
                stars.append("*");
            System.out.printf("|%s%s%s|%n", stars.toString(), spaces.toString(), stars.toString());
            // update step
            ++i;
        }
        // 3. `do-while` loop
        // do {} while(condition);
        System.out.println();
        i = 0;
        do {
            int spaceLength = (i << 1) + 1;
            if (spaceLength > n)
                spaceLength = (n << 1) - spaceLength;
            StringBuilder spaces = new StringBuilder();
            j = 0;
            while (j++ < spaceLength) {
                spaces.append(" ");
            }
            int starLength = (n - spaceLength) >> 1;
            StringBuilder stars = new StringBuilder();
            j = 0;
            while (j++ < starLength)
                stars.append("*");
            System.out.printf("|%s%s%s|%n", stars.toString(), spaces.toString(), stars.toString());
            // update step
            ++i;
        } while (i < n);

        System.out.println("\n--------------------");
        System.out.println("#vduczz");
    }
}
