package java007_collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

// Collection: interface cha của List, Set, Queue, ...

// Collections: utility class 
//      chứa các hàm tiện ích (static method) cho các class implement của Collection

public class CollectionsClass {
    public static void main(String[] args) {
        System.out.println();

        List<Integer> collection = new ArrayList<>();
        for (int i = 0; i < 10; ++i)
            collection.add((int) (Math.random() * 100 + 1));
        System.out.println("collection: " + collection);

        // Collections class methods:

        // ---------------
        // > addAll(collection, T... elemes)
        System.out.println("\nCollections.addAll(...):");
        //
        Collections.addAll(collection,
                (int) (Math.random() * 100 + 1),
                (int) (Math.random() * 100 + 1),
                (int) (Math.random() * 100 + 1),
                (int) (Math.random() * 100 + 1));
        System.out.println("collection: " + collection);
        //
        Integer[] c2 = {
                (int) (Math.random() * 100 + 1), (int) (Math.random() * 100 + 1)
        };
        System.out.println("c2: " + Arrays.toString(c2));
        Collections.addAll(collection, c2);
        System.out.println(".addAll(collection, c2): " + collection);

        // ---------------
        // .asLifoQueue(Dequeue<T> dq)

        // ---------------
        // .binarySearch(list, key)
        // .binarySearch(list, key, comparator)

        // ---------------
        // .checkedCollection(collection, type), .checkedList(list, type)
        // .checkedSmth(smth, type)

        // ---------------
        // .copy(dst, src)
        // note: chỉ là copy phần tử sang
        // -> dst, src không liên quan
        // -> các phần tử vẫn là reference với nhau
        // dst must have the same size with src

        // ---------------
        // .disjoint(c1, c2)
        // true if c1 and c2 has no common elems

        // ---------------
        // emptyList(), empty...()
        // note: immutable

        // ---------------
        // .fill(list, object)
        List<Integer> list = new ArrayList<>(collection);
        System.out.println("\nCollection.fill(): ");
        System.out.println("list: " + list);
        Collections.fill(list, -1);
        System.out.println(".fill(list, -1): " + list);

        // ---------------
        // .frequency(collection, object)
        System.out.println("\nCollections.frequency():");
        System.out.println(".frequency(collection, 13): " + Collections.frequency(collection, 13));

        // ---------------
        // .indexOfSubList(srcList, targetList)
        // .lastIndexOfSubList(srcList, targetList)

        // ---------------
        // .list(Enumeration<T> e)

        // ---------------
        // .max(collection), .max(collection, comparator)
        // .min(collection), .min(collection, comparator)
        System.out.println("\nCollection.max() , Collection.min(): ");
        System.out.println("max elem in collection: " + Collections.max(collection));
        System.out.println("min elem in collection: " + Collections.min(collection));

        // ---------------
        // .replaceAll(list, oldVal, newVal)

        // ---------------
        // .newSetFromMap(map)

        // ---------------
        // .reverse(list)
        // .reverseOrder(), .reverseOrder(cmp)

        // ---------------
        // .rotate(list, distance)

        // ---------------
        // .shuffle(list)
        // .shuffle(list, Random rnd)
        System.out.println("\nCollections.shuffle(): ");
        Collections.shuffle(collection);
        System.out.println("suffle the collection: " + collection);

        // ---------------
        // .singleton(), singleton...()

        // ---------------
        // .sort(list)
        // .sort(list, comparator)
        System.out.println("\nCollections.sort(): ");
        Collections.sort(collection);
        System.out.println("sort the collection: " + collection);

        // ---------------
        // .swap(list, i, j)

        // ---------------
        // .synchronizedCollection(collection)
        // .synchronized...(...)

        // ---------------
        // .unmodifiable...(...)

        System.out.println("\n--------------------");
        System.out.println("#vduczz");
    }

}
