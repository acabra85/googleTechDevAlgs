package com.acabra.gtechdevalgs.litcode;

import com.acabra.gtechdevalgs.TestUtils;
import org.hamcrest.MatcherAssert;
import org.junit.Test;

/**
 *  judge if the bot ends up in in the origin after moves
 */
public class JudgeCircleBotTest {

    @Test
    public void api_test_01() {
        String moves = "UD";
        TestUtils.iAssertTrue(new JudgeCircleBot().judgeCircle(moves));
    }

    @Test
    public void api_test_02() {
        String moves = "LL";
        TestUtils.iAssertFalse(new JudgeCircleBot().judgeCircle(moves));
    }
}
