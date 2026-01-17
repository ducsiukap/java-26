package java004_oops.methods;

// Function (method) trong Java phải được chứa trong 1 class.

// syntax 
// modifier [non-access modifier] return-type methodName([type params]) [throw exceptionList] {
// // methodBody
// }
// trong đó:
// - modifier: public/protected/default/private
// - non-access modifer: static, final, synchronized, ... 

// method signature = name + params list.
class Method1 {
    public static void sayHello(String userFullname) {
        System.out.println("Hello " + userFullname + "!!!");
    }
}

public class methodBasic {
    public static void main(String[] args) {
        System.out.println();

        Method1.sayHello("vduczz");

        System.out.println("\n--------------------");
        System.out.println("#vduczz");
    }
}
