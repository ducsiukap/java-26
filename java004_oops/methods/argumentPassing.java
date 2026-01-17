package java004_oops.methods;

// By default, passing arguments in Java is PASS-BY-VALUE:
// - with primitive data type => its actually pass-by-value
// - with reference data type => it pass a copy of object
// note: a copy of object chỉ đơn giản là 1 biến khác cùng trỏ tới vùng nhớ của biến được truyền. So:
// => gán object mới cho biến : không ảnh hưởng
// => chỉnh sửa bên trong object: thuộc tính, ... => thay đổi object gốc

class Method2 {
    // primitive type arg
    public static void sayHello(String userFullname) {
        // reassign the passed argument
        userFullname = "user-default";
        System.out.printf("Hello %s!!!%n", userFullname);
    }

    // object type arg
    public static void printUser1(User1 user) {
        // reassign the passed object
        user = new User1("user-default", 99);
        System.out.print("user in printUser1:%n%s".formatted(user));
    }

    public static void printUser2(User1 user) {
        // change object props, not re-assign
        user.name = "user-default";
        user.age = -1;
        System.out.println("user in printUser2:%n%s".formatted(user));
    }

}

class User1 {
    public String name;
    public int age;

    public User1(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "{%n\tname: %s,%n\tage: %d%n}%n".formatted(name, age);
    }
}

public class argumentPassing {
    public static void main(String[] args) {
        System.out.println();

        String userFullname = "vduczz";
        Method2.sayHello(userFullname);
        System.out.println("userFullname after passed: %s%n".formatted(userFullname));

        // reference type
        User1 user = new User1(userFullname, 22);
        Method2.printUser1(user);
        System.out.println("user in main: %n%s".formatted(user));

        System.out.println();
        Method2.printUser2(user);
        System.out.println("user in main: %n%s".formatted(user));

        System.out.println("\n--------------------");
        System.out.println("#vduczz");
    }

}
