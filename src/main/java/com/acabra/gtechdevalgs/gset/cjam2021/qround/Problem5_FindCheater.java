package com.acabra.gtechdevalgs.gset.cjam2021.qround;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Random;
import java.util.StringTokenizer;

public class Problem5_FindCheater {

    static class Solution {
        private final static String RESULT = "%sCase #%d: %s";
        private static int TOTAL_PLAYERS = 100;
        private static int TOTAL_QUESTIONS = 10000;
        private static int TRIALS = 1000;
        private static int MAX_PLAYERS_ALLOWED_PER_EXPERIMENT = 3;

        private static final Comparator<? super PlayerResults> PLAYER_RESULTS_COMP = new Comparator<PlayerResults>() {
            @Override
            public int compare(PlayerResults o1, PlayerResults o2) {
                return Double.compare(o2.diffScore, o1.diffScore);
            }
        };

        private static final Comparator<Map.Entry<PlayerResults, Integer>> FREQUENCY_COMP = new Comparator<>() {
            @Override
            public int compare(Map.Entry<PlayerResults, Integer> o1, Map.Entry<PlayerResults, Integer> o2) {
                int compare = Double.compare(o2.getValue(), o1.getValue());
                PlayerResults key1 = o1.getKey();
                PlayerResults key2 = o2.getKey();
                if (compare == 0) {
                    compare = Double.compare(key2.score, key1.score);
                }
                if (compare == 0) {
                    compare = Double.compare(key2.redFlagsWrong + key2.redFlagsCorrect,
                            key1.redFlagsWrong + key1.redFlagsCorrect);
                }
                return compare;
            }
        };

        private static int findCheater(double P, Help help) throws IOException {
            if(P > 0){
                List<RawResult> results = buildResults(help);
                Map<PlayerResults, Integer> freqSet = new HashMap<>();
                for (int i = 0; i < TRIALS; i++) {
                    PriorityQueue<PlayerResults> playerResults = runExperiment(results);
                    for (int added = 0; !playerResults.isEmpty() && added < MAX_PLAYERS_ALLOWED_PER_EXPERIMENT; ++added) {
                        PlayerResults player = playerResults.remove();
                        freqSet.merge(player, 1, Integer::sum);
                    }
                }
                PriorityQueue<Map.Entry<PlayerResults, Integer>> likelyCheaters = new PriorityQueue<>(FREQUENCY_COMP);
                freqSet.entrySet().forEach(likelyCheaters::offer);
                return likelyCheaters.peek().getKey().pos;
            } return new Random().nextInt(99) + 1;
        }

        private final Help help;

        static class PlayerResults {
            final int pos;
            final int correct;
            final int wrong;
            private final double score;
            private final double skill;
            private final double expectedScore;
            private final double diffScore;
            private final int redFlagsCorrect;
            private final double redFlagsPerc;
            private final int redFlagsWrong;

            private PlayerResults(int pos, int correct, int wrong, double score, int redFlagsCorrect, int redFlagsWrong, double skill) {
                this.pos = pos + 1;
                this.correct = correct;
                this.wrong = wrong;
                this.skill = skill;
                this.redFlagsCorrect = redFlagsCorrect;
                this.redFlagsWrong = redFlagsWrong;
                this.expectedScore = (correct - redFlagsCorrect) * 100.0 / TOTAL_QUESTIONS;
                this.score = score;
                this.diffScore = Math.abs(this.expectedScore - this.score);
                this.redFlagsPerc = (redFlagsCorrect * 1.0 / TOTAL_QUESTIONS);
            }

            static PlayerResults fromReader(RawResult rawResult, double skill, double[] difficulty) {
                int redFlagCorrect = 0;
                int redFlagWrong = 0;
                for (int i = 0; i < TOTAL_QUESTIONS; ++i) {
                    double sigmoid = calculateSigmoid(skill - difficulty[i]);
                    if (rawResult.answers[i] && sigmoid <= 0.25) {
                        ++redFlagCorrect;
                    }
                    if (!rawResult.answers[i] && sigmoid > 0.7) {
                        ++redFlagWrong;
                    }
                }
                return new PlayerResults(rawResult.realPos, rawResult.correct, rawResult.wrong, rawResult.score,
                        redFlagCorrect, redFlagWrong, skill);
            }

            private static double calculateSigmoid(double val) {
                return 1.0 / (1 + Math.pow(Math.E, -1* val));
            }

            @Override
            public String toString() {
                return String.format("%d: rs:%.4f es:%.4f +:%d -:%d flagsCorrect:%d flagsWrong:%d ratCF:%.4f",
                        pos, score, expectedScore, correct, wrong,
                        redFlagsCorrect, redFlagsWrong, redFlagsPerc);
            }

