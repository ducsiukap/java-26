package java005_interfaces;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

// interface types:

// > marker interface: không có method nào 
//      -> dùng để gán nhãn cho class, đánh dấu class có khả năng nào đó với JVM/Java Compiler
//   ex:
//      + io.Serializable -> cho phép object có thể chuyển thành byte-stream -> truyền qua mạng / lưu file
//      + lang.Clonable -> mở khóa hàm .clone() :)
//      + util.RandomAccess -> cho phép list truy cập ngẫu nhiên. ex: ArrayList -> O(1)
//      + rmi.Remote -> object có thể gọi hàm từ máy khác (Remote Method Invocation - RMI)
//      + util.EventListener -> lắng nghe sự kiện

// > functional interface: interface chỉ có một abstract method
//      // note: chỉ cần đảm bảo điều kiện chỉ có 1 abstract method
//      // các member khác tùy duyên: public static props, default/static/private method
//      // annotation @FunctionalInterface (không bắt buộc nhưng rất khuyến khích dùng)

// note: 
//  - functional interface là nền tảng của lambda expression trong Java
//  - nếu interface có các hàm abstract trùng với các public method của java.lang.Object
//    thì các hàm đó không được tính là abstract method của interface đó 
//      // vì mặc định mọi class đều extends Object
@FunctionalInterface
interface Square {
    double calc(double x);
}

public class functionalInterface {
    public static void main(String[] args) {
        System.out.println();

        // Trước Java 8, dùng anonymous class để tạo instance của functional interface
        Square square = new Square() {
            @Override
            public double calc(double x) {
                System.out.println("Calculating square of " + x);
                return x * x;
            }
        };
        double result = square.calc(3.14);
        System.out.println("Result: " + result);

        // Sau Java 8: -> lambda expression
        // có thể tạo instance của functional interface bằng lambda expression
        // cú pháp:
        // interfaceInstance = (parameters) -> expression/body
        square = (x) -> {
            System.out.println("Calculating square of " + x);
            return x * x;
        };

        result = square.calc(5);
        System.out.println("Result: " + result);
        System.out.println();

        // ===============
        // Các loại functional interface trong java

        // > Consumer -> tiêu thụ
        // > abstract method: void accept(T t)
        Consumer<String> log = (msg) -> System.out.println(msg);
        log.accept("[Consumer] hello world!");

        // > Supplier -> cung cấp
        // > abstract method: T get()
        Supplier<Integer> randomInt = () -> (int) (Math.random() * 100);
        System.out.println("[Supplier] " + randomInt.get());

        // > Function -> chuyển đổi
        // > abstract method: R apply(T t)
        Function<String, Integer> strToInt = (str) -> {
            try {
                return Integer.parseInt(str);
            } catch (NumberFormatException e) {
                return null;
            }
        };
        System.out.println("[Function] " + strToInt.apply("HelloWorld"));
        System.out.println("[Function] " + strToInt.apply("12345"));

        // > Predicate -> kiểm tra
        // abstract method: boolean test(T t)
        Predicate<Integer> isEven = (num) -> (num & 1) == 0;
        System.out.println("[Predicate] " + isEven.test(24));
        System.out.println("[Predicate] " + isEven.test(13));

        // UnaryOperator<T> // Function<T, T> -> nhận T trả về T
        // BinaryOperator<T> // BiFunction<T, T, T> -> nhận 2 T trả về T

        // Ngoaif ra, thêm Bi vào trước các funcational interface trên
        // để tạo các interface nhận 2 tham số
        // ex: BiConsumer<T, U>, BiFunction<T, U, R>, BiPredicate<T, U>

        System.out.println("\n--------------------");
        System.out.println("#vduczz");
    }

}
