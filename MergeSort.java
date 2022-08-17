public class MergeSort {
    public static void mergeSort(int[] arr) {
        if(arr == null || arr.length < 2) return;
        process(arr, 0, arr.length - 1);
    }

    // arr[l..r]排序
    public static void process(int[] arr, int l, int r) {
        if(l == r) return;
        int mid = l + ((r - l) >> 1);
        process(arr, l, mid);
        process(arr, mid + 1, r);
        merge(arr, l, mid, r);
    }

    public static void merge(int[] arr, int l, int mid, int r) {
        int p1 = l, p2 = mid + 1, i = 0;
        int[] help = new int[r - l + 1];
        while(p1 <= mid && p2 <= r) {
            help[i++] = arr[p1] <= arr[p2] ? arr[p1++] : arr[p2++];
        }
        while(p1 <= mid) help[i++] = arr[p1++];
        while(p2 <= r) help[i++] = arr[p2++];
        for(i = 0; i < help.length; i++) {
            arr[l + i] = help[i];
        }
    }
}
