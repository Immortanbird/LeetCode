/*插入排序*/

public class InsertionSort {
    public static void sort(int[] nums) {
        for (int i=1; i<nums.length; i++) {
            int key = nums[i];
            int index = i-1;

            while (index >=0 && nums[index] > key) {
                nums[index + 1] = nums[index];
                index --;
            }

            nums[index + 1] = key;
        }
    }
}
