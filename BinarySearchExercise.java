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
}
