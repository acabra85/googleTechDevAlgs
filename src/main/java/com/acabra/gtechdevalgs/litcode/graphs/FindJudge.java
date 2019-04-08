package com.acabra.gtechdevalgs.litcode.graphs;

public class FindJudge {

    private int[][] graph;

    private boolean trusts(int a, int b){
        return graph[a][b] == 1;
    }

    private void buildTrust(int n, int[][] trust){
        this.graph = new int[n+1][n+1];
        for(int[] iTrust: trust) {
            this.graph[iTrust[0]][iTrust[1]] = 1;
        }
    }

    /**
     * 1. The judge trusts no one
     * 2. Everyone trusts the judge
     * 3. There is exactly one person satisfying properties 1 and 2.
     * @param N
     * @param trust
     * @return
     */
    public int findJudge(int N, int[][] trust) {
        buildTrust(N, trust);
        int peopleCount = N;
        if (null == trust || peopleCount<1) return 1;
        if (peopleCount<2) return 1; //if there is just 1 person it must be a judge since no-one trusts him/her
        int judge = 1; //take the first person

        for (int i = 2; i <= peopleCount; i++) {//find a person that trusts no-one
            if (trusts(judge, i)) {
                judge = i;
            }
        }

        //everyone trusts the judge
        for (int i = 1; i <= peopleCount; i++) {
            if (judge!=i && (!trusts(i, judge) || trusts(judge, i))) {
                return -1;
            }
        }
        return judge;
    }
}
