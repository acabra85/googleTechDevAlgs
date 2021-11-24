package com.acabra.gtechdevalgs.litcode.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PascalTriangle {

    private List<List<Integer>> triangle;

    public List<List<Integer>> buildPascalTriangleOfHeight(int h) {
        List<Integer> curr;
        List<List<Integer>> ans = new ArrayList(h) {{
            add(new ArrayList() {{
                add(1);
            }});
        }};
        List<Integer> last = ans.get(0);
        for (int i = 1; i < h; ++i) {
            curr = buildRow(i, last);
            ans.add(curr);
            last = curr;
        }
        triangle = ans;
        return ans;
    }

    public List<Integer> buildRow(int idx, List<Integer> last) {
        List<Integer> row = new ArrayList(last.size() + 1) {{
            add(1);
        }};

        for (int i = 1; i < last.size(); ++i) {
            row.add(last.get(i - 1) + last.get(i));
        }
        row.add(1);
        return row;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        for (int i =0; i<triangle.size();++i) {
            if(i>0) {
                sb.append(",");
            }
            sb.append(Arrays.toString(triangle.get(i).toArray()));
        }
        return sb.append("]").toString();
    }
}