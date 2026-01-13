package JAVA002_basics.string;

// StringBuilder: https://www.geeksforgeeks.org/java/stringbuilder-class-in-java-with-examples/

// StringBuffer: https://www.geeksforgeeks.org/java/stringbuffer-class-in-java/

public class mutableString {
    public static void main(String[] args) {
        // String:
        // - immutable -> thread-safe (vì méo ai sửa được :))
        // - performance: low
        // - lưu trong StringPool
        // => do mọi thao tác chỉnh sửa (sửa/xóa/nối/cắt chuỗi) đều tạo chuỗi mới
        // => chuỗi cũ thành rác
        // => CHẬM do cần tạo object mới + GC dọn rác object cũ

        // StringBuffer:
        // giải quyết vấn đề chỉnh sửa string của String
        // => cho phép thao tác/nối thêm vùng nhớ trên vùng nhớ của nó
        // - mọi method được synchronized => thread-safe
        // - dù nhanh hơn String nhưng vẫn chậm do mỗi lần sử dụng cần check lock
        // - lưu trong heap

        // StringBuilder = StringBuffer loại bỏ synchronized
        // - nhanh
        // - không thread-safe (nhiều thread cùng sửa 1 lúc được)
        // - lưu trong heap

        // Note: StringBuilder và StringBuffer giống nhau 99% (chung các method),
        // chỉ khác synchronized

        // Usage:
        // + String: dùng cho các giá trị ít thay đổi: thông báo lỗi, key map, ..
        // + StringBuilder: 99% trường hợp cần thao tác chỉnh sửa với string
        // + StringBuilder: môi trường đa luồng, và có dùng chung/chia sẻ một biến chuỗi
        // Thực tế, ít dùng StringBuilder.

        // 1. create StringBuilder
        // using constructor
        // - new StringBuilder()
        // - new StringBuilder(int capacity)
        // - new StringBuilder(String str)
        // - new StringBuilder(CharSequence cs)
        StringBuilder sb = new StringBuilder("vduczz");
        System.out.println(sb);

        // commond method
        // StringBuilder sb.append()
        System.out.println();
        System.out.println(sb.append(13));
        System.out.println(sb.append("99"));
        System.out.println(sb.append('A'));

        // .insert(int offset, String str)
        // .replace(startIdx, endIdx, str)
        // .delete(start, end) / deleteCharAt()
        // .reverse()
        // .charAt(index)
        // .setCharAt(index, char)
        // .substring(int start, int end)
        // .indexOf(str), .lastIndexOf(str)
        // .toString()

        // CAPACITY VS LENGTH
        System.out.println("\n============================\n");
        // .capacity() // lấy capacity tối đa của builder/buffer hiện tại
        // .length() // lấy số ký tự đang chứ trọng builder hiện tại
        //
        // Dù String và StringBuilder/StringBuffer đều bọc bên trong 1 mảng byte[]
        // và các thuộc tính khác
        //
        // String là bất biến (final)
        // => khi khởi tạo, nó yêu cầu cấp đúng số ô nhớ cần thiết
        // => khi có thay đổi, phải xin cấp ô khác vừa vặn với nội dung mới
        // => 1 lần chỉnh sửa = 1 lần tạo object mới.
        String s1 = "abc", s2 = s1; // s1, s2 cùng trỏ tới "abc" trong StringPool
        System.out.println(s1 == s2); // true
        s1 += "100"; // create new object, refer to "abc100" in StringPool
        System.out.println(s1 == s2); // false
        // thread-safe do s1 dù ban đầu trỏ tới cùng 1 object so với s2
        // nhưng khi thay đổi tạo object mới nên không ảnh hưởng s2
        System.out.println("s1: %s".formatted(s1));
        System.out.println("s2: %s".formatted(s2));

        // Builder/Buffer xử lý bằng cách: cung cấp đệm
        // bên ngoài việc bọc bên trong 1 mảng byte[],
        // Builder/Buffer cố định kích thước mảng byte[]
        // kích thước mảng byte[] chính là capacity
        // số ký tự thực tế đang được lưu trong mảng byte đó là length
        // nếu sô ký tự > capacity => cấp mảng byte[] mới
        // có kích thước (2 * cap_old + 2)
        // và CHỈ THAY ĐỔI THUỘC TÍNH CHỨA MẢNG BYTE ĐÓ trỏ tới mảng mới
        // => giảm được nhiều lần phải tạo mảng mới + dọn dẹp mảng cũ
        // không ảnh hưởng đối tượng bọc bên ngoài, vẫn trỏ tới cùng địa chỉ cũ
        System.out.println();
        StringBuilder sb1 = new StringBuilder("abc"), sb2 = sb1; // capacity = 16 + initialize_string.length()
        System.out.println(sb1 == sb2); // true
        System.out.println("current capacity: %d, current lenth: %d".formatted(sb1.capacity(), sb1.length()));
        // length > capacity
        String x = "111222333444555666777"; // length=21
        sb1.append(x);
        System.out.println("current capacity: %d, current lenth: %d".formatted(sb1.capacity(), sb1.length()));
        // length <= capacity
        x = "1234";
        sb1.append(x);
        System.out.println("current capacity: %d, current lenth: %d".formatted(sb1.capacity(), sb1.length()));
        sb1.append(x);
        sb1.append(x);
        sb1.append(x);
        System.out.println("current capacity: %d, current lenth: %d".formatted(sb1.capacity(), sb1.length()));
        // có thể thấy, thay vì phải tạo mới 6 mảng byte[] và 6 đối tượng String
        // ta chỉ tạo mới 2 mảng byte[]: 1 cho tạo Builder ban đầu
        // và 1 khi length > capicity
        // và không tạo mới đối tượng Builder
        System.out.println(sb1 == sb2);
        // nhưng có thể thấy Builder không đạt được thread-safe
        // do sb1 thay đổi ảnh hưởng tới sb2
        System.out.println("sb1: %s".formatted(sb1.toString()));
        System.out.println("sb2: %s".formatted(sb2.toString()));

        System.out.println("\n--------------------");
        System.out.println("#vduczz");
    }
}
