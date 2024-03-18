package dsa;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

class Parent implements Comparable<Parent> {
    void method() {
        System.out.println("hi from parent");
    }

    @Override
    public int compareTo(Parent x) {
        return 0;
    }
}


class Child extends Parent implements Comparator<Child> {
    @Override
    void method() {
        System.out.println("hi from child class");
    }

    @Override
    public int compare(Child x, Child y) {
        return 0;
    }

}


class SingleTon {

}


public class OInter {

    private static int binarySearch(int[] arr, int x) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == x)
                return mid;
            else if (arr[mid] > x) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {

        Parent p = new Parent();
        p.method();
        if (p instanceof Parent) {
            System.out.println("hi");
        } else if (p instanceof Child) {
            System.out.println("there");
        }
        p = new Child();
        if (p instanceof Parent) {
            System.out.println("hi");
        } else if (p instanceof Child) {
            System.out.println("there");
        }
        p.method();

        List<Integer> ll = new ArrayList<>();
        ll.add(45);
        ll.add(5);
        ll.add(3);
        ll.add(34);
        ll.add(67);
        ll.add(12);
        ll.add(43);
        ll = ll.stream().sorted().collect(Collectors.toList());

        System.out.println(ll);

        System.out.println(binarySearch(new int[] {23, 67, 78, 90, 100}, 100));
        System.out.println(binarySearch(new int[] {23, 67, 78, 90, 100}, -1));
        /**
         * 
         * A- B C B - D E C - F G
         * 
         * A B c D E F G Node root; Node node = root; Node temp = null; while(node != null) { temp =
         * node; node = node.left; }
         * 
         * return temp.data;
         */
    }

}
