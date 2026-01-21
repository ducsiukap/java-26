package java006_exceptions;

public class chainedException {
    // có thể chỉ định nguyên nhân gây ra exception hiện tại
    // > sử dụng constructor:
    // - Throwable()
    // - Throwable(String msg)
    // - Throwable(String msg, Throwable initCause);

    // or
    // exception.initCause(Throwable cause)

    public static void main(String[] args) {
        try {
            throw new ArithmeticException("Based exception!");
        } catch (ArithmeticException e) {
            RuntimeException exception = new RuntimeException("Primary exception!");// e become initCause
            exception.initCause(e);

            // để lấy initCause của exception e -> e.getCause()

            throw exception;
            // or
            // throw new RuntimeException("Secondary exception!", e);// e become initCause

            //
            /*- result
            Exception in thread "main" java.lang.RuntimeException: Primary exception!
                    at java006_exceptions.chainedException.main(chainedException.java:17)
            Caused by: java.lang.ArithmeticException: Based exception!
                    at java006_exceptions.chainedException.main(chainedException.java:15)
                    at java.base/jdk.internal.reflect.DirectMethodHandleAccessor.invoke(DirectMethodHandleAccessor.java:104)
                    at java.base/java.lang.reflect.Method.invoke(Method.java:565)
                    at jdk.compiler/com.sun.tools.javac.launcher.SourceLauncher.execute(SourceLauncher.java:258)       
                    at jdk.compiler/com.sun.tools.javac.launcher.SourceLauncher.run(SourceLauncher.java:138)
                    at jdk.compiler/com.sun.tools.javac.launcher.SourceLauncher.main(SourceLauncher.java:76)
            */
        }
    }
}
