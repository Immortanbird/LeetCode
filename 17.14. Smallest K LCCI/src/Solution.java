/*Design an algorithm to find the smallest K numbers in an array.*/

class Solution {
    public void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    public void QuickSort(int[] arr, int left, int right, int k) {
        int i = left + 1;
        int j = right;

        while(i < j--) {
            if(arr[j] < arr[left]) {
                while(i++ < j) {
                    if(arr[i] >= arr[left]) {
                        swap(arr, i, j);
                        break;
                    }
                }
            }
        }
        swap(arr, i, left);

        if(i < k)
            QuickSort(arr, i + 1, arr.length - 1, k - i);
        else if(i > k)
            QuickSort(arr, left, i, k);
    }

    public int[] smallestK(int[] arr, int k) {
        int[] res = new int[k];

        if(k == 0)
            return res;

        QuickSort(arr, 0, arr.length - 1, k);

        for(int i=0; i<k; i++)
            res[i] = arr[i];

        return res;
    }
}