package com.acabra.gtechdevalgs.hkrank.amzn_apr2021;

import java.util.List;

public class Problem2_SchedulingJobs {

    /**
     * Given a list of N CPUs 1 ..i .. N where Ci = amount of worload
     * calculate the minimum maximal difference among all CPU loads given that
     * k additional load is distributed optimally among all CPUs.
     * @param cpus list of cpu and the loads.
     * @param k an additional load to allocate
     * @return minimum maximal difference beetween jobs after optimally distributing
     *         k additional load among them
     */
    public static int getMinimumDifference(List<Integer> cpus, long k) {
        if(cpus.isEmpty()|| cpus.size() == 1) return (int)k;
        //TODO
        return 1;
    }
}
