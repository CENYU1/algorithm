package chapter2;

public class NetherlandsFlag {
    /*
     * 荷兰国旗问题 分3块儿
     * 在arr[L..R]范围上，根据p分块，<p 在左边，==p 在中间，>p 在右边
     * 返回值含义：一定会返回一个长度为2的数组，等于区域 的左边界和右边界 
     * arr = [... 3 5 5 4 6 7 ...]
     * index      4 5 6 7 8 9
     * p = 5
     * arr = [... (34)5 5(67) ...]
     *                6 7
     * 返回一个长度为2的数组 [6，7]
     * 如果无等于区域，返回值，左边界>右边界
     * 
     * 思路：
     * 当前数 < 划分值：当前数与小于区下一个数交换；<区右括；当前数位置跳到下一个
     * 当前数 > 划分值：当前数与大于区前一个数交换；>区左括；当前数位置不动
     * 当前数 == 划分值：当前数位置跳到下一个
     */
    public static int[] partition(int[] arr, int l, int r, int p) {
        int i = l - 1; // <区的右边界
        int j = r + 1; // >区的左边界
        int idx = l; // 当前数的下标
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
