package com.acabra.gtechdevalgs.google;

import java.util.*;

public class GroupStringsByEqualShift {

    public List<List<String>> groupStrings(String[] strings) {
        Stack<Node> stack = new Stack<>();
        List<Node> nodes = new LinkedList<>();
        for(String str: strings) {
            stack.push(new Node(str));
            nodes.add(stack.peek());
        }
        List<List<String>> res = new ArrayList<>();
        List<String> arr = null;
        while(stack.size()>0) {
            Node tmp = stack.pop();
            if (tmp.notVisited()) {
                arr = new ArrayList<>();
                arr.add(tmp.val);
                tmp.visit();
                Iterator<Node> it = nodes.iterator();
                while (it.hasNext()) {
                    Node node = it.next();
                    if (node.notVisited()) {
                        if (shift(tmp.val, node.val)) {
                            arr.add(node.val);
                            node.visit();
                        }
                    } else {
                        it.remove();
                    }
                }
                res.add(arr);
            }
        }
        return res;
    }

    static class Node {
        private boolean seen = false;
        final String val;
        Node(String val) {
            this.val = val;
        }

        void visit() {
            this.seen = true;
        }

        boolean notVisited() {
            return !this.seen;
        }
    }

    private boolean shift(String a, String b) {
        if(a.length()!= b.length()) return false;
        int diff = (26 + a.charAt(0) - b.charAt(0))%26;
        for(int i = 1; i < a.length();++i) {
            if(diff != (26 + a.charAt(i) - b.charAt(i))%26) {
                return false;
            }
        }
        return true;
    }
}
