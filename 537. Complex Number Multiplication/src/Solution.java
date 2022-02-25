/*
* A complex number can be represented as a string on the form "real+imaginaryi" where:
*   real is the real part and is an integer in the range [-100, 100].
*   imaginary is the imaginary part and is an integer in the range [-100, 100].
*   i2 == -1.
*
* Given two complex numbers num1 and num2 as strings, return a string of the complex number that represents their multiplications.
* */

class Solution {
    public String complexNumberMultiply(String num1, String num2) {
        int real1 = num1.indexOf('+');
        int real2 = num2.indexOf('+');

        int imaginary1 = Integer.parseInt(num1.substring(real1 + 1, num1.length() - 1));
        int imaginary2 = Integer.parseInt(num2.substring(real2 + 1, num2.length() - 1));

        real1 = Integer.parseInt(num1.substring(0, real1));
        real2 = Integer.parseInt(num2.substring(0, real2));

        StringBuilder sb = new StringBuilder();

        sb.append(real1 * real2 - imaginary1 * imaginary2);
        sb.append('+');
        sb.append(real1 * imaginary2 + real2 * imaginary1);
        sb.append('i');

        return sb.toString();
    }
}