/*Given two binary strings a and b, return their sum as a binary string.*/

class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.addBinary("1", "111"));
    }

    public String addBinary(String a, String b) {
        StringBuilder s = new StringBuilder();
        int right1 = a.length() - 1;
        int right2 = b.length() - 1;
        int forward = 0;

        while(right1 >= 0 && right2 >= 0) {
            int temp = a.charAt(right1) + b.charAt(right2) - 2*'0' + forward;
            forward = temp / 2;
            s.append(temp % 2);
            right1--;
            right2--;
        }

        while(right1 >= 0) {
            int temp = a.charAt(right1) - '0' + forward;
            forward = temp / 2;
            s.append(temp % 2);
            right1--;
        }

        while(right2 >= 0) {
            int temp = b.charAt(right2) - '0' + forward;
            forward = temp / 2;
            s.append(temp % 2);
            right2--;
        }

        if(forward > 0)
            s.append(forward);

        return s.reverse().toString();
    }
}