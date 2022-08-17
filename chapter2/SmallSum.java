package chapter2;

public class SmallSum {
    /*
     * 小和问题
     * 在一个数组中，每一个数左边比当前数小的数累加起来，叫做这个数组的小和。求一个数组的小和。
     * eg：[1，3，4，2，5]
     * 1左边比1小的数，没有；
     * 3左边比3小的数，1；
     * 4左边比4小的数，1、3；
     * 2左边比2小的数，1；
     * 5左边比5小的数，1、3、4、2；
     * 所以小和为 1+1+3+1+1+3+4+2=16
     */

    /*
     * 可以转变为：每一个数右边有几个数比当前数大
     * eg：[1，3，4，2，5]
     * 1右边比1大的数，3,4,2,5，即最后会产生4个1；
     * 3右边比3大的数，4,5，即最后会产生2个3；
     * 4右边比4大的数，5，即最后会产生1个4；
     * 2右边比2大的数，5，即最后会产生1个2；
     * 5右边比5大的数，没有；
     * 所以小和为 4*1+2*3+1*4+1*2=16
     * 
     * 我们可以在归并排序的基础上来解决，为什么？
     * 在merge之前，第一次的时候，我们会用递归，左边一直递归到只有一个数，右边一直递归到只有一个数，
     * 此时，需要做第一次merge操作，当左边的数严格小于右边的数时，
     * 则会产生一个小和（产生几个小和与此时右边部分有多少个数有关），当右边的数严格小于左边的数时，
     * 不产生小和，因为我们需要的是右边部分比当前数大的数字，处于右边的数无法判断它的右边有多少数比它大
     */
    public static int smallSum(int[] arr) {
        if (arr == null || arr.length < 2)
            return 0;
        return process(arr, 0, arr.length - 1);
    }

    // arr[l..r]既要排好序，也要返回这个范围上的小和
    public static int process(int[] arr, int l, int r) {
        if (l == r)
            return 0;
        int mid = l + ((r - l) >> 1);
        return process(arr, l, mid) + process(arr, mid + 1, r) + merge(arr, l, mid, r);
    }

    public static int merge(int[] arr, int l, int mid, int r) {
        int res = 0;
        int p1 = l, p2 = mid + 1, i = 0;
        int[] help = new int[r - l + 1];
        while (p1 <= mid && p2 <= r) {
            res += arr[p1] < arr[p2] ? (r - p2 + 1) * arr[p1] : 0;
            help[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
        }
        while (p1 <= mid)
            help[i++] = arr[p1++];
        while (p2 <= r)
            help[i++] = arr[p2++];
        for (i = 0; i < help.length; i++) {
            arr[l + i] = help[i];
        }
        return res;
    }
}
