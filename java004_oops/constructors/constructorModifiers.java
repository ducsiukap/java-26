// PUBLIC CONSTRUCTOR
// trong đa số trường hợp, người ta sử dụng `public` cho constructor
// class myClass1 {
//     public myClass1() {
//     }
// }

// ===================
// PRIVATE CONSTRUCTOR
// một số trường hợp nhỏ, `private` constructor được sử dụng
// giúp kiểm soát tuyệt đối việc khởi tạo object, không cho new từ bên ngoài
// Một số trường hợp sử dụng `private` constructor kinh điển:
// - Utility class => private constructor + static method 
class UtilityClass {
    // private constructor
    private UtilityClass() {
        // throw exception nếu ai đó vẫn cố tình new
        throw new IllegalStateException("Can not create Instance of Utility class!");
    }

    static public int add(int... numbers) {
        int sum = 0;
        for (int number : numbers)
            sum += number;
        return sum;
    }
}

// - Singleton Pattern => chỉ cho phép 1 instance duy nhất
// tồn tại trong toàn bộ app
class SingletonPattern {
    // có 1 static variable lưu instance duy nhất đó
    private static SingletonPattern instance;

    // private constructor
    private SingletonPattern() {
        System.out.println("an instance of SingletonPattern class was created!");
    }

    // method to get instance
    public static SingletonPattern getInstance() {
        if (instance == null) {
            // chỉ tạo instance bên trong class
            instance = new SingletonPattern();
        }
        return instance;
    }
}

// - Builder pattern: sử dụng khi class có quá nhiều thuộc tính
// => build inner class để set từng thuộc tính, sau đó gọi .build()
class BuilderPattern {
    // props
    private String deBanh, sot;
    private boolean addCheese;

    // thêm private constructor nhận 1 builder
    private BuilderPattern(Builder builder) {
        this.deBanh = builder.deBanh;
        this.sot = builder.sot;
        this.addCheese = builder.addCheese;
    }

    // builder class
    public static class Builder {
        private String deBanh;
        private String sot;
        private boolean addCheese;

        public Builder setDeBanh(String deBanh) {
            this.deBanh = deBanh;
            return this;
        }

        public Builder setSot(String sot) {
            this.sot = sot;
            return this;
        }

        public Builder setAddCheese(boolean addCheese) {
            this.addCheese = true;
            return this;
        }

        // gọi .build() để lấy đối tượng BuilderPattern bên ngoài
        public BuilderPattern build() {
            return new BuilderPattern(this);
        }
    }

    @Override
    public String toString() {
        return "{\n\t\"deBanh\":\"%s\",\n\t\"sot\":\"%s\",\n\t\"addCheese\":\"%b\"\n}".formatted(
                this.deBanh, this.sot, this.addCheese);
    }
}
// - factory method: ép người dùng sử dụng các hàm như
// .create(), .createFromXXX() ... để tạo instance

// ==========================
// PROTECTED CONSTRUCTOR
// - ít khi được sử dụng
// - có thể được sử dụng cho constructor của abstract class
// với ý nghĩa: "constructor chỉ dành cho sub-class thông qua super()"

// ==========================
// DEFAULT CONSTRUCTOR
// - rất hiếm khi được sử dụng
// - được dùng khi viết Library / Module
// => class mà chỉ các class cùng package tạo được,
// còn người dùng thư viện đó không được phép động vào constructor đó

public class constructorModifiers {
    public static void main(String[] args) {
        // tạo đối tượng sử dụng `public` constructor
        // đơn giản với new ClassName()

        // với private constructor
        // - utility class: không tạo object, chỉ dùng static method
        int a = (int) (Math.random() * 100 + 1);
        int b = (int) (Math.random() * 100 + 1);
        System.out.printf("%nsum(%d, %d) = %d%n", a, b, UtilityClass.add(a, b));
        int c = (int) (Math.random() * 100 + 1);
        System.out.printf("sum(%d, %d, %d) = %d%n", a, b, c, UtilityClass.add(a, b, c));
        // - builder pattern: tạo mới đối tượng builder, set các thuộc tính + gọi build
        // để tạo object
        BuilderPattern object = new BuilderPattern.Builder()
                .setDeBanh("De mong")
                .setSot("Ca chua")
                .setAddCheese(true)
                .build();
        System.out.println("\n" + object);
        // - static factory method: gọi hàm .create(), .createFrom(), .buildFrom(), ...
        // hoặc các hàm tương tự

        System.out.println("\n--------------------");
        System.out.println("#vduczz");
    }

}