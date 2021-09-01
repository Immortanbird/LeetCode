/*
Given two version numbers, version1 and version2, compare them.

Version numbers consist of one or more revisions joined by a dot'.'. Each revision consists of digits and may contain leading zeros. Every revision contains at least one character. Revisions are 0-indexed from left to right, with the leftmost revision being revision 0, the next revision being revision 1, and so on. For example 2.5.33 and 0.1 are valid version numbers.

To compare version numbers, compare their revisions in left-to-right order. Revisions are compared using their integer value ignoring any leading zeros. This means that revisions 1 and 001 are considered equal. If a version number does not specify a revision at an index, then treat the revision as 0. For example, version 1.0 is less than version 1.1 because their revision 0s are the same, but their revision 1s are 0 and 1 respectively, and 0 < 1.

Return the following:
If version1 < version2, return -1.
If version1 > version2, return 1.
Otherwise, return 0.
*/


public class Solution {
    public Solution() {}

    public int compareVersion(String version1, String version2) {
        int index1 = version1.indexOf(".");
        int index2 = version2.indexOf(".");

        while(index1 != -1 && index2 != -1) {
            int temp1 = Integer.parseInt(version1.substring(0, index1));
            int temp2 = Integer.parseInt(version2.substring(0, index2));
            if(temp1 > temp2)
                return 1;
            if(temp1 < temp2)
                return -1;
            version1 = version1.substring(index1 + 1);
            version2 = version2.substring(index2 + 1);
            index1 = version1.indexOf(".");
            index2 = version2.indexOf(".");
        }

        if(index1 != -1) {
            int temp1 = Integer.parseInt(version1.substring(0, index1));
            int temp2 = Integer.parseInt(version2);
            if(temp1 > temp2)
                return 1;
            if(temp1 < temp2)
                return -1;

            version1 = version1.substring(index1 + 1);
            version1 = version1.replace(".", "");

            if (Integer.parseInt(version1) > 0)
                return 1;
            else
                return 0;
        }

        if(index2 != -1) {
            int temp1 = Integer.parseInt(version1);
            int temp2 = Integer.parseInt(version2.substring(0, index2));
            if(temp1 > temp2)
                return 1;
            if(temp1 < temp2)
                return -1;

            version2 = version2.substring(index2 + 1);
            version2 = version2.replace(".", "");

            if (Integer.parseInt(version2) > 0)
                return -1;
            else
                return 0;
        }

        return Integer.compare(Integer.parseInt(version1), Integer.parseInt(version2));
    }
}
