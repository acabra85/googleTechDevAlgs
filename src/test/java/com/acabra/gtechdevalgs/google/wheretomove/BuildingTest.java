package com.acabra.gtechdevalgs.google.wheretomove;

import com.acabra.gtechdevalgs.TestUtils;
import org.hamcrest.MatcherAssert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static com.acabra.gtechdevalgs.google.wheretomove.Interest.COFFEE_SHOP;
import static com.acabra.gtechdevalgs.google.wheretomove.Interest.GYM;

public class BuildingTest {

    @Test
    public void should_return_true() {
        List<Interest> availableInterests = new ArrayList<Interest>(){{
            add(COFFEE_SHOP);
            add(GYM);
        }};
        TestUtils.iAssertTrue(new Building(availableInterests).hasInterest(COFFEE_SHOP));
    }
}
