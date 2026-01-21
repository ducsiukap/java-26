package java006_exceptions;

import java.util.Objects;
import java.util.Optional;

// HDPE thì ngon nuôn :)

// NullPointerException - NPE
// NPE không phải để catch, mà là check sơ sài #codengu :)

public class npe {
    public static void main(String[] args) {
        String s = (Math.random() < 0.25) ? "non-null str" : null; // 75% chance to be null :)

        // can not access to null object
        // s.charAt(0) // -> error

        // ===============
        // to handle npe
        // rất không nên try-catch
        // có các cách sau:

        // ---------------
        // > if null
        if (s == null) {
            // do smth
            System.out.println("null");
        } else {
            System.out.println(s.toUpperCase());
        }

        // ---------------
        // > yoda condition
        // dùng khi so sách 2 object của cùng 1 class
        // thay vì: s.equals("smth")
        // thì:
        if ("smth".equals(s)) {
            // do smth
        } else {
            // do smth
        }

        // ---------------
        // > Objects class
        // - check null
        if (Objects.isNull(s)) {
            // do smth
        }
        // - default value if null
        String upperCase = Objects.requireNonNullElse(s, "default string").toUpperCase();
        System.out.println(upperCase);

        // > Optional class
        // Optional<String> box = Optional.of(s); // non-nullable
        Optional<String> box = Optional.ofNullable(s); // nullable
        System.out.println(box.orElse("default value if null"));
        // do smth
        // if null -> skip map()
        box.map(value -> value.toUpperCase()).ifPresent(value -> System.out.println("upper case: " + value));

        System.out.println("\n--------------------");
        System.out.println("#vduczz");
    }

}
