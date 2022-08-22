package chapter2;

public class HeapSort {
    public static void heapSort(int[] arr) {
        if (arr == null || arr.length < 2) return;

        // 构建大根堆 O(NlogN)
        // for (int i = 0; i < arr.length; i++) { // O(N)
        //     heapInsert(arr, i); // O(logN)
        // }
        
        /*
         * 如果一次性得到全部的数组元素，我们有更快的方式构建大根堆，可以这样做：
         * 我们现在得到的元素，也可看作是一个完全二叉树，只不过不一定是大根堆的形式，
         * 我们可以从最后一个元素开始往前看，每一个元素都进行一次heapify保证
         * 每一个节点下的元素都构成了大根堆，最后就可以构成一个大根堆。
         * 经过数学的计算，可以计算出时间复杂度为 O(N)
         */
        for(int i = arr.length - 1; i >= 0; i--) {
            heapify(arr, i, arr.length);
        }
        
        int heapSize = arr.length;
        swap(arr, 0, --heapSize);
        while(heapSize > 0) { // O(N)
            heapify(arr, 0, heapSize); // O(logN)
            swap(arr, 0, --heapSize); // O(1)
        }
    }

    // 某个数在idx位置，能否往下沉
    // 不断和左右孩子比较，较大的孩子如果大于当前的父，父节点往下沉，较大孩子上去
    public static void heapify(int[] arr, int idx, int heapSize) {
        int left = idx * 2 + 1; // 当前节点左孩子的下标
        while(left < heapSize) { // 判断当前节点是否真的有左孩子
            // 两个孩子中，谁的值大，把下标给largest
            int largest = left + 1 < heapSize && arr[left + 1] > arr[left] ? left + 1 : left;
            largest = arr[idx] < arr[largest] ? largest : idx;
            if(largest == idx) break;
            swap(arr, largest, idx);
            idx = largest;
            left = idx * 2 + 1;
        }
    }

    // arr[0...idx-1]已经是大根堆了，某个数现在处于 idx 位置，往上继续移动
    public static void heapInsert(int[] arr, int idx) {
        while(arr[idx] > arr[(idx - 1) / 2]) {
            swap(arr, idx, (idx - 1) / 2);
            idx = (idx - 1) / 2;
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }
}
