/*
* The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)
*
*       P   A   H   N
*       A P L S I I G
*       Y   I   R
*
* And then read line by line: "PAHNAPLSIIGYIR"
*
* Write the code that will take a string and make this conversion given a number of rows:
*       string convert(string s, int numRows);
* */

public class Solution {
    public String convert(String s, int numRows) {
        if (numRows == 1)
            return s;

        int factor = 2 * numRows - 2;

        StringBuilder sb = new StringBuilder();

        for (int i=0; i<s.length(); i += factor)
            sb.append(s.charAt(i));

        for (int i=1; i<factor/2; i++)
            for (int j=i; j<s.length(); j++)
                if (j % factor == i || j % factor == factor - i)
                    sb.append(s.charAt(j));

        for (int i = factor / 2; i<s.length(); i += factor)
            sb.append(s.charAt(i));

        return sb.toString();
    }
}
