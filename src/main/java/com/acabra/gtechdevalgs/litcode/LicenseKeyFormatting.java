package com.acabra.gtechdevalgs.litcode;

public class LicenseKeyFormatting {

    /**
     * Reformat the given S license to comply with the following rules:
     *  1.  Reformat the given license containing groups of exactly k characters. [Except for the first group that
     *      can have length 0 < l <= K.]
     *  2.  A dash will separate the groups.
     *  3.  All lowercase characters in the result must be converted to uppercase.
     *  4.  Input and output strings contain the same alpha-numeric characters (the amount of input dashes is not relevant).
     * @param S license key as string containing only alphanumeric characters and dashes separated by N dashes into
     *          N+1 groups
     * @param K the target group size
     * @return the new formatted string according to the rules above.
     */
    public String formatLicense(String S, int K) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) != '-') {
                sb.append(Character.toUpperCase(S.charAt(i)));
            }
        }
        int mod = sb.length() / K;
        int div = sb.length() / K;

        String controlGroup = sb.toString();

        int iGroupCount = mod == 0 ? div : div + 1;
        StringBuilder res = new StringBuilder();
        for (int i = controlGroup.length() - 1, count = 0; i >= 0 ; i--) {
            res.append(controlGroup.charAt(i));
            count++;
            if (count>0 && count%K == 0 && i > 0) {
                res.append('-');
            }
        }
        return res.reverse().toString();
    }
}
