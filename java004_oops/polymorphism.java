package java004_oops;

// Tính đa hình - Polymorphism
// method có thể được định nghĩa theo nhiều cách!

// Static polymorphism - method overloading
// Cơ chế nạp chồng hàm:
// - hàm cùng tên
// - khác parameter list : số lượng / kiểu / thứ tự (của các tham số khác kiểu)
class Hello1 {

    public void sayHello(String name) {
        System.out.printf("Hello, %s%n", name);
    }

    public void sayHello(String... nameList) {
        for (String x : nameList) {
            System.out.printf("Hello, %s%n", x);
        }
    }

    // thứ tự ưu tiên khi match hàm chạy:
    // 1. khớp chính xác
    // 2. widening (int -> long, ...)
    // 3. boxing / unboxing (int -> Integer, Integer -> int, ...)
    // 4. vararg (int..., long..., ...)
}

// Dynamic polymorphism - method overridding
// Inheritance
// thứ tự ưu tiên:
// 1. override method in sub-class
// 2. method in super-class (nếu sub-class không override method đó)
class Hi1 extends Hello1 {
    @Override
    public void sayHello(String name) {
        System.out.printf("Hi, %s%n", name);
    }
}

public class polymorphism {
    public static void main(String[] args) {
        System.out.println();

        String[] nameList = { "vduczz", "nddat", "ronaldo", "messi" };
        String name = "ramos";

        // static polymorphism
        Hello1 obj = new Hello1();
        obj.sayHello(name);
        System.out.println();
        obj.sayHello(nameList);

        System.out.println("\n================\n");

        // dynamic polymorphism
        Hello1 obj2 = new Hi1();
        obj2.sayHello(name); // Hi1.sayHello(String name)
        System.out.println();
        obj2.sayHello(nameList); // Hello1.sayHello(String... name)

        System.out.println("\n--------------------");
        System.out.println("#vduczz");
    }
}