public class MergeSort {
    /*
     * 归并排序 O(NlogN) 
     * 为什么比冒泡排序、插入排序、选择排序好，就是因为归并排序不浪费比较次数
     * master公式 T(N) = 2T(N/2) + O(N)
     * 对于merge()方法，每次都是从左到右遍历一次数组，因此是O(N)
     * a = 2, b = 2, c = 1
     * 因此时间复杂度为 O(NlogN)
     */
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
