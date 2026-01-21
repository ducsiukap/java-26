
package java008_lambda_and_stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

// Bên cạnh Collections,
// Stream cũng cung cấp cấc utility method cho xử lý trên các collection
// - Collections cung cấp các static method, chủ yếu là thao tác đơn giản trên collection
// - Stream cung cấp các instance method, cho phép xử lý sâu từng phần tử của collection

// Stream gồm 3 giai đoạn:
// - source: điểm bắt đầu.
//      // stream thương bắt đầu từ Collection, Array, I/O channel, ...
// - intermediate operations: các hàm xử lý trung gian
//      + xử lý / biến đổi từng phần tử
//      + trả về Stream
// - terminal operations: các hàm kết thúc stream, đóng gói kết quả.

public class stream {
    public static void main(String[] args) {
        // ===============
        // 1. source -> khởi tạo stream
        System.out.println();
        // - từ collection -> collection.stream()
        List<Integer> list = new ArrayList<>();
        list.add((int) (Math.random() * 100));
        list.add((int) (Math.random() * 100));
        list.add((int) (Math.random() * 100));
        Stream<Integer> stream = list.stream(); // collection.stream()
        // - từ Arrays -> Arrays.stream(T[] array)
        Integer arr[] = { (int) (Math.random() * 100),
                (int) (Math.random() * 100),
                (int) (Math.random() * 100) };
        stream = Arrays.stream(arr); // Arrays.stream(T[] arrray)
        // - using Stream.of(T... values)
        stream = Stream.of((int) (Math.random() * 100),
                (int) (Math.random() * 100),
                (int) (Math.random() * 100));
        // - using Infinite stream
        // Stream.iterate(seed, n -> return-value)
        stream = Stream.iterate(1, _ -> (int) (Math.random() * 100)).limit(10); // .limit(n) để tránh infinite loops

        list = stream.toList();
        System.out.println("stream: " + list);

        // ===============
        // 2. intermediate operation
        System.out.println();
        Supplier<Stream<Integer>> streamProvider = list::stream;
        // ---------------
        // + filter(Pedicate<T>) -> bộ lọc
        List<Integer> evens = streamProvider.get().filter(item -> (item & 1) == 1).toList();
        System.out.println("even number in stream: " + evens);
        // ---------------
        // + map(Function(T, R)) -> biến đổi phẩn tử
        List<Integer> divBy2 = streamProvider.get().map(item -> item / 2).toList();
        System.out.println("div by 2 all item in stream: " + divBy2);
        // ---------------
        // + flatMap(Function<T, Stream<R>>)
        // dùng khi có list lồng list -> dải toàn bộ phần tử thành 1D
        // ---------------
        // + distinct() -> khử trung
        System.out.println("distinct item in stream: " + streamProvider.get().distinct().toList());
        // ---------------
        // + sorted(Comparator<T>)
        // ---------------
        // + peek(Consumer<T>) // tương tự forEach() nhưng không dừng stream
        // ---------------
        // + limit(n) / skip(n) -> chỉ lấy / bỏ qua n phần tử đầu
        // ---------------
        // *note: Vì mỗi method đều trả về stream, ta có thể nối các method thành chuỗi
        // ex: tìm tối đa 5 số nguyên tố, log ra sau đó bình phương lên
        Predicate<Integer> isPrime = (number) -> {
            for (int i = 2; i * i <= number; ++i) {
                if (number % i == 0)
                    return false;
            }

            return number > 1;
        };
        System.out.print("prime numbers: ");
        System.out.println("\nresult: " +
                streamProvider.get()
                        .filter(isPrime).limit(5)
                        .peek(num -> System.out.printf("%d ", num))
                        .map(number -> (long) number * number)
                        .toList());

        // ===============
        // 3. Terminate operations
        // -> terminate đóng stream sau khi gọi hàm -> không thể tái sử dụng stream
        System.out.println();
        // ---------------
        // .collect(collector) // hiện tại ít dùng,
        // _______________________nếu có thì dùng với Collectiors.groupingBy(classifier)
        // _______________________ -> return map<group, itemList>
        // .toList(), .toAray(), .toSet(), toMap(), ...
        // .joining() // for string
        streamProvider.get().collect(Collectors.groupingBy(number -> number & 1)).forEach((key, value) -> {
            System.out.println("group: " + key + ", itemList: " + value);
        });
        // or với object có thể: .collect(Collectors.groupingBy(object::getX))
        // để group by X

        // ---------------
        System.out.println();
        // .forEach(Consumer<T>)
        // ---------------
        // .reduce(T identity, BinaryOperator<T> accumulator)
        // ____________ + identity là giá trị khởi tạo
        // ____________ + accumulator: (T a, b) -> T
        int max = streamProvider.get().reduce(Integer.MIN_VALUE, Integer::max);
        int sum = streamProvider.get().reduce(0, (a, b) -> a + b);
        System.out.println("max of stream: " + max);
        System.out.println("total sum of stream: " + sum);
        // ---------------
        // .count() // length of stream
        // ---------------
        // .anyMatch(Pedicate<T>), .allMatch(Pedicate<T>), .noneMatch(Pedicate<T>)
        // ---------------
        // .findFirst() -> thằng đầu tiên trong stream
        // .findAny() -> thằng bất kỳ trong stream
        // _____// note: đều trả về Optional
        System.out.println("\nfirst item in stream: " + streamProvider.get().findFirst().orElse(-1));
        System.out.println("any item in stream: " + streamProvider.get().findAny().orElse(-1));
        // + findAny() thực chất là item nào tính xong trước thì lấy
        // -> chỉ có tác dụng với parallel stream
        System.out.println("any item in parallel stream: " + list.parallelStream().findAny().orElse(-1));

        System.out.println("\n--------------------");
        System.out.println("#vduczz");
    }
}

// *Note
// - Primitive stream // IntStream, LongStream, DoubleStream //
// ________+ có hiệu năng cao hơn
// ________+ có các hàm thống kê có sẵn: .sum(), .average(), .max(), .min()
// - Parallel streams // tận dụng đa luồng CPU
// ________+ stream thường: chạy từ đầu -> cuối
// ____________-> dễ đoán nhưng an toàn hơn (có thể chậm hơn)
// ________+ parallel stream:
// ____________-> chia nhỏ chạy song song (-> tận dụng CPU)
// ____________-> stream càng lớn càng nhanh hơn)
// => tạo parallel stream:
// ________+ list.parallelStream()
// ___ or
// ________+ list.stream().parallel()