/*
* You are given an integer n. We reorder the digits in any order (including the original order) such that the leading digit is not zero.
* Return true if and only if we can do this so that the resulting number is a power of two.
* */
/*不需要枚举全排列，只需要将每个数字出现的频率统计出来就行*/

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution {
    Set<String> hashset = new HashSet<>();

    private String countDigitFrequency(int n) {
        int[] freq = new int[10];

        while (n>0){
            freq[n%10]++;
            n /= 10;
        }

        return Arrays.toString(freq);
    }

    public boolean reorderedPowerOf2(int n) {
        for (int i=1; i<(int)1e9+1; i *= 2)
            hashset.add(countDigitFrequency(i));

        return hashset.contains(countDigitFrequency(n));
    }
}
