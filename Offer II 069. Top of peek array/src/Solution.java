/*
* 符合下列属性的数组 arr 称为 山峰数组（山脉数组） ：
*   arr.length >= 3
*   存在 i（0 < i < arr.length - 1）使得：
*       arr[0] < arr[1] < ... arr[i-1] < arr[i]
*       arr[i] > arr[i+1] > ... > arr[arr.length - 1]
* 给定由整数组成的山峰数组 arr ，返回任何满足 arr[0] < arr[1] < ... arr[i - 1] < arr[i] > arr[i + 1] > ... > arr[arr.length - 1] 的下标i，即山峰顶部。
* */

public class Solution {
    public static void main(String[] args) {
        int[] nums = {3,4,5,1};
        System.out.println(Solution.peakIndexInMountainArray(nums));
    }

    public static int peakIndexInMountainArray(int[] arr) {
        int left = 1;
        int right = arr.length - 2;

        while (left < right) {
            int mid = (left + right) / 2;

            if (arr[mid - 1] < arr[mid] && arr[mid] > arr[mid + 1]) {
                left = mid;
                break;
            }
            else if (arr[mid] < arr[mid + 1])
                left = mid + 1;
            else
                right = mid - 1;
        }

        return left;
    }
}
