import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int k = in.nextInt();
        int[] arr = new int[8];
        int i = 0;
        while (in.hasNextInt())
            arr[i++] = in.nextInt();

        Solution s = new Solution();
        System.out.println(s.smallestK(arr, k));
    }
}
