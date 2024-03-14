package dsa;

class Parent {

    void method() {
        System.out.println("hi from parent");
    }
}

class Child extends Parent {

    @Override
    void method() {
        System.out.println("hi from child class");
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

        System.out.println(binarySearch(new int[] { 23, 67, 78, 90, 100 }, 100));
        System.out.println(binarySearch(new int[] { 23, 67, 78, 90, 100 }, -1));

        /**
         * 
         * A- B C
         * B - D E
         * C - F G
         * 
         * A
         * B c
         * D E F G
         * Node root;
         * Node node = root;
         * Node temp = null;
         * while(node != null) {
         * temp = node;
         * node = node.left;
         * }
         * 
         * return temp.data;
         */
    }

}
