
// contructor là hàm khởi tạo, được chạy tự động mỗi khi 1 instance của class được tạo
// Mục đích:
// - khởi tạo giá trị ban đầu cho các biến
// - chạy code logic cần thiết khi object được tạo

// Rules:
// - cùng tên với class
// - không có return type
// - 1 class có thể có nhiều contructor

// note:
// - this / this() => đại diện cho lớp hiện tại / constructor lớp hiện tại
// - super / super() => đại diện cho lớp cha / constructor lớp cha (trong kế thừa)

class Constructor1 {
    public int a, b;

    // Default contructor
    // - nếu không định nghĩa, Java luôn tự sinh default constructor cho class
    // - nếu có bất kì constructor nào khác được khai báo,
    // default constructor sẽ bị hủy
    // - default contructor không có params
    public Constructor1() {
        System.out.println("[Default contructor] an Instance of class Constructor1 has been created!");
        System.out.printf("a = %d, b = %d%n", a, b);
    }

    // Parameterized Contructor
    // - là hàm khởi tạo có tham số
    // - phải được định nghĩa trước khi gọi
    public Constructor1(int a) {
        this.a = a;
        System.out.println("[Parameterized constructor] an Instance of class Constructor1 has been created!");
        System.out.printf("a = %d, b = %d%n", a, b);
    }

    public Constructor1(int a, int b) {
        this.a = a;
        this.b = b;
        System.out.println("[Parameterized constructor] an Instance of class Constructor1 has been created!");
        System.out.printf("a = %d, b = %d%n", a, b);
    }

    // Copy constructor
    // - take another existed instance of this class as parameter
    public Constructor1(Constructor1 other) {
        this.a = other.a;
        this.b = other.b;
        System.out.println("[Copy contructor] an Instance of class Constructor1 has been created!");
        System.out.printf("a = %d, b = %d%n", a, b);
    }
}

public class constructorTypes {
    public static void main(String[] args) {
        // default contructor
        Constructor1 obj1 = new Constructor1();
        System.out.println();

        // parameterized construcotr
        Constructor1 obj2 = new Constructor1(3);
        System.out.println();
        Constructor1 obj3 = new Constructor1(7, 8);
        System.out.println();

        // copy constructor
        Constructor1 obj4 = new Constructor1(obj3);
        System.out.println();

        System.out.println("\n--------------------");
        System.out.println("#vduczz");
    }
}