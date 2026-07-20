import java.util.Arrays;

public class dsa {

    static void maxHeapify(int[] arr, int n, int ind) {
        int largest = ind;
        int left = 2 * ind + 1;
        int right = 2 * ind + 2;

        if (left < n && arr[left] > arr[largest])
            largest = left;

        if (right < n && arr[right] > arr[largest])
            largest = right;

        if (largest != ind) {
            int temp = arr[ind];
            arr[ind] = arr[largest];
            arr[largest] = temp;
            maxHeapify(arr, n, largest);
        }
    }

    static void buildMaxHeap(int[] arr) {
        int n = arr.length;

        for (int i = n / 2 - 1; i >= 0; i--) {
            maxHeapify(arr, n, i);
        }
    }

    static void minHeapify(int[] arr, int n, int ind) {
        int smallest = ind;
        int left = 2 * ind + 1;
        int right = 2 * ind + 2;

        if (left < n && arr[left] < arr[smallest])
            smallest = left;

        if (right < n && arr[right] < arr[smallest])
            smallest = right;

        if (smallest != ind) {
            int temp = arr[ind];
            arr[ind] = arr[smallest];
            arr[smallest] = temp;
            minHeapify(arr, n, smallest);
        }
    }

    static void buildMinHeap(int[] arr) {
        int n = arr.length;

        for (int i = n / 2 - 1; i >= 0; i--) {
            minHeapify(arr, n, i);
        }
    }

    public static void main(String[] args) {

        int[] arr1 = {5, 4, 7, 9, 8, 10, 3, 1, 2, 12, 20, 15, 19, 11, 13};
        int[] arr2 = arr1.clone();

        System.out.println("Original Array:");
        System.out.println(Arrays.toString(arr1));

        buildMaxHeap(arr1);
        System.out.println("Max Heap:");
        System.out.println(Arrays.toString(arr1));

        buildMinHeap(arr2);
        System.out.println("Min Heap:");
        System.out.println(Arrays.toString(arr2));
    }
}