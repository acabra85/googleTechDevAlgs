package com.acabra.gtechdevalgs;

import com.acabra.gtechdevalgs.google.StreamCheckerTest;
import com.acabra.gtechdevalgs.gset.MyFile;
import com.acabra.gtechdevalgs.gset.MyFileImpl;
import com.acabra.gtechdevalgs.litcode.KEmptySlotsTest;
import com.acabra.gtechdevalgs.litcode.arrays.MergeIntervals;
import com.acabra.gtechdevalgs.litcode.linkedlist.ListNode;
import com.acabra.gtechdevalgs.litcode.trees.TreeNode;
import org.hamcrest.CustomTypeSafeMatcher;
import org.hamcrest.Matcher;
import org.hamcrest.MatcherAssert;
import org.hamcrest.collection.IsArray;
import org.hamcrest.core.Is;
import org.hamcrest.number.IsCloseTo;

import java.io.*;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class TestUtils {

    protected final static String RESOURCES_FOLDER = "src/test/resources/";

    public static KEmptySlotsTest.KEmptySlotsTestUnit readKEmptySlotsTestInput(String fileName) {
        InputStream resourceAsStream = TestUtils.class.getClassLoader()
                .getResourceAsStream(fileName);
        if (resourceAsStream != null) {
            try (BufferedReader bf = new BufferedReader(new InputStreamReader(resourceAsStream, StandardCharsets.UTF_8.name()))) {
                String line = bf.readLine();
                if (line == null) return null;
                StringTokenizer st = new StringTokenizer(line, ",");
                int[] flowers = new int[st.countTokens()];
                for(int i=0 ;st.hasMoreTokens();i++) {
                    flowers[i] = Integer.parseInt(st.nextToken());
                }
                line = bf.readLine();
                if (line == null) return null;
                return new KEmptySlotsTest.KEmptySlotsTestUnit(flowers, Integer.parseInt(line));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        throw new NullPointerException();
    }

    public static TreeNode buildBSTFromString(String s) {
        if (s==null || s.length() == 0) return null;
        List<TreeNode> nodes = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(s, ",");
        int index = 0;
        while (st.hasMoreTokens()) {
            Integer integer = asInt(st.nextToken());
            if (index == 0) {
                nodes.add(new TreeNode(integer));
            }
            else {
                TreeNode node = null == integer ? null : new TreeNode(integer);
                nodes.add(node);
            }
            index++;
        }
        for (int i = nodes.size()-1; i > 0; i--) {
            TreeNode cNode = nodes.get(i);
            if(cNode != null) {
                TreeNode treeNode = nodes.get((i - 1) / 2);
                if (i%2==0) {
                    treeNode.right = nodes.get(i);
                } else {
                    treeNode.left = nodes.get(i);
                }
            }
        }
        return nodes.get(0);
    }

    private static Integer asInt(String token) {
        return "null".equals(token) ? null : Integer.parseInt(token);
    }

    public static ListNode[] buildMergeKList(String s) {
        StringTokenizer st = new StringTokenizer(s, "[");
        List<ListNode> lists = new ArrayList<>();
        while (st.hasMoreTokens()) {
            String[] split = st.nextToken().split(",");
            ListNode node = null, prev = null;
            for (int i = 0; i < split.length; i++) {
                node = new ListNode(asInt(split[i]));
                if (i==0) {
                    lists.add(node);
                } else {
                    prev.next = node;
                }
                prev = node;
            }
        }
        ListNode[] listNodes = new ListNode[lists.size()];
        for (int i = 0; i < lists.size(); i++) {
            listNodes[i] = lists.get(i);
        }
        return listNodes;
    }

    public static <T extends Comparable> void assertListEquals(List<T> l1, List<T> l2) {
        if(null == l1 || null == l2) {
            if (l1 != l2) throw new AssertionError("lists are different");
            else return;
        }
        if (l1.size() != l2.size()) throw new AssertionError("lists have different lengths l1: "+ l1.size() + " l2:" + l2.size());
        for (int i = 0; i < l1.size(); i++) {
            if (l1.get(i).compareTo(l2.get(i)) != 0)
                throw new AssertionError("lists are different at element i:" + i  + " l1: "+ l1.get(i) + " l2:" + l2.get(i));
        }
    }

    public static <T> void assertListEquals(List<T> l1, List<T> l2, Comparator<T> comp) {
        if(null == l1 || null == l2) {
            if (l1 != l2) throw new AssertionError("lists are different");
            else return;
        }
        if (l1.size() != l2.size()) throw new AssertionError("lists have different lengths");
        for (int i = 0; i < l1.size(); i++) {
            if (comp.compare(l1.get(i), l2.get(i)) != 0)
                throw new AssertionError("lists are different at element i:" + i  + " l1: "+ l1.get(i) + " l2:" + l2.get(i));
        }
    }

    public static List<MergeIntervals.Interval> buildIntervalList(int[][] inputArray) {
        List<MergeIntervals.Interval> list = new ArrayList<>();
        for (int i = 0; i < inputArray.length; i++) {
            list.add(new MergeIntervals.Interval(inputArray[i][0], inputArray[i][1]));
        }
        return list;
    }

    public static ListNode buildNumberAsNodeReverseOrder(String numAsStr) {
        String reversed = new StringBuilder(numAsStr).reverse().toString();
        ListNode head = new ListNode(0);
        ListNode current = head;
        for (int i = 0; i < reversed.length(); i++) {
            current.next = new ListNode(Integer.parseInt(reversed.charAt(i)+""));
            current = current.next;
        }
        return head.next;
    }

    public static MyFile buildMyFile(String fileName) {
        InputStream resourceAsStream = TestUtils.class.getClassLoader().getResourceAsStream(fileName);
        return new MyFileImpl(resourceAsStream);
    }

    public static List<BigInteger> buildBigIntegerList(String cypherList) {
        List<BigInteger> list = new ArrayList<>();
        for (String num : cypherList.split("\\s+")) {
            list.add(new BigInteger(num));
        }
        return list;
    }

    public static ListNode buildLinkedListOfValues(int[] values) {
        ListNode old = null;
        for (int i = values.length - 1; i >= 0; i--) {
            ListNode newNode = new ListNode(values[i]);
            newNode.next = old;
            old = newNode;
        }
        return old;
    }

    public static Map.Entry<Map.Entry<String[], String[]>, String[]> buildStreamCheckerBigTestCase() {
        Scanner scInput = new Scanner(Objects.requireNonNull(StreamCheckerTest.class.getClassLoader()
                .getResourceAsStream("streamchecker_big.in")));
        String[] input = scInput.next().split(",");
        String[] queries = scInput.next().split(",");

        Scanner scExpected = new Scanner(Objects.requireNonNull(StreamCheckerTest.class.getClassLoader()
                .getResourceAsStream("streamchecker_big.out")));
        String[] results = scExpected.next().split(",");
        scInput.close();
        scExpected.close();
        return Map.entry(Map.entry(input,queries), results);
    }

    public static int[] buildTestCaseBigJumpingEvenOdd(String fileName) {
        Scanner scInput = new Scanner(Objects.requireNonNull(StreamCheckerTest.class.getClassLoader()
                .getResourceAsStream(fileName)));
        String[] input = scInput.next().split(",");
        int[] res = new int[input.length];
        for (int i = 0; i < res.length; ++i) {
            res[i] = Integer.parseInt(input[i]);
        }
        scInput.close();
        return res;
    }

    public static void writeCollectionAsResource(String fileName, Collection<Integer> actual) {
        String outPathFolder = RESOURCES_FOLDER + fileName;
        try(BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outPathFolder)))) {
            StringBuilder sb = new StringBuilder();
            actual.forEach(element -> sb.append(element).append(","));
            String result = sb.toString();
            bw.write(result.substring(0, result.length()-1));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void iAssertTrue(boolean actual) {
        MatcherAssert.assertThat(actual, Is.is(true));
    }

    public static void iAssertFalse(boolean actual) {
        MatcherAssert.assertThat(actual, Is.is(false));
    }

    @SuppressWarnings({"unchecked"})
    public static Matcher<double[]> isArrayCloseTo(double[] expected, double error) {
        List<Matcher<Double>> matchers = new ArrayList<>();
        for (double d : expected)
            matchers.add(new IsCloseTo(d, error));

        return new CustomTypeSafeMatcher<>("array that is close to" + Arrays.toString(expected)) {
            @Override
            protected boolean matchesSafely(double[] actual) {
                return new IsArray<Double>(matchers.toArray(new Matcher[matchers.size()]))
                        .matchesSafely(Arrays.stream(actual).boxed().toArray(Double[]::new));
            }
        };
    }
}
