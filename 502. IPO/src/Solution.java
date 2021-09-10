/*
* Suppose LeetCode will start its IPO soon. In order to sell a good price of its shares to Venture Capital, LeetCode would like to work on some projects to increase its capital before the IPO. Since it has limited resources, it can only finish at most k distinct projects before the IPO. Help LeetCode design the best way to maximize its total capital after finishing at most k distinct projects.

* You are given n projects where the ith project has a pure profit profits[i] and a minimum capital of capital[i] is needed to start it.

* Initially, you have w capital. When you finish a project, you will obtain its pure profit and the profit will be added to your total capital.

* Pick a list of at most k distinct projects from given projects to maximize your final capital, and return the final maximized capital.

* The answer is guaranteed to fit in a 32-bit signed integer.
* */

import java.util.Arrays;

class Solution {
    class Pack {
        public int profit;
        public int capital;
        public boolean available;
    }

    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int len = profits.length;

        Pack[] p = new Pack[len];

        for (int i=0; i<len; i++) {
            p[i] = new Pack();
            p[i].capital = capital[i];
            p[i].profit = profits[i];
            p[i].available = true;
        }

        Arrays.sort(p, (Pack first, Pack last)->last.profit-first.profit);

        for (int i=0; i<k; i++) {
            for (int j=0; j<len; j++) {
                if (p[j].capital <= w && p[j].available == true) {
                    w += p[j].profit;
                    p[j].available = false;
                    break;
                }
            }
        }

        return w;
    }

    public static void main(String[] args) {
        int k = 2;
        int w = 0;
        int[] profits = {1, 2, 3};
        int[] capital = {0, 1, 1};
        Solution s = new Solution();
        System.out.println(s.findMaximizedCapital(k, w, profits, capital));
    }
}