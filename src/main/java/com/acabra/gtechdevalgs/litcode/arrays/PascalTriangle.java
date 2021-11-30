package com.acabra.gtechdevalgs.litcode.arrays;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangle {

    public List<List<Integer>> buildPascalTriangleOfHeight(int h) {
        List<List<Integer>> ans = new ArrayList<>(h) {{
            add(new ArrayList<>() {{add(1);}});
        }};
        if(h == 1) {
            return ans;
        } else if( h == 2) {
            ans.add(new ArrayList<>(){{add(1);add(1);}});
            return ans;
        } else if(h==3) {
            ans.add(new ArrayList<>(){{add(1);add(1);}});
            ans.add(new ArrayList<>(){{add(1);add(2);add(1);}});
            return ans;
        }
        return build(ans, h);
    }

    private List<List<Integer>> build(List<List<Integer>> ans, int h) {
        ans.add(new ArrayList<>(){{add(1);add(1);}});
        ans.add(new ArrayList<>(){{add(1);add(2);add(1);}});
        for (int i = 3; i < h; i++) {
            ans.add(buildRow(ans.get(i-1)));
        }
        return ans;
    }

    public List<Integer> buildRow(List<Integer> last) {
        final int rowLen = last.size() + 1;
        List<Integer> row = new ArrayList<>(rowLen) {{add(1);}};
        boolean cloneMid = rowLen % 2 == 0;
        int to = cloneMid ? rowLen / 2 - 1 : rowLen / 2;
        int i = 1;
        for (; i <= to; ++i) {
            row.add(last.get(i-1) + last.get(i));
        }
        // mirror
        int from = cloneMid ? to + 1: to;
        for (; i < rowLen; ++i) {
            row.add(row.get(--from));
        }
        return row;
    }
}