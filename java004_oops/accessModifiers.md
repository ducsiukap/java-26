# Java `Access modifier`

> Trong Java, access modifier quy định cách `class's members` có thể được gọi từ bên ngoài

## Class level modifiers

> Top-level class chỉ có thể là `public` hoặc `default`

## Class members modifers

### Modifiers:

> `default` là default modifer (no-keyword) cho class members

> Principle of Least Privilege (nguyên tắc quyền hạn tối thiểu): Luôn bắt đầu bằng `private`. Chỉ mở rộng ra (`protected`, `public`) khi thực sự cần thiết

| Access modifier |                                                           Scope                                                           |
| :-------------: | :-----------------------------------------------------------------------------------------------------------------------: |
|    `private`    | Chỉ truy cập được bên trong class đó. Kể cả các sub-class cũng KHÔNG có quyền truy cập vào private member của super-class |
|    `default`    |                            KHÔNG có keyword gì đi kèm, có thể truy cập bên trong cùng package                             |
|   `protected`   |                                     Trong cùng package + sub-class bên ngoài package                                      |
|    `public`     |                                                  Truy cập từ bất cứ đâu                                                   |

### Overriding:

> Quy tắc overriding: Khi class Con ghi đè hàm của class Cha, quyền truy cập chỉ được mở rộng ra, không được thu hẹp lại.

`private` < `default` < `protected` < `public`
