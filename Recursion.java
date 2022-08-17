public class Recursion {
    /*
     * master公式  T(N) = aT(N/b) + O(N^d)
     * 可以使用master公式计算时间复杂度的前提是：子过程缩小的规模都是N/b递归下去的子问题都是等规模的
     * log以b为底a > d -> O(N的 log以b为底a 次方)
     * log以b为底a < d -> O(N的 d 次方)
     * log以b为底a = d -> O(N的d次方 * logN)
     */
    
    // 用递归方法找一个数组中的最大值
    public static void getMax(int[] arr) {
        if(arr == null || arr.length == 0) return;
        int res = process(arr, 0, arr.length - 1);
        System.out.println(res);
    }
 
    // arr[l..r]范围上求最大值
    public static int process(int[] arr, int l, int r) {
        if(l == r) return arr[l];
        int mid = l + ((r - l) >> 1);
        int leftMax = process(arr, l, mid);
        int rightMax = process(arr, mid + 1, r);
        return Math.max(leftMax, rightMax);
    }

    /*
     * 上面的例子，用可以用master公式计算时间复杂度
     * 子过程被调用了a次，等规模的子问题是原问题的1/2 (1/b) ，除了调用子过程，剩下的时间复杂度为O(N^d)
     * 因此，a = 2, b = 2, d = 0
     * 因此有结论得出，时间复杂度为 O(N)
     */
}
