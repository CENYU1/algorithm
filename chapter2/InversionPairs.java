package chapter2;

public class InversionPairs {
    /*
     * 逆序对的数量
     * 在一个数组中，左边的数如果比右边的数大，则折两个数构成一个逆序对，请打印逆序对的数量。
     */
    public static long inversionPairs(int[] arr) {
        if(arr == null || arr.length < 2) return 0;
        return process(arr, 0, arr.length - 1);
    }

    public static long process(int[] arr, int l, int r) {
        if(l == r) return 0;
        int mid = l + ((r - l) >> 1);
        return process(arr, l, mid) + process(arr, mid + 1, r) + merge(arr, l, mid, r);
    }

    public static long merge(int[] arr, int l, int mid, int r) {
        int p1 = l, p2 = mid + 1, i = 0;
        long res = 0;
        int[] help = new int[r - l + 1];
        while(p1 <= mid && p2 <= r) {
            res += arr[p1] > arr[p2] ? (mid - p1 + 1) : 0;
            // ！！重要！！ 相等先放谁 
            help[i++] = arr[p1] <= arr[p2] ? arr[p1++] : arr[p2++]; 
        }
        while(p1 <= mid) help[i++] = arr[p1++];
        while(p2 <= r) help[i++] = arr[p2++];
        for(i = 0; i < help.length; i++) 
            arr[l + i] = help[i];
        return res;
    }
}
