/*
* You are given n points in the plane that are all distinct, where points[i] = [xi, yi]. A boomerang is a tuple of points (i, j, k) such that the distance between i and j equals the distance between i and k (the order of the tuple matters).
* Return the number of boomerangs.
* */

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int numberOfBoomerangs(int[][] points) {
        int res = 0;

        for (int[] x : points) {
            Map<Integer, Integer> hashmap = new HashMap<>();

            for (int[] y : points) {
                int dist = (x[0] - y[0]) * (x[0] - y[0]) + (x[1] - y[1]) * (x[1] - y[1]);
                hashmap.put(dist, hashmap.getOrDefault(dist, 0) + 1);
            }

            for (Map.Entry<Integer, Integer> entry : hashmap.entrySet())
                res += entry.getValue() * (entry.getValue() - 1);
        }

        return res;
    }
}
