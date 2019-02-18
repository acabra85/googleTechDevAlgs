package com.acabra.gtechdevalgs;

import com.acabra.gtechdevalgs.litcode.KEmptySlotsTest;
import com.acabra.gtechdevalgs.litcode.LongestUnivaluePath;
import com.acabra.gtechdevalgs.litcode.linkedlist.MergeKList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class TestUtils {

    public static KEmptySlotsTest.KEmptySlotsTestUnit readKEmptySlotsTestInput(String fileName) {
        InputStream resourceAsStream = TestUtils.class.getClassLoader()
                .getResourceAsStream(fileName);
        if (resourceAsStream != null) {
            try (BufferedReader bf = new BufferedReader(new InputStreamReader(resourceAsStream))) {
                StringTokenizer st = new StringTokenizer(bf.readLine(), ",");
                int[] flowers = new int[st.countTokens()];
                for(int i=0 ;st.hasMoreTokens();i++) {
                    flowers[i] = Integer.parseInt(st.nextToken());
                }
                return new KEmptySlotsTest.KEmptySlotsTestUnit(flowers, Integer.parseInt(bf.readLine()));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        throw new NullPointerException();
    }

    public static LongestUnivaluePath.TreeNode buildTreeForLongestUnivaluePath(String s) {
        if (s==null || s.length() == 0) return null;
        List<LongestUnivaluePath.TreeNode> nodes = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(s, ",");
        int index = 0;
        while (st.hasMoreTokens()) {
            Integer integer = asInt(st.nextToken());
            if (index == 0) {
                nodes.add(new LongestUnivaluePath.TreeNode(integer));
            }
            else {
                LongestUnivaluePath.TreeNode node = null == integer ? null : new LongestUnivaluePath.TreeNode(integer);
                nodes.add(node);
            }
            index++;
        }
        for (int i = nodes.size()-1; i > 0; i--) {
            LongestUnivaluePath.TreeNode cNode = nodes.get(i);
            if(cNode != null) {
                if (i%2==0) {
                    nodes.get((i-1)/2).right = nodes.get(i);
                } else {
                    nodes.get((i-1)/2).left = nodes.get(i);
                }
            }
        }
        return nodes.get(0);
    }

    private static Integer asInt(String token) {
        return "null".equals(token) ? null : Integer.parseInt(token);
    }

    public static MergeKList.ListNode[] buildMergeKList(String s) {
        StringTokenizer st = new StringTokenizer(s, "[");
        List<MergeKList.ListNode> lists = new ArrayList<>();
        while (st.hasMoreTokens()) {
            String[] split = st.nextToken().split(",");
            MergeKList.ListNode node = null, prev = null;
            for (int i = 0; i < split.length; i++) {
                node = new MergeKList.ListNode(asInt(split[i]));
                if (i==0) {
                    lists.add(node);
                } else {
                    prev.next = node;
                }
                prev = node;
            }
        }
        MergeKList.ListNode[] listNodes = new MergeKList.ListNode[lists.size()];
        for (int i = 0; i < lists.size(); i++) {
            listNodes[i] = lists.get(i);
        }
        return listNodes;
    }
}
