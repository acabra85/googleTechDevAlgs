package com.acabra.gtechdevalgs.google;

import java.util.Map;
import java.util.TreeMap;

public class MatchMaker {

    private static final int SKILL_THRESHOLD = 100;
    private final TreeMap<Integer, Player> waitlist;
    private final GameServer gs;
    private final boolean naive;

    public MatchMaker(GameServer gs, boolean naive) {
        this.waitlist = new TreeMap<>();
        this.gs = gs;
        this.naive = naive;
    }
    public MatchMaker(GameServer gs) {
        this.waitlist = new TreeMap<>();
        this.gs = gs;
        this.naive = false;
    }

    public void attemptMatching(Player player) {
        if (this.waitlist.isEmpty()) {
            this.waitlist.put(player.rating(), player);
            return;
        }
        Player closest = this.findClosest(player.rating());
        if (this.skillWithinThreshold(player, closest)) {
            this.waitlist.remove(closest.rating());
            this.gs.startGame(player, closest);
            return;
        }
        this.waitlist.put(player.rating(), player);
    }

    private Player findClosest(int rating) {
        return naive ? findClosestNaive(rating) :  findClosestOptimal(rating);
    }

    // This implementation does not choose the closest between upper and lower
    private Player findClosestNaive(int rating) {
        Player closest = this.waitlist.get(rating);
        if (closest != null) {
            return closest;
        }
        Map.Entry<Integer, Player> lower = this.waitlist.lowerEntry(rating);
        if (lower != null) {
            return lower.getValue();
        }
        return this.waitlist.higherEntry(rating).getValue();
    }

    private Player findClosestOptimal(int rating) {
        Player closest = this.waitlist.get(rating);
        if (closest != null) {
            return closest;
        }
        int toLower = Integer.MAX_VALUE;
        int toHigher = Integer.MAX_VALUE;
        Map.Entry<Integer, Player> lower = this.waitlist.lowerEntry(rating);
        if (lower != null) {
            toLower = Math.min(toLower, Math.abs(lower.getValue().rating() - rating));
        }
        Map.Entry<Integer, Player> higher = this.waitlist.higherEntry(rating);
        if (higher != null) {
            toHigher = Math.min(toHigher, Math.abs(higher.getValue().rating() - rating));
        }
        return toHigher < toLower ? higher.getValue() : lower.getValue();
    }

    public int playersWaitingCount() {
        return waitlist.size();
    }

    private boolean skillWithinThreshold(Player p, Player c) {
        return Math.abs(p.rating()-c.rating()) <= SKILL_THRESHOLD;
    }

    static record Player(int rating){}
    public class GameServer {
        private int games = 0;

        public void startGame(Player p1, Player p2){
            ++games;
        }

        public int gameCount() {
            return games;
        }
    }
}
