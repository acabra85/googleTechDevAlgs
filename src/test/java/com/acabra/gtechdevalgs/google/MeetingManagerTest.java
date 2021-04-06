package com.acabra.gtechdevalgs.google;

import com.acabra.gtechdevalgs.TestUtils;
import java.util.List;
import java.util.Map;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Describe your class
 */
public class MeetingManagerTest {

    MeetingManager underTest;

    @Before
    public void setup(){
        this.underTest = new MeetingManager();
    }

    @Test
    public void findAvailability() {
        Map<String, List<MeetingManager.Interval>> userMeetings = TestUtils.buildUserMeetings();
        this.underTest.findAvailability(userMeetings, 45, 0.75);
    }
}