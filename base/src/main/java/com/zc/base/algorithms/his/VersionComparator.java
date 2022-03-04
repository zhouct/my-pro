package com.zc.base.algorithms.his;

public class VersionComparator {

    public static void main(String[] args) {
        String version1 = "1.01", version2 = "1.001";
        System.out.println(compareVersion(version1, version2));
    }

    /**
     * version1 = "1.01", version2 = "1.001"
     * version1 = "1.101", version2 = "1.1001"
     * version1 = "1.01.0", version2 = "1.001"
     * @param version1
     * @param version2
     * @return
     */
    public static int compareVersion(String version1, String version2) {

        int len1 = version1.length();
        int len2 = version2.length();

        int idx1 = 0;
        int idx2 = 0;

        while (idx1 < len1 || idx2 < len2){
            int s1 = 0;
            while(idx1 < len1 && version1.charAt(idx1) != '.'){
                s1 = s1 * 10 + (version1.charAt(idx1) - '0');
                idx1 ++;
            }
            int s2 = 0;
            while(idx2 < len2 && version2.charAt(idx2) != '.'){
                s2 = s2 * 10 + (version2.charAt(idx2) - '0');
                idx2 ++;
            }
            if(s1 < s2){
                return -1;
            }else if(s1 > s2){
                return 1;
            }else {
                idx1 ++;
                idx2 ++;
            }
        }
        return 0;
    }

}
