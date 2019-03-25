package com.acabra.gtechdevalgs.litcode;

import org.junit.Assert;
import org.junit.Test;

/**
 *  judge if the bot ends up in in the origin after moves
 */
public class JudgeCircleBotTest {

    @Test
    public void api_test_01() {
        String moves = "UD";
        Assert.assertTrue(new JudgeCircleBot().judgeCircle(moves));
    }

    @Test
    public void api_test_02() {
        String moves = "LL";
        Assert.assertFalse(new JudgeCircleBot().judgeCircle(moves));
    }
}
