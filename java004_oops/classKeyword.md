## static

> _`static` member thuộc về class._

Bình thường, các properties, methods thuộc về riêng object. Khi 1 member được khai báo với từ khóa `static`, nó sẽ thuộc về class và trở thành phần chung của tất cả object.

> _Nó được khởi tạo đúng 1 lần duy nhất khi chương trình chạy và nằm ở một vùng nhớ riêng. Tất cả các instance sẽ có 1 thuộc tính cùng trỏ tới đó.  
> Đồng thời, có thể truy cập trực tiếp thông qua tên class  
> ex: `Math.pow()`, `Math.random()`, ...._

- static variable: biến/hằng số chung.
- static method: hàm tiện tích (`Utility`), ...
  - note: static method chỉ truy cập được các biến bên trong nó + các biến static khác bên ngoài, đồng thời cũng không có `this` hay `super` trong context.
- static block: chạy trước cả hàm main, dùng để khởi tạo các biến static phức tạp.

## final

> _`final` giống constant trong các ngôn ngữ khác nhưng có thể áp dụng cho cả method, class_

- final variable: hằng số => gán 1 lần, sau đó không thể gán lại. Với những object, đơn giản là không thể gán object mới, nhưng vẫn có thể sửa bên trong nó.
- final method: => cấm sub-class override
- final class: => không cho phép override

## abstract

> _`abstract` keyword mang đến tính Abstraction (của 4 thuộc tính quan trọng của OOP, bao gồm: Trừu tượng (Abstraction), Đóng gói (Encapsulation), Đa hình (Polymorphism), Kế thừa (Inheritance)).  
> Abstract là vỏ bọc._

- abstract method: Hàm không có thân, các sub-class phải định nghĩa cách triển khai cho method đó.
- abstract class: Class có ít nhất 01 abstract method phải được khai báo kèm thèo `abstract` keyword khi khai báo hàm.
  - note: không thể tạo đối tượng mới cho abstract class.

## synchronized

> `synchronized` được sử dụng cho lập trình bất đồng bộ.
>
> `synchronized method` chỉ cho phép 1 Thread được phép gọi hàm tại 1 thời điểm.

## transient

> `transient` để đánh dấu biến nào quan trọng muốn ẩn đi khi lưu/truyền object. Việc khai báo property với từ khóa `transient` giúp bỏ qua biến đó khi lưu/truyền.

## volatile, native
