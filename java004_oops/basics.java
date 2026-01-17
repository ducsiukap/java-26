package java004_oops;

// syntax to create a class 
// class clasName {}
class ClassName {
    // properties (fields/features/ ...)
    int fields;

    // constructor
    // - no return-type
    // - same name with className
    public ClassName() {
        System.out.printf("an instance of class %s is created!%n", this.getClass().getName());
        this.fields = (int) (Math.random() * Integer.MAX_VALUE);
    }

    // methods (functions, behavious, ...)
    public int getField() {
        return this.fields;
    }
}

// note:
// - an .java file can have only one or zero public class
// - name of public class should be the same with file name.
// - any class can have main() method,
// but it should be included inside public class
public class basics {
    public static void main(String[] args) throws Exception {
        System.out.println();

        // object: an instance of class
        // to create object:
        // - using new keyword:
        ClassName object = new ClassName();
        // - using Reflection
        ClassName object2 = (ClassName) Class.forName("java004_oops.ClassName").getDeclaredConstructor().newInstance();
        // - using clone if class implement Clonable
        // className object3 = object.clone()
        // - using annonymous object

        // Accessing to class's members (field/method)
        // - static member can be invoked directly via classname
        // className.staticProps
        // - non-static member need an object of class to be callable
        System.out.println("\nobject.field: " + object.getField());
        System.out.println("object2.fiekd: " + object2.fields);

        System.out.println("\n--------------------");
        System.out.println("#vduczz");
    }
}
