package ca.utoronto.utm.assignment1.othello;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PlayerRandomTest {
    private PlayerRandom player;
    private Othello othello;

    @BeforeEach
    public void setUp() {
        othello = new Othello();
        player = new PlayerRandom(othello, OthelloBoard.P1);
        // Board now looks like
        //   0 1 2 3 4 5 6 7
        //  +-+-+-+-+-+-+-+-+
        // 0| | | | | | | | |0
        //  +-+-+-+-+-+-+-+-+
        // 1| | | | | | | | |1
        //  +-+-+-+-+-+-+-+-+
        // 2| | | | | | | | |2
        //  +-+-+-+-+-+-+-+-+
        // 3| | | |X|O| | | |3
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
        // X:2 O:2  X moves next
    }

    @Test
    public void testGetMove() {
        Move move = player.getMove();
        if (move.getRow() == 2) {
            assertEquals(move.getCol(), 4);
        } else if (move.getRow() == 3) {
            assertEquals(move.getCol(), 5);
        } else if (move.getRow() == 4) {
            assertEquals(move.getCol(), 2);
        } else if (move.getRow() == 5) {
            assertEquals(move.getCol(), 3);
        }
    }

}
