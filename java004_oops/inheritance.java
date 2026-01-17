package java004_oops;

import java.util.ArrayList;
import java.util.List;

// Tính kế thừa - Inheritance
// mục đích: code reusability -> viết 1 lần ở super-class, dùng n lần ở sub-class
// keyword: (sub-class) extends (super-class)
// relation: IS-A => sub-class can have no more than 1 super-class

// inherited:
// - public/protected fields and methods.
// - if sub-class in the same package with super-class => default members
// non-inherited: 
// - private members
// - constructor (sub-class's construct have to call super() at its head)
// sub-class sẽ không thấy và không có các thuộc tính này nếu nó không tự khai báo
// => nếu gọi các members này từ instance của super-class, default của chúng ở super sẽ được gọi

// super vs this
// - this: tham chiếu tới sub-class
// - super: tham chiếu tới super-class

// inheritance types:
// - Single inheritance (Đơn kế thừa): 1 sub-class -> 1 super-class
// - Multilevel inheritance (Kế thừa đa cấp): A extends B (B extends C) // A -> B -> C
// - Hierarchical inheritance (Kế thừa thứ bậc): n sub-class -> 1 super-class
// Note: sub-class can not extends more than one super-class.

// `final` class: không cho phép kế thừa
// `final` method: không cho phép sub-class @Override

// Upcasting: 
// Parent p = new Child() 
// => sử dụng đối tượng cha để thao tác với các đối tượng lớp con
// > Lợi ích:
// - đễ thay đổi thằng con (vì đều chung cha):
// ex: p = new Child2() // ok
// - gom nhóm xử lý chung
// => Linh hoạt  + khả năng tổng quát hóa

class SuperClass {

    public SuperClass() {
        System.out.println("[Super] constructor is invoked!");
    }

    public void sayHello() {
        System.out.println("[Super] hello!");
    }

    public void sayHi() {
        System.out.println("[Super] hi!");
    }
}

class SubClass1 extends SuperClass {
    public SubClass1() {
        // super();

        System.out.println("[Sub-1] constructor is invoked!");
    }

    // method overriding
    @Override
    public void sayHello() {
        System.out.println("[Sub-1] hello!");
    }
}

class SubClass2 extends SuperClass {
    public SubClass2() {
        super();
        System.out.println("[Sub-2] constructor is invoked!");
    }

    // method overriding
    @Override
    public void sayHi() {
        System.out.println("[Sub-2] hi!");
    }
}

public class inheritance {
    public static void main(String[] args) {
        System.out.println();

        // super() is auto invoked at the first of subclass's constructor
        SubClass1 sc1 = new SubClass1();
        SubClass2 sc2 = new SubClass2();
        System.out.println();

        // upcasting
        // - flexibility
        SuperClass sp = new SubClass1();
        sp = new SubClass2(); // ok
        // - gom nhóm // gom các thể loại subclass của 1 super trong 1 chỗ
        List<SuperClass> list = new ArrayList<>();
        list.add(sc1);
        list.add(sc2);

        // thứ tự ưu tiên khi call method/prop
        // 1. check object đang lưu trong variable hiện tại
        // xem có định nghĩa lại / có tồn tại không
        // 2.1. Có => gọi
        // 2.2 Không có => gọi default (method/prop đó ở super)
        System.out.println();
        // trong sp hiện tại là SubClass2
        sp.sayHello(); // không override => gọi của super
        sp.sayHi(); // có override => gọi của sub
        // => subclass > superclass > error

        System.out.println("\n--------------------");
        System.out.println("#vduczz");
    }
}
