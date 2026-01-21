package java007_collection;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Collections;

// ===============
// Comparator interface 
// > là công cụ quan trọng nhất để custom sort -> so sánh 2 phần tử cùng kiểu
// > java.util.Comparator<T>

// - là functional interface:
//   > abstract method: int compare(T o1, T o2) {}
//     - return: 
//          + negative (< 0) -> o1 < o2
//          + 0              -> o1 = o2
//          + positive (> 0) -> o1 > o2

// - class định nghĩa các Object không nên implements interface này
// mà nó nên đóng vai trò như 1 class độc lập để so sánh 2 phần tử
// - có nhiều cách định nghĩa 1 bộ compare:
//  + viết class so sáng implements Comparator<T>
// class StringCompareByLength implements Comparator<String> {
//     @Override
//     public int compare(String o1, String o2) {
//         return o1.length() - o2.length();
//     }
// }
// + annonymous clas
// + lambda
// _____ex: Comparator<Integer> increment = (a, b) -> a - b;Z

// ===============
// Comparable interface
// - khác với Comparator dùng để so sáng 2 object với nhau,
// Comparable sử dụng để so sánh object hiện tại với object khác cùng class.
// > abstract method: int compareTo(T o)
//      return: tương tự compare, < 0, 0, > 0 for this smaller, equal and larger than o
// *note: class muốn có khả năng so sánh tự nhiên (như Integer, ... ) phải implements Comparable
//            -> nếu không implements Comparable, 
//            sort collection instance of class dùng Collections.sort phải dùng thêm tham số Comparator comp

// *note: mặc định nhỏ hơn đứng trước -> compare trả về âm -> this đứng trước o

class Human implements Comparable<Human> {
    String firstName, lastName;
    int id;

    public Human(int id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    // @Override compareTo
    @Override
    public int compareTo(Human o) {
        if (this.id != o.id)
            return this.id - o.id;
        if (this.lastName.equals(o.lastName))
            return this.firstName.compareTo(o.firstName);
        return this.firstName.compareTo(o.firstName);
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "id: %d, fullname: %s%n".formatted(this.id, this.firstName + " " + this.lastName);
    }
}

public class objectCompare {
    public static void main(String[] args) {
        List<Human> list = new ArrayList<>();

        list.add(new Human((int) (Math.random() * 100 + 1), "Pham Van", "Duc"));
        list.add(new Human((int) (Math.random() * 100 + 1), "Tran Gia", "Hien"));
        list.add(new Human((int) (Math.random() * 100 + 1), "Tran Xuan", "Bac"));
        list.add(new Human((int) (Math.random() * 100 + 1), "Nguyen Duc", "Dat"));

        // Human implements comparable -> co the so sanh truc tiep!
        System.out.println(list.get(1).compareTo(list.get(2)));
        Collections.sort(list); // ok
        System.out.println("list after sort: " + list);
        System.out.println();

        // Co the tu dinh nghia comparator
        Comparator<Human> cmpById = (s1, s2) -> {
            return s1.id - s2.id;
        };
        System.out.println(cmpById.compare(list.get(1), list.get(2)));
        // Dù Human là comparable,
        // nhưng có thể định nghĩa cách sắp xếp khác
        // bằng cách truyền 1 instance của Comparator vào Collections.sort
        Collections.sort(list, cmpById.reversed()); // sort by id descending
        System.out.println("list after sort: " + list);

        // Chaining Comparator
        // chỉ comparator làm được
        // ex: sắp xếp theo tiêu chí A, nếu bằng nhau thì theo B, ... C
        // => sử dụng các static method của Comparator
        // _______+ bắt đầu phải bằng Comparator.comparing() cho mọi Type hoặc
        // ______________Comparator.comparingInt()/Long/Double (được tối ưu cho kiểu đó)
        // _______+ tiếp theo, cứ .thenCompare() cho các tiêu chí tiếp theo hoặc
        // ______________.reverse() để đảo ngược
        // *note: Human phải cung cấp các hàm get...

        // viết lại comparable của Human:
        Collections.sort(list,
                Comparator.comparingInt(Human::getId)
                        .thenComparing(Human::getLastName)
                        .thenComparing(Human::getFirstName));
        System.out.println("\nlist after sort: " + list);

        System.out.println("\n--------------------");
        System.out.println("#vduczz");
    }
}