package java004_oops;

// Tính trừu tượng - Abstraction
// abstraction giống như khi vào trang web, ta biết:
// - nó có nút đăng nhập / chức năng đăng nhập
// - nó có nút đăng kí.
// Nhưng ta không biết bên trong hệ thống hoạt động ra sao khi ta chọn các chức năng đó.

// - Abstraction: "cái này làm được những gì?" (What)
// - Implementation: "nó làm điều đó như nào?" (How)

// Trong java, có 2 công cụ chính để đạt được Abstraction:
// 1. Abstract class: 
// + class được khai báo kèm theo 'abstract' keyword
// + không thể tạo instance của abstract class
// + có thể chứa hàm bình thường, props + abstract method
// Note: class có ít nhất 1 `abstract` method, phải được khai báo là abstract class
abstract class Pet {
    // props
    private String name;

    public Pet(String name) {
        this.name = name;
    }

    // normal method
    public void sleep() {
        System.out.println("Zzzzzz....");
    }

    public String getName() {
        return this.name;
    }

    // abstract method
    // *declared with `abstract` keyword
    abstract public void makeSound();
}

// 2. Interface
// - interface is not a type of class
// - no constructor
// - declared with `interface` keyword
// - trước đây (trước Java-8): trong interface chỉ tồn tại public abstract
// method.
// Hiện nay (sau Java-8), interface có thể tồn tại normal / static method
interface Flyable {
    void fly(); // public abstract
}

// sub-classes of abstract class / interface
// have to implement (@Override) all abstract methods.
class Dog extends Pet {
    public Dog(String name) {
        super(name);
    }

    // implement abstract method
    @Override
    public void makeSound() {
        System.out.println("gau gau...");
    }
}

class Bird extends Pet implements Flyable {
    public Bird(String name) {
        super(name);
    }

    // implements abstract method
    @Override
    public void makeSound() {
        System.out.println("chic chic chic ...");
    }

    @Override
    public void fly() {
        System.out.println("woohooooooooo~ Im flying...");
    }
}

public class abstraction {
    public static void main(String[] args) {
        Dog bong = new Dog("Bong");
        System.out.print("\nDog's sound: ");
        bong.makeSound();

        Bird baka = new Bird("Baka");
        System.out.print("\nBird's sound: ");
        baka.makeSound();
        System.out.print("Bird is flying: ");
        baka.fly();

        System.out.println("\n--------------------");
        System.out.println("#vduczz");
    }
    // Abstract class vs Interface
    // > Keyword:
    // - abstract class: `abstract`, (subclass) `extends` (superclass)
    // - interface: `interface`, (subclass) `implements` (interface)
    // > Relation
    // - abstract class: IS-A => subclass can extend only one superclass
    // - interface: CAN-DO => subclass can implement multiple interfaces
    // > Variable
    // - abstract class: `static`, `final`, access-modifiers, .. is useable
    // - interface: only 'public static final' variable (constant)
    // > Constructer:
    // - abstract class: có constructor và bắt buộc gọi super() ở đầu constructor
    // note: nếu không gọi, Java ngầm định chèn super() vào đầu constructor
    // - interface: không có constructor
    // > Performance:
    // abstract class is a little faster than interface

    // use-case:
    // > abstract class:
    // - code reuse
    // - muốn sử dụng các biến private, protected, ..
    // - các class con có quan hệ chặt chẽ với class cha.
    // > interface:
    // - quy định các hành động chung cho các class không liên quan gì nhau
    // ex: Airplain and Bird are flyable.
    // - multi-inheritance
    // - muốn tách rời hoàn toàn định nghĩa và cài đặt
}