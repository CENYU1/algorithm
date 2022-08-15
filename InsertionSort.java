public class InsertionSort {
    public static void insertionSort(int[] arr) {
        if(arr == null || arr.length < 2) return;
        // 0~0 有序的
        // 0~i 想有序
        for(int i = 1; i < arr.length; i++) {
            for(int j = i - 1; j >= 0 && arr[j] > arr[j + 1]; j--) { // 下标为j+1的元素始终为需要处理的数
                swap(arr, j, j + 1);
            }
        }
    }

    public static void swap(int[] arr, int i, int j) {
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}
}
