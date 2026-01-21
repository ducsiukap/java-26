package java006_exceptions;

// Exception - runtime errors -> crash the programm
// Exception handling -> handle runtime error 
//      => allowing the normal flow of programm to be continued

// Throwable is the base interface of Error and Exception class => root of all errors.
//                  /-> Error
// Object -> Throwable
//                  \-> Exception
// > Error: system error -> JVM/hardware error
//      -> can not handle with try-catch block,
//          just restart the program :)

// > Exception : software error -> the error that made by dev or user interaction
//      -> HAVE TO handle!
// - There are 2 types of Exception based on when it will be detected:
//      + Runtime-error (Unchecked)   -> only can be detected when the programm is executing
//                                    -> JVM no warning
//      + Compile-time error (Checked)  -> can be detected when the program be compiled
//                                      -> JVM warning, have to try-catch or throws

// - There are 2 types of Exception based on how it is defined.
//      + Built-in Exception: IOExcepton, NullPointerException, ArithmeticException, IndexOutOfBoundsException...
//      + User-defined exception

// defined an exception
// > extends Exception => create a checked exception
// > extends RuntimeException => create an unchecked exception
class DivByZeroException extends Exception {
    // or extends subclass of Exception/RuntimeException
    // DivByZeroException extends ArithmeticException

    public DivByZeroException() {
        super();
    };

    public DivByZeroException(String msg) {
        super(msg);
    }

    // can override
    // methods to print the exception information
    // .toString()
    // .getMessage()
    // .printStackTrace()
    @Override
    public String getMessage() {
        return "[DivByZeroException] msg: %s".formatted(super.getMessage());
    }
}

// throw vs throws
// - `throw`: chủ động ném ra 1 exception tại vị trí đó
// - `throws`: chỉ dùng khi khai báo hàm
// _________=> đẩy exception cho cấp trên (nơi sẽ gọi hàm này) xử lý
// *note: khi định nghĩa hàm, trên khai báo cho phép throws Exception gì
// ______ thì thân hàm mới được throw Exception đó
interface Calculator {
    double calculate(double a, double b) throws DivByZeroException;
}

// Note: when A extends B and A overrides method doSmth() B
// ---------------
// > With `checked` exception, the method doSmth() in A can:
// - không throws những exceptions mà B.doSmth() đã throws ở B
// - throws các exceptions mà B.doSmth() đã throws
// - throws các exceptions con của các exceptions mà B.doSmth() đã throws
// ---------------
// > With `unchecked` exception, doSmth() trong A muốn làm gì cũng được!

public class exceptions {
    public static void main(String[] args) {
        System.out.println();
        Calculator div = (a, b) -> {
            if (b == 0)
                // ok vì khi khai báo calculate trong interface
                // đã throws DivByZeroException
                throw new DivByZeroException("Can not div by 0!");
            else
                return a / b;
        };

        // gọi hàm `throws` exception -> phải handle
        double a = Math.random() * Double.MAX_VALUE;
        double b = (Math.random() < 0.3) ? b = Math.random() * 5.0 : 0.0;
        System.out.printf("dividing %.4f for %.4f......", a, b);
        //
        // div.calculate(a, b); // error
        // because the calculate() method throws Checked exception -> have to handle!

        // Để handle exception, có 2 cách:
        // - throws tiếp ở tên hàm hiện tại -> đẩy lên bên trên
        // - sử dụng try-catch block để xử lý luôn
        try {
            System.out.println("result: " + div.calculate(a, b));
        } catch (DivByZeroException e) { // catch exactly exception
            System.out.println(e.getMessage());
        } catch (Exception e) { // multiple catch blocks
            // catch Exception e -> catch any checked exception
            // catch RuntimeException e -> catch any unchecked exception
            // catch Throwable t -> catch any exception / error
            // *note: anti-pattern => không nên dùng cách này,
            // đặc biệt là catch RuntimeException (một số trường hợp maybe ok)
            // và ĐẶC BIỆT KHÔNG NÊN DÙNG Throwable để catch

            // một số method in thông tin exception
            e.printStackTrace();
            // e.getCause();
            // e.getMessage();
            // e.toString();
        } finally {
            // khối finally luôn được chạy sau try-catch dù exception có xảy ra không
            // - try-catch có thể không có khối finally
            // - trước đây, finally thường dùng để dọn dẹp tài nguyên

            // note:
            // + final -> constant variable
            // + finally() -> try-catch block
            // + finalize() -> GC method

            System.out.println("\n<finally block> is always be executed, regardless of whether exceptions occur.");
        }

        System.out.println("\n--------------------");
        System.out.println("#vduczz");
    }
}
