package com.acabra.gtechdevalgs.litcode.dynamicprog;

public class RobHousesCircularStreet {

    /**
     * Given the money in each house located on a circular street
     * return the maximum amount of money that can be stolen by breaking into
     * the houses without triggering the neighbor alarm. (Neighbor alarm is triggered
     * when 2 consecutive houses are broken into).
     *
     * @param money array denoting money[i] the money available at house i
     * @return max amount of money
     */
    public int rob(int[] money) {
        if (null == money || money.length == 0) return 0;
        switch (money.length) {
            case 1:
                return money[0];
            case 2:
                return Math.max(money[0], money[1]);
            case 3:
                return Math.max(money[0], Math.max(money[1], money[2]));
            default:
                int solve = RobHouseLinearStreet.solve(money, 0, money.length - 1);
                return Math.max(solve, RobHouseLinearStreet.solve(money, 1, money.length));
        }
    }
}
