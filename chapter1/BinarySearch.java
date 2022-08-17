package chapter1;
public class BinarySearch {
    // 针对于闭区间 [l, r]
    public static int binarySearch(int[] arr, int target) {
        int l = 0, r = arr.length - 1;
        while(l <= r) {
            int mid = l + ((r - l) >> 1);
            if(arr[mid] > target) r = mid - 1;
            else if(arr[mid] < target) l = mid + 1;
            else return mid;
        }
        return -1;
    }

    // 针对于左闭右开区间 [l, r)
    public static int binarySearch2(int[] arr, int target) {
        int l = 0, r = arr.length;
        while(l < r) {
            int mid = l + ((r - l) >> 1);
            if(arr[mid] > target) r = mid;
            else if(arr[mid] < target) l = mid + 1;
            else return mid;
        }
        return -1;
    }
}
