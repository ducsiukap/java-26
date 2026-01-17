package java004_oops.methods;

// sometime, ta không biết sẽ truyền bao nhiếu đối số vào hàm.
// ex: hàm add nên cho phép add 3 số, 5 số thay vì chỉ cố định add 2 số

// 2 ways:
// - Cách 1: nhận input là 1 mảng đối số, gói tất cả các arguments vào 1 mảng và truyền
// - Cách 2: sử dung vararg.

// Bản chất, `vararg` là 1 mảng, vì vậy có thể duyệt qua nó bên trong hàm.

// Quy tắc: 
// - trong danh sách tham số của hàm, chỉ tồi tại tối đa 1 đối số là vararg
// - đối số dạng vararg phải đứng cuối trong danh sách đối số của hàm

// vararg cho kiểu T => T... 

class Method4 {
    public static int add(int... args) {
        int total = 0;
        // args được coi như mảng => iterable
        for (int arg : args)
            total += arg;
        return total;
    }
}

public class varargs {
    public static void main(String[] args) {
        System.out.println();

        // truyền dạng liệt kê
        System.out.println(Method4.add(1, 2));
        System.out.println(Method4.add(1, 2, 3));
        System.out.println(Method4.add(1, 2, 3, 4));

        // truyền dạng mảng
        int[] numbers = { 1, 2, 3, 4, 5 };
        System.out.println(Method4.add(numbers));

        System.out.println("\n--------------------");
        System.out.println("#vduczz");
    }
}
