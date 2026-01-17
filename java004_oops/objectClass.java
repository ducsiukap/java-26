package java004_oops;

import java.util.Objects;

// `Object` class là super-class của mọi class.
// Dù không extends Object, java luôn ngầm định điều đó với mọi class.

// Propose of `Object` class:
// - root of all Java classes.
// - defines essential methods shared by all objects // ta có thể @Override lại các methods này

class OC1 {
    // private int x;

    public OC1() {
        // this.x = (int) (Math.random() * 100 + 1);
    }

}

class OC2 implements Cloneable {
    private int x;

    public OC2() {
        this.x = (int) (Math.random() * 100 + 1);
    }

    @Override
    public String toString() {
        return "{%n\tx: %d%n}".formatted(this.x);
    }

    @Override
    public boolean equals(Object obj) {
        return this.x == ((OC2) obj).x;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        // không nên:
        // return this
        // => mọi thay đổi bên trong the copied object (trừ re-assign)
        // sẽ ảnh hưởng tới object hiện tại, và ngược lại

        // shallow copy
        // - create new object
        // - copy từng field sang
        // OC2 newObject = new OC2();

        // set new object's props by current object's props
        // newObject.x = this.x;

        // return new object
        // return newObject;

        // hoặc đơn giản là gọi:
        // super.clone() :)
        return super.clone();

        // ========

        // Deep copy
        // - làm tương tự shallow copy, chỉ khác ở những field có kiểu tham chiếu
        // => với những field này, cần copy từng field con của nó
        // hoặc tạo list mới và đổ dữ liệu cũ sang (với list)
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.x);
    }

}

public class objectClass {
    public static void main(String[] args) throws CloneNotSupportedException {
        System.out.println();

        // Object class methods:
        OC1 o1 = new OC1(), o2 = new OC1();
        OC2 o3 = new OC2(), o4 = new OC2();

        // .toString() => thứ được hiển thị khi gọi System.out.println(object)
        // default: ClassName@hash
        System.out.println(o1);
        System.out.println(o3);
        System.out.println();

        // .equals(other) => compare 2 same-type objects.
        // default: a.equals(b) is a==b
        System.out.println(o1.equals(o2)); // default execute, => o1 == o2 ?
        System.out.println(o3.equals(o4)); // overload, o3.x == o4.x ?
        System.out.println();

        // .clone() // photocopy
        // Điều kiện:
        // - implements Cloneable
        // - throws & handle CloneNotSupportedException
        OC2 o5 = (OC2) o3.clone();
        System.out.println();
        System.out.println(o5);

        // .hashCode() // trả về int number đại diện cho object
        // => có thể dùng làm key cho Map, Set, ..
        // rule:
        // - if (a.equals(b)) => a.hashCode() == b.hashCode()
        // - ngược lại, hashCode bằng nhau chưa chắc equals.
        // => nếu override .equals(), nên override lại .hashCode()
        // Cách đơn giản nhất để override .hashCode() khi đã override .equals()
        // - .equals so sánh những props nào
        // => hash trên chính các props đó
        // => hashcode = Objects.hash(props);
        System.out.println();
        System.out.println(o5.equals(o3));
        System.out.println(o5.hashCode() + " - " + o3.hashCode());

        // .getClass() // trả về thông tin class (metadata) của object hiện tại
        //

        // .finalized() // dosmth trước khi object bị GC hủy
        // bị khai tử từ Java 9.

        // wait(), notify(), notifyAll() // lập trình bất đồng bộ

        System.out.println("\n--------------------");
        System.out.println("#vduczz");
    }
}
