package java004_oops;

// Tính đóng gói - Encapsulation

// Về cơ bản, tính đóng gói ám chỉ việc đưa dữ liệu (variable) và hành động (method)
// vào chung 1 chỗ (class), sau đó giấu đi dữ liệu, chỉ đưa ra những thứ cần thiết.

// Nguyên tắc:
// - Giấu dữ liệu: đặt tất cả các biến là private.
// - Đưa ra những thứ cần thiết: cung cấp public getter/setter để truy cập 

class Human1 {
    // ẩn dữ liệu
    private String name;
    private int age;

    // constructor
    public Human1(String name, int age) {
        if (!isValidAge(age))
            throw new IllegalArgumentException("Invalid Age!");
        if (name == null || name.isEmpty())
            throw new IllegalArgumentException("Invalid name");

        this.name = normalizeName(name);
        this.age = age;
    }

    // public các method cần thiết

    // mục đích:
    // - kiểm soát dữ liệu (validation)
    public void setAge(int age) {
        if (!isValidAge(age))
            throw new IllegalArgumentException("Invalid Age!");
        this.age = age;
    }

    // - kiểm soát quyền
    // Read-only (public getter only) / Write-only (public setter only)
    public int getAge() {
        return this.age;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        if (name == null || name.isEmpty())
            throw new IllegalArgumentException("Invalid name");
    }

    // - implementation hiding
    // + ẩn biến:
    // ex: name được tách thành firstName + lastName
    // nhưng vẫn chỉ dùng getFullName/setFullName
    // + ẩn các hàm tiện ích, hàm nội bộ, helper function cho các hàm public
    private boolean isValidAge(int age) {
        return (age > 0 && age <= 150);
    }

    private String normalizationWord(String word) {
        StringBuilder sb = new StringBuilder(Character.toUpperCase(word.charAt(0)))
                .append(word.substring(1).toLowerCase());

        return sb.toString();
    }

    private String normalizeName(String name) {
        String[] nameTokens = name.split("\\s+");
        StringBuilder sb = new StringBuilder();

        for (String token : nameTokens)
            sb.append(" ").append(normalizationWord(token));

        sb.deleteCharAt(0);
        return sb.toString();
    }

    // - POJO / Java Bean
    // Encapsulation chuẩn: private fields + public get/set + no-args constructor
    // => class trở thành Java Bean (or POJO - Plain Old Java Object)
    // Đây là tiêu chuẩn để các Framework như Spring, Hibernate hoạt động,
    // tự động tìm các hàm get... và set... để làm việc
}

// Getter / Setter
// - tạo getter khi thực sự cần show biến ra ngoài
// - tạo setter khi thực sự cần cho phép sửa biến từ bên ngoài
// Note: Khi trả về của getter là object,
// nên trả về deep copy / unmodifiable object hoặc tườn đương
// để bảo vệ dự liệu gốc

public class encapsulation {
    public static void main(String[] args) {
        try {
            Human1 h1 = new Human1("vduczz", 22);

            h1.setAge(200); // Invalid age

        } catch (IllegalArgumentException e) {
            System.out.printf("%nException: %s%n", e.getMessage());
        }

        System.out.println("\n--------------------");
        System.out.println("#vduczz");
    }
}
