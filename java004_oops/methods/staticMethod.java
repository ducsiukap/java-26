package java004_oops.methods;

// Instance method (or normal method) belongs to an object:
// - need to create an instance of class to call
// - can access both instance and static members in class
// - can use `this`, `super` keyword.

// Static method belongs to class rather than any spesific object
// - can be invoked via class's name, without the initialization of class's instance
// - can access only to other static members.
// - can not use `this`, `super` keyword
class Method3 {
    int nonStaticField;
    static int staticField = (int) (Math.random() * 100 + 1);;

    public Method3() {
        this.nonStaticField = (int) (Math.random() * 100 + 1);
    }

    // non-static method
    public void nonStaticMethod() {
        System.out.println("access to non-static member: " + this.nonStaticField);
        // static members do not need this keyword
        System.out.println("access to static member: " + staticField);
    }

    // static method
    public static void staticMethod() {
        // cannot use this, super keyword

        // cannot access to non-static method
        // System.out.println("non-static member: " + nonStaticField); // error
        System.out.println("access to static member: " + staticField); // ok
    }
}

public class staticMethod {
    public static void main(String[] args) {
        System.out.println();

        // Invoke non-static (instance) method
        // need an instance of class to call instance method
        Method3 object = new Method3();
        object.nonStaticMethod();
        System.out.println();

        // Invoke static method:
        // - using class's name
        Method3.staticMethod();
        // - using object // the same result for each object
        object.staticMethod();
        new Method3().staticMethod();

        System.out.println("\n--------------------");
        System.out.println("#vduczz");
    }
}
