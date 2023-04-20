import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import model.Player;
import model.RowBlockModel;
import model.RowGameModel;
import controller.RowGameController;

import javax.swing.JButton;

/**
 * An example test class, which merely shows how to write JUnit tests.
 */
public class TestExample {
    private RowGameController game;

    @Before
    public void setUp() {
        game = new RowGameController();
    }

    @After
    public void tearDown() {
        game = null;
    }

    @Test
    public void testNewGame() {
        assertEquals(Player.PLAYER_1, game.gameModel.getPlayer());
        assertEquals(9, game.gameModel.movesLeft);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNewBlockViolatesPrecondition() {
        RowBlockModel block = new RowBlockModel(null);
    }

    ///////////////////////// *1.After performing an illegal move, the game is not
    ///////////////////////// updated.*/
    @Test
    public void testIllegalMove() {
        // Place a block in an already occupied cell
        JButton block = game.gameView.blocks[0][0];
        Player currentPlayer = game.gameModel.getPlayer();
        game.move(block);
        // Try to place another block in the same cell
        boolean success = game.move(block);
        // Check if the move was unsuccessful
        assertFalse(success);
        // Check if the game state remains the same
        assertEquals(currentPlayer, game.gameModel.getPlayer());
    }

    // 2After performing a legal move, the game is updated appropriately.
    @Test
    public void testLegalMove() {
        // Place a block in an empty cell
        int row = 0;
        int col = 0;
        Player currentPlayer = game.gameModel.getPlayer();
        boolean success = game.move(row, col);
        // Check if the move was successful
        assertEquals(true, success);
        // Check if the game state was updated correctly
        assertNotEquals(currentPlayer, game.gameModel.getPlayer());
        assertEquals(8, game.gameModel.movesLeft);
    }

    // 3One of the players wins the game.
    @Test
    public void testWinningGame() {
        // Make moves to achieve a winning state
        game.move(0, 0); // Player 1
        game.move(1, 0); // Player 2
        game.move(0, 1); // Player 1
        game.move(1, 1); // Player 2
        game.move(0, 2); // Player 1 (wins)
        // Check if the game state reflects the winner
        assertEquals(Player.PLAYER_1, game.gameModel.getWinner());
    }

    // 4The players tie the game.
    @Test
    public void testTieGame() {
        // Make moves to achieve a tied state
        game.move(0, 0); // Player 1
        game.move(0, 1); // Player 2
        game.move(0, 2); // Player 1
        game.move(1, 0); // Player 2
        game.move(1, 2); // Player 1
        game.move(1, 1); // Player 2
        game.move(2, 0); // Player 1
        game.move(2, 2); // Player 2
        game.move(2, 1); // Player 1 (tie)
        // Check if the game state reflects the tie
        assertEquals(Player.NONE, game.gameModel.getWinner());
    }

    // 5. After resetting the app, the game has the expected initial configuration.
    @Test
    public void testResetGame() {
        // Make some moves and reset the game
        game.move(0, 0); // Player 1
        game.move(1, 0); // Player 2
        game.reset();
        // Check if the game state is reset to initial values
        assertEquals(Player.PLAYER_1, game.gameModel.getPlayer());
        assertEquals(9, game.gameModel.movesLeft);
        assertEquals(Player.NONE, game.gameModel.getWinner());
    }

    // 6. If the user has not done at least one move, the user is not permitted to
    // undo.
@Test
public void testUndoNotAllowedBeforeAnyMoves() {
    // Check if undo is disallowed before any moves are made
    boolean success = game.undo();
    assertEquals(false, success);
}``

}
