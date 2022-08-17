public class ExclusiveOR {
    /*
     * 异或运算的本质就是无进位相加
     * 性质
     *   0 ^ N = N    N ^ N = 0
     *   异或运算满足交换律和结合率
     *   某一位上有奇数个1，结果一定是1；某一位上有偶数个1，结果一定是0
     */

    /*
     * 不用额外变量交换两个数
     * 注意：i和j是一个位置的话，会出错
     */
	public static void swap(int[] arr, int i, int j) {
		arr[i] = arr[i] ^ arr[j];
		arr[j] = arr[i] ^ arr[j];
		arr[i] = arr[i] ^ arr[j];
	}

    /*
     * 一个数组中有一种数出现了奇数次，其他数都出现了偶数次，怎么找到这一个数
     */
    public static int getOddTimesNumber(int[] arr) {
        int eor = 0;
        for(int num : arr) eor ^= num;
        return eor;
    }

    /*
     * 一个数组中有两种数出现了奇数次，其他数都出现了偶数次，怎么找到这两个数 
     */
    public static void getOddTimesNumber2(int[] arr) {
        int eor = 0;
        for(int num : arr) eor ^= num;
        /*
         * eor = a ^ b; 
         * a、b为两种数，因此 a != b
         * eor != 0;
         * eor必然有一个位置上是1
         */
        int theRightestOne = eor & (~eor + 1); // 提取出最右的1
        int anotherEor = 0; // eor'
        for(int num : arr) {
            /*
             * 条件成立，则证明遍历到的出现了偶数次的数在那一位上(theRightestOne)是0
             * 条件不成立，则证明遍历到的出现了偶数次的数在那一位上(theRightestOne)是1
             * 完美分割开a和b
             */
            if((num & theRightestOne) == 0) {
                anotherEor ^= num;
            }
        }
        /*
         * anotherEor = a 或者 b;
         * anotherEor ^ eor 即为两者中的另一个数
         */
        System.out.println(anotherEor + " " + (anotherEor ^ eor));
    }
}
