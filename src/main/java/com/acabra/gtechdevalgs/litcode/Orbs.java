package com.acabra.gtechdevalgs.litcode;

import java.security.SecureRandom;
import java.util.HashSet;
import java.util.IntSummaryStatistics;
import java.util.Set;

public class Orbs {

    final static int RED = 0;
    final static int BLUE = 1;

    private final SecureRandom rand;

    public Orbs(SecureRandom rand) {
        this.rand = rand;
    }

    /*
        Simulate that given a bag full of red balls
        how many draws it will take (where a draw is to take
        one ball from the bag at random) to replace all red balls
        by blue balls, if the swap can only be done when a red
        ball is drawn?
     */
    public static void main(String[] args) {
        int exp = 1000000;
        IntSummaryStatistics ism = new IntSummaryStatistics();
        long millis = System.nanoTime();
        SecureRandom rand = new SecureRandom();
        for (int i = 0; i < exp; ++i) {
            ism.accept((new Orbs(rand)).getDraws());
        }
        System.out.printf("%s: elapsed[%.3fms]%n", ism, (System.nanoTime() - millis) / 1_000_000.0);
    }

    private int getDraws() {
        int[] balls = {RED, RED, RED, RED, RED, RED};
        Set<Integer> uq =  new HashSet<>();
        int draws = 1;
        drawBall(balls, uq); // put one blue at random
        while(uq.size() < balls.length) {
            drawBall(balls, uq);
            ++draws;
        }
        return draws;
    }

    private void drawBall(int[] balls, Set<Integer> uq) {
        int val = this.rand.nextInt(balls.length);
        uq.add(val);
        balls[val] = BLUE;
    }
}
