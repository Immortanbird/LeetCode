/*
* Given an integer numRows, return the first numRows of Pascal's triangle.
* In Pascal's triangle, each number is the sum of the two numbers directly above it.
* */

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();

        for (int i=0; i<numRows; i++) {
            List<Integer> temp = new ArrayList<>();
            for (int j=0; j<=i; j++) {
                if (j==0 || j==i)
                    temp.add(1);
                else
                    temp.add(res.get(i-1).get(j-1) + res.get(i-1).get(j));
            }
            res.add(temp);
        }

        return res;
    }
}