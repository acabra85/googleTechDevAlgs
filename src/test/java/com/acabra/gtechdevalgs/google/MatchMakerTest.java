package com.acabra.gtechdevalgs.google;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

@ExtendWith(MockitoExtension.class)
public class MatchMakerTest {
    private MatchMaker.GameServer mock;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        mock = Mockito.mock(MatchMaker.GameServer.class);
    }

    @Test
    public void shouldNotMatchNewPlayer_watlistEmpty() {
        MatchMaker underTest = new MatchMaker(mock);
        underTest.attemptMatching(new MatchMaker.Player(200));

        Assertions.assertThat(underTest.playersWaitingCount()).isEqualTo(1);
        Mockito.verify(mock, Mockito.times(0)).startGame(Mockito.any(), Mockito.any());
    }

    @Test
    public void shouldMatchNewPlayer_availableMatchInWaitlist() {
        MatchMaker underTest = new MatchMaker(mock);
        Mockito.doNothing().when(mock).startGame(Mockito.any(), Mockito.any());

        underTest.attemptMatching(new MatchMaker.Player(200));
        underTest.attemptMatching(new MatchMaker.Player(299));

        Assertions.assertThat(underTest.playersWaitingCount()).isEqualTo(0);
        Mockito.verify(mock, Mockito.times(1)).startGame(Mockito.any(), Mockito.any());
    }

    @Test
    public void shouldNotMatchNewPlayer_notAvailableMatchInWaitlist() {
        MatchMaker underTest = new MatchMaker(mock);
        underTest.attemptMatching(new MatchMaker.Player(200));
        underTest.attemptMatching(new MatchMaker.Player(500));

        Assertions.assertThat(underTest.playersWaitingCount()).isEqualTo(2);
        Mockito.verify(mock, Mockito.times(0)).startGame(Mockito.any(), Mockito.any());
    }

    @Test
    public void shouldMatchNewPlayer_availableMatchInWaitlistOptimal() {
        MatchMaker underTest = new MatchMaker(mock);
        Mockito.doNothing().when(mock).startGame(Mockito.any(), Mockito.any());
        List<Integer> playerRatings = List.of(151, 348, 250, 70);
        int expectedWaitlistSize = 0;

        runTest(underTest, playerRatings, expectedWaitlistSize);
    }

    // This naive implementation fails
    @Test
    public void shouldMatchNewPlayer_availableMatchInWaitlistNaive() {
        MatchMaker underTest = new MatchMaker(mock, true);
        Mockito.doNothing().when(mock).startGame(Mockito.any(), Mockito.any());
        List<Integer> playerRatings = List.of(151, 348, 250, 70);
        int expectedWaitlistSize = 2;

        runTest(underTest, playerRatings, expectedWaitlistSize);
    }

    private void runTest(MatchMaker underTest, List<Integer> playerRatings, int expectedWaitlistSize) {
        playerRatings.forEach(rating -> underTest.attemptMatching(new MatchMaker.Player(rating)));
        Assertions.assertThat(underTest.playersWaitingCount()).isEqualTo(expectedWaitlistSize);
        int times = (playerRatings.size() - expectedWaitlistSize) / 2;
        Mockito.verify(mock, Mockito.times(times)).startGame(Mockito.any(), Mockito.any());
    }

}