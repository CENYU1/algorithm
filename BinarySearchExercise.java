public class BinarySearchExercise {
    // 在一个有序数组中，找 >= 某个数最左侧的位置
    public static int findLeft(int[] arr, int target) {
        int l = 0, r = arr.length - 1;
        int idx = -1; // 记录最左侧的位置
        while(l <= r) {
            int mid = l + ((r - l) >> 1);
            if(target > arr[mid]) {
                l = mid + 1;
            } else if(target <= arr[mid]) {
                idx = mid;
                r = mid - 1;
            }
        }
        return idx;
    }

    // 在一个有序数组中，找 <= 某个数最右侧的位置
    public static int findRight(int[] arr, int target) {
        int l = 0, r = arr.length - 1;
        int idx = -1;
        while(l <= r) {
            int mid = l + ((r - l) >> 1);
            if(target >= arr[mid]) {
                idx = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return idx;
    }

    /*
     * 局部最小值问题
     * 定义局部最小的概念。
     *  arr长度为1时，arr[0]是局部最小。
     *  arr的长度为N(N>1)时，如果arr[0] < arr[1]，那么arr[0]是局部最小；
     *  如果arr[N-1]<arr[N-2],那么arr[N-1]是局部最小；
     *  如果0<i<N-1，既有arr[i] < arr[i-1]，又有arr[i] < arr[i + 1]，那么arr[i]是局部最小。
     *  给定无序数组arr,已知arr中任意两个相邻的数都不相等，只需要返回arr中任意一个局部最小出现的位置即可，如果不存在这个位置就输出-1。
     * 
     * 学习到：无序也可以二分
     */
    public static int partMin(int[] arr) {
        if(arr == null || arr.length == 0) return -1;
        if(arr.length == 1) return 0;
        if(arr.length > 1 && arr[0] < arr[1]) return 0;
        if(arr.length > 1 && arr[arr.length - 1] < arr[arr.length - 2]) return arr.length - 1;
        int l = 0, r = arr.length - 1;
        while(l <= r) {
            int mid = l + ((r - l) >> 1);
            if(arr[mid] > arr[mid - 1]) r = mid - 1;
            else if(arr[mid] > arr[mid + 1]) l = mid + 1;
            else if(arr[mid] < arr[mid - 1] && arr[mid] < arr[mid + 1]) return mid;
        }
        return -1;
    }
}