            @Override
            public boolean equals(Object o) {
                if (this == o) return true;
                if (o == null || getClass() != o.getClass()) return false;
                PlayerResults that = (PlayerResults) o;
                return pos == that.pos &&
                        correct == that.correct &&
                        wrong == that.wrong;
            }

            @Override
            public int hashCode(){
                return this.pos;
            }
        }

        static class Help {
            final BufferedReader bf;
            final PrintWriter out;
            StringTokenizer tokenizer;

            public Help(BufferedReader bf, PrintWriter out) {
                this.bf = bf;
                this.out = out;
            }

            public int nInt() throws IOException {
                return Integer.parseInt(next());
            }

            public long nLong() throws IOException {
                return Long.parseLong(next());
            }

            public double nDouble() throws IOException {
                return Double.parseDouble(next());
            }

            String next() throws IOException {
                while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                    tokenizer = new StringTokenizer(bf.readLine());
                }
                return tokenizer.nextToken();
            }

            public void close() throws IOException {
                bf.close();
                out.flush();
            }

            public char nChar() throws IOException {
                return (char) bf.read();
            }
        }

        public static Solution ofConsole() {
            return new Solution(System.in, new OutputStreamWriter(System.out));
        }

        public static Solution ofTestFile(String fileName) {
            InputStream resourceAsStream = Solution.class.getClassLoader().getResourceAsStream(fileName);
            return new Solution(resourceAsStream, new OutputStreamWriter(System.out));
        }

        public Solution(InputStream in, OutputStreamWriter iOut) {
            this.help = new Solution.Help(new BufferedReader(new InputStreamReader(in)), new PrintWriter(iOut));
        }

        public static void main(String... args) throws Exception {
            new Solution(System.in, new OutputStreamWriter(System.out)).read();
        }

        public void read() throws Exception {
            int T = help.nInt();
            int P = help.nInt();
            double minimalCases = P * T / 100.0;
            for (int i = 1; i <= T; ++i) {
                int cheater = (i-1) < minimalCases ? findCheater(P, help) : new Random().nextInt(99) + 1;
                help.out.printf(RESULT, i == 1 ? "" : "\n", i, cheater);
                help.out.flush();
            }
            help.close();
        }

        private static List<RawResult> buildResults(Help help) throws IOException {
            List<RawResult> results = new ArrayList<>(100);
            for (int i = 0; i < TOTAL_PLAYERS; i++) {
                if (i > 0) {
                    help.nChar();
                }
                int correct = 0;
                int wrong = 0;
                boolean[] answers = new boolean[TOTAL_QUESTIONS];
                for (int q = 0; q < TOTAL_QUESTIONS; ++q) {
                    char res = help.nChar();
                    if(res == '1') {
                        ++correct;
                        answers[q] = true;
                    } else {
                        ++wrong;
                    }
                }
                RawResult result = new RawResult(correct, wrong, i, answers);
                if (result.score > 0.5) {
                    results.add(result);
                }
            }
            return results;
        }

        private static PriorityQueue<PlayerResults> runExperiment(List<RawResult> rawResults) throws IOException {
            double[] difficulty = buildDifficulty();
            PriorityQueue<PlayerResults> pq  = new PriorityQueue<>(PLAYER_RESULTS_COMP);
            Random skills = new Random();
            for (RawResult rawResult: rawResults) {
                PlayerResults player = PlayerResults.fromReader(rawResult, calculateRandomInRange(skills), difficulty);
                if(player.score >= 0.75d) {
                    pq.offer(player);
                }
            }
            return pq;
        }

        private static double[] buildDifficulty() {
            double[] difficulty = new double[TOTAL_QUESTIONS];
            Random diff = new Random();
            for (int i = 0; i < difficulty.length; ++i) {
                difficulty[i] = calculateRandomInRange(diff);
            }
            return difficulty;
        }

        private static double calculateRandomInRange(Random random) {
            double rand = random.nextInt(600_000) * 1.0 / 100_000;
            return (rand < 3.0) ? rand : (rand - 3.0d) * -1;
        }

        static class RawResult {
            final int correct;
            final int wrong;
            final boolean[] answers;
            private final double score;
            final int realPos;

            private RawResult(int correct, int wrong, int realPos, boolean[] answers) {
                this.correct = correct;
                this.wrong = wrong;
                this.realPos = realPos;
                this.answers = answers;
                this.score = correct * 100.0 / TOTAL_QUESTIONS;
            }
        }
    }
}
