package com.acabra.gtechdevalgs.gset.cjam2022.round1C;

import java.io.*;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class P1_LetterTowers {

    public static class Solution {
        private final Help help;

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

            public String nextSafe() {
                try {
                    return next();
                } catch (IOException e) {
                    return "";
                }
            }

            public void print(String str) {
                out.print(str);
                out.flush();
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

        void read() throws IOException {
            int testCases = help.nInt();
            for (int i = 0; i < testCases; i++) {
                String result = solve(buildArrays(help.nInt(), help));
                String caseStr = String.format(RESULT, (i != 0 ? "\n" : ""), i + 1, result);
                help.print(caseStr);
            }
        }
        public static final String IMPOSSIBLE = "IMPOSSIBLE";

        protected static String solve(final List<String> towers) {
            if(!towers.stream().allMatch(Solution::isValid)) {
                return IMPOSSIBLE;
            }
            Set<Integer> remaining = new HashSet<>();
            Map<Character, List<Integer>> startWithMap = IntStream
                    .range(0, towers.size()).boxed().peek(remaining::add)
                    .collect(transFormToMap(e -> Solution.getFirstChar(towers.get(e))));
            Map<Character, List<Integer>> endWithMap = IntStream
                    .range(0, towers.size()).boxed()
                    .collect(transFormToMap(e -> Solution.getLastChar(towers.get(e))));
            Map<Character, List<Integer>> bothMap = IntStream
                    .range(0, towers.size()).boxed()
                    .filter(e -> Solution.getFirstChar(towers.get(e)) == Solution.getLastChar(towers.get(e)))
                    .collect(transFormToMap(e -> Solution.getFirstChar(towers.get(e))));
            List<Node> nodes = IntStream.range(0, towers.size())
                    .mapToObj(e -> Node.from(e, towers.get(e)))
                    .collect(Collectors.toList());
            Node node = nodes.get(0);
            int id = remaining.size();
            remaining.remove(node.id);
            Set<Node> nonConnected = new HashSet<>();
            while(!remaining.isEmpty()) {
                int x = connectTo(node, remaining, startWithMap, endWithMap, bothMap);
                if (x == -1) {
                    nonConnected.add(node);
                    node = nodes.get(remaining.iterator().next());
                    remaining.remove(node.id);
                } else {
                    remaining.remove(x);
                    node = node.connect(++id, nodes.get(x));
                    if(node.result().equals(IMPOSSIBLE)) {
                       return IMPOSSIBLE;
                    }
                }
            }
            Iterator<Node> iterator = nonConnected.iterator();
            while (iterator.hasNext()) {
                node = node.connect(++id, iterator.next());
                iterator.remove();
            }
            return node.result();
        }

        private static int connectTo(Node node, Set<Integer> remaining, Map<Character, List<Integer>> sMap,
                                        Map<Character, List<Integer>> eMap,
                                        Map<Character, List<Integer>> bMap) {
            Integer idBoth = findFirst(node.end, remaining, bMap);
            if (idBoth != null) return idBoth;
            Integer idStart = findFirst(node.end, remaining, sMap);
            if (idStart != null) return idStart;
            Integer idEnd = findFirst(node.start, remaining, eMap);
            if (idEnd != null) return idEnd;
            return -1;
        }

        private static Integer findFirst(char q, Set<Integer> remaining, Map<Character, List<Integer>> sMap) {
            List<Integer> idsStart = sMap.get(q);
            if (null != idsStart) {
                Iterator<Integer> iterator = idsStart.iterator();
                while (iterator.hasNext()) {
                    int id = iterator.next();
                    iterator.remove();
                    if(remaining.contains(id)) {
                        return id;
                    }
                }
            }
            return null;
        }

        private static Character getLastChar(String s) {
            return s.charAt(s.length()-1);
        }

        private static Collector<Integer, ?, HashMap<Character, List<Integer>>> transFormToMap(Function<Integer, Character> fun) {
            return Collectors.groupingBy(fun, HashMap::new, Collectors.toCollection(ArrayList::new));
        }

        private static Character getFirstChar(String t) {
            return t.charAt(0);
        }

        protected static boolean isValid(String tower) {
            char[] chars = tower.toCharArray();
            Character curr;
            boolean[] seen = new boolean[26];
            int N = chars.length;
            for (int i = 0; i < N;) {
                int id = chars[i] - 'A';
                if(!seen[id]) {
                    curr = chars[i];
                    seen[id] = true;
                    while(i < N && chars[i] == curr) {
                        ++i;
                    }
                } else {
                    return false;
                }
            }
            return true;
        }

        private List<String> buildArrays(int words, Help help) {
            return IntStream.range(0, words)
                    .mapToObj(e -> help.nextSafe())
                    .collect(Collectors.toList());
        }

        private final static String RESULT = "%sCase #%d: %s";


        static class Node{

            private final int id;
            private final String word;
            private final char start;
            private final char end;

            public Node(int id, String word, char start, char end) {
                this.id = id;
                this.word = word;
                this.start=start;
                this.end =end;
            }

            public static Node from(int id, String e) {
                return new Node(id, e, e.charAt(0), e.charAt(e.length()-1));
            }

            public Node joinEnd(int id, Node e) {
                return new Node(id, word+e.word, start, e.end);
            }

            public Node joinStart(int id, Node e) {
                return new Node(id, e.word+word, e.start, end);
            }

            public Node connect(int id, Node node) {
                return (start == node.end) ? joinStart(id, node) : joinEnd(id, node);
            }

            public String result() {
                return isValid(word) ? word : IMPOSSIBLE;
            }

            @Override
            public boolean equals(Object o) {
                if (this == o) return true;
                if (o == null || getClass() != o.getClass()) return false;
                Node node = (Node) o;
                return id == node.id;
            }

            @Override
            public int hashCode() {
                return Objects.hash(id);
            }
        }
    }
}
