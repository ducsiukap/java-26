package JAVA002_basics.string;

import java.util.Scanner;

// String is a sequence of character
// immutable

public class string {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println();
        // 1. Create a string
        // 1.1. constant String // stored in StringPool
        // String str = "content"
        String me = "vduczz"; // stored in StringPool
        // nếu "vduczz" đã tồn tại trong StringPool thì không tạo object mới nữa
        // ---
        // 1.2. String object // stored in head memory
        // luôn tạo object mới
        // using String constructor
        // - new String("content")
        // - new String(byte[] bytes, int startIndex, int endIndex)
        // - new String(char[] charArray, int startIndex, int count)
        // - new String(int[] unicode_point, int offset, int count)
        // - new String(StringBuffer sb) // new String(StringBuilder sb)
        String meStrObj = new String("vduczz"); // stored in heap memory
        // str.intern() để chuyển từ heap -> pool

        // 2. Access element
        // using .charAt(index)
        for (int i = 0; i < me.length(); ++i) {
            System.out.print(me.charAt(i));
        }
        // cannot access using [index]
        // me[0] // error
        // String is immutable => cannot update element
        // me.charAt(0) = 'x' // error

        // 3. String compare
        System.out.printf("%n%nEnter your name: ");
        String you = sc.nextLine();
        // using equals()
        System.out.printf("-----%n\"%s\".euqals(\"%s\") : %b%n", me, you, me.equals(you));
        // using compareTo() // <0 for smaller, 0 for equal, >0 for larger
        System.out.printf("-----%n\"%s\".compareTo(\"%s\") : %d%n", me, you, me.compareTo(you));
        // cannot using ==
        // because String is an object
        // == to compare the reference
        System.out.printf("-----%n\"%s\" == \"%s\" : %b%n", me, you, me == you);
        String me2InStringPool = "vduczz"; // refer to the same object in StringPool
        System.out.printf("%nme: %s%nme2InStrPool: %s%nmeStrObj: %s%n", me, me2InStringPool, meStrObj);
        System.out.println("String compare using == operator:");
        System.out.printf("me == me2InStrPool : %b%n", me == me2InStringPool); // true
        System.out.printf("me == meStrObj : %b%n", me == meStrObj); // false

        // 4. String concat
        // in almost case, using str1 + str2 to concat
        // or
        // using str1.concat(str2)
        // str1.concat(str2) is similar to : str1 += str2

        // some popular methods:
        // .length() => get length
        // .charAt(index)
        // .subString(startIdx) // startIdx to end of str
        // .substring(startIdx, endIdx) // [startIdx, endIdx-1]
        // .concat(str)
        // .indexOf(str), .indexOf(str, startIdx) // first occur
        // .lastIndexOf(str)
        // .equals(str) , equalsIgnoreCase(str)
        // .compareTo(str) , compareToIgnoreCase(str)
        // .toLowerCase(), .toUpperCase()
        // .trim() // begin + end
        // .replace(char old, char new)
        // .contains(str)
        // .toCharArray()
        // .startsWith(str), endsWith(str)

        sc.close();
        System.out.println("\n--------------------");
        System.out.println("#vduczz");
    }
}
