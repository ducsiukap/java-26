package java008_lambda_and_stream;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

// Lambda 
// - thực chất là implement functional interface
// - cho phép truyền đi / gán như data
// - @FunctionalInterface không bắt buộc nhưng khuyến khích sử dụng

// syntax:
//      (type paramList) -> { 
//          //body
//      }

// params:
// - có thể không có params
// - nếu nhiều param có cùng type, có thể viết (type1 a, b, type2 c) -> ...

// lambda có thể có return value
// > đơn giản: 
//      (type params) -> return-value
// > với body phức tạp:
//      (type params) -> {
//          //body
//          return return-value
//      }

// Nếu gán cho biến, kiểu của biến phải là 1 functional interface
interface Calculator {
    int calculate(int... a);
}

//
// ===============
// method references -> cách viết tắt của lambda nếu
// ______________________lambda đó chỉ làm việc là gọi duy nhất 1 hàm đã có
// có 4 kiểu method references:

// 1. refer to static method
// lambda: (args) -> ClassName.method(args)
// -> ClassName::method

// 2. refer to instance method
// lambda: (args) -> object.method(args)
// -> object::method
// chỉ object này gọi

// 3. refer to instance method of đối tượng tùy ý
// lambda: (obj, args) -> obj.method(args)
// -> ClassName::method // dù dùng tên class nhưng lại gọi hàm trên đối tượng
// object bất kì của class này gõi

// 4. refer to constructor
// lambda: (arg) -> new ClassName(args)
// -> ClassName::new

public class lambdaAndMethodReference {

    public static void main(String[] args) {
        System.out.println();

        // có thể bỏ <type> trong (type paramList) nếu đã biết trước
        Calculator sum = (a) -> {
            int total = 0;
            for (int x : a)
                total += x;
            return total;
        };

        System.out.println(sum.calculate(1, 2, 3, 4, 5));
        int arr[] = { 99, 1, 10 };
        System.out.println(sum.calculate(arr));

        //
        // ===============
        // method references
        // ex: ClassName::new
        Supplier<List<String>> listStringInitializer = ArrayList::new;
        // equals to: Supplier<List<String>> list = () -> new ArrayList();
        List<String> s1 = listStringInitializer.get();
        List<String> s2 = listStringInitializer.get();
        System.out.println(s1 == s2); // false,
        // dù cùng làm empty List<String>
        // nhưng là 2 instance khác vì mỗi lần gọi .get() là 1 lần new ...

        System.out.println("\n--------------------");
        System.out.println("#vduczz");
    }

}
