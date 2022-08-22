package chapter2;

public class QuickSort {
    public static void quickSort(int[] arr) {
        if(arr == null || arr.length < 2) return;
        quickSort(arr, 0, arr.length - 1);
    }

    // arr[l..r]排序
    public static void quickSort(int[] arr, int l, int r) {
        if(l < r) {
            int idx = l + (int) (Math.random() * (r - l + 1));
            swap(arr, idx, r);
            int[] res = partition(arr, l, r, arr[r]);
            quickSort(arr, l, res[0] - 1);
            quickSort(arr, res[1] + 1, r);
        }
    }

    public static int[] partition(int[] arr, int l, int r, int p) {
        int i = l - 1, j = r + 1, idx = l;
        while(idx < j) {
            if(arr[idx] < p) swap(arr, ++i, idx++);
            else if(arr[idx] > p) swap(arr, --j, idx);
            else idx++;
        }
        return new int[]{i + 1, j - 1};
    }

    public static void swap(int[] arr, int i, int j) {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }
}
