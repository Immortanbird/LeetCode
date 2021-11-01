import java.util.HashSet;
import java.util.Set;

public class Solution {
    public int distributeCandies(int[] candyType) {
        Set<Integer> kind = new HashSet<>();

        for (int x : candyType)
            kind.add(x);

        return Math.min(candyType.length/2, kind.size());
    }
}
