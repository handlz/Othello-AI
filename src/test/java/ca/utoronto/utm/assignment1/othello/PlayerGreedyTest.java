package ca.utoronto.utm.assignment1.othello;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PlayerGreedyTest {
    private PlayerGreedy player;
    private Othello othello;

    @BeforeEach
    public void setUp() {
        othello = new Othello();
        player = new PlayerGreedy(othello, OthelloBoard.P1);
        othello.move(2, 4);
        othello.move(2, 5);
        othello.move(2, 6);
        othello.move(2, 3);
        // Board now looks like
        //   0 1 2 3 4 5 6 7
        //  +-+-+-+-+-+-+-+-+
        // 0| | | | | | | | |0
        //  +-+-+-+-+-+-+-+-+
        // 1| | | | | | | | |1
        //  +-+-+-+-+-+-+-+-+
        // 2| | | |O|X|X|X| |2
        //  +-+-+-+-+-+-+-+-+
        // 3| | | |O|O| | | |3
        //  +-+-+-+-+-+-+-+-+
        // 4| | | |O|X| | | |4
        //  +-+-+-+-+-+-+-+-+
        // 5| | | | | | | | |5
        //  +-+-+-+-+-+-+-+-+
        // 6| | | | | | | | |6
        // +-+-+-+-+-+-+-+-+
        // 7| | | | | | | | |7
        //  +-+-+-+-+-+-+-+-+
        //   0 1 2 3 4 5 6 7
        //
        // X:4 O:4  X moves next
    }

    @Test
    public void testGetMove1() {
        Move move = player.getMove();
        assertEquals(move.getRow(), 2);
        assertEquals(move.getCol(), 2);
    }

    @Test
    public void testGetMove2() {
        othello.move(2, 2);
        Move move = player.getMove();
        assertEquals(move.getRow(), 5);
        assertEquals(move.getCol(), 2);
    }

    @Test
    public void testGetMove3() {
        othello.move(5, 2);
        Move move = player.getMove();
        assertEquals(move.getRow(), 1);
        assertEquals(move.getCol(), 3);
    }

    @Test
    public void testGetMove4() {
        othello.move(1, 3);
        Move move = player.getMove();
        assertEquals(move.getRow(), 2);
        assertEquals(move.getCol(), 2);
    }

}
