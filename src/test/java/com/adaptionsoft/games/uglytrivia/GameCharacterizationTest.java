package com.adaptionsoft.games.uglytrivia;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.spy;

public class GameCharacterizationTest {

    @Test
    public void rollNotInPenaltyBox(){
        final Game game = spy(new Game());
        doNothing().when(game).logRoll(anyInt());
        game.add("Jens");
        game.roll(3);

        assertEquals(3, game.currentPlayer().place());
    }
}