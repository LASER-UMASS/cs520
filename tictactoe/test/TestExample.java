import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import javax.swing.JButton;

import model.Player;
import model.RowBlockModel;
import controller.RowGameController;

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

    // @Test
    // public void testIllegalMove() {
    // // Make an illegal move (selecting an already occupied block)
    // // a legal move
    // game.move(game.gameView.gameBoardView.blocks[0][0]);
    // assertEquals(Player.PLAYER_2, game.gameModel.getPlayer());
    // assertEquals(8, game.gameModel.movesLeft);
    // // an illegal move (selecting an already occupied block)
    // game.move(game.gameView.gameBoardView.blocks[0][0]);
    // assertEquals(Player.PLAYER_1, game.gameModel.getPlayer());
    // assertEquals(7, game.gameModel.movesLeft);
    // }

    // @Test
    // public void testLegalMoveUpdatesGame() {

    // // Move to a valid block
    // game.move(game.gameView.gameBoardView.blocks[0][0]);

    // // The current player should have changed
    // assertEquals(Player.PLAYER_2, game.gameModel.getPlayer());

    // // The blocks data should have been updated
    // assertEquals("X", game.gameModel.blocksData[0][0].getContents());

    // // The number of moves left should have decreased by 1
    // assertEquals(8, game.gameModel.movesLeft);
    // }

    @Test
    public void testWinningMove() {
        // Player 1 makes the winning move
        game.move(game.gameView.gameBoardView.blocks[0][0]);
        game.move(game.gameView.gameBoardView.blocks[0][1]);
        game.move(game.gameView.gameBoardView.blocks[1][0]);
        game.move(game.gameView.gameBoardView.blocks[0][2]);
        game.move(game.gameView.gameBoardView.blocks[2][0]);

        assertEquals("Player 1 wins!", game.gameModel.getFinalResult());
        // assertEquals(Player.PLAYER_2, game.gameModel.getPlayer());
        //// The game should be over
        assertEquals(false, game.gameModel.blocksData[0][2].getIsLegalMove());
    }

    // @Test
    // public void testTieGame() {
    // // Make a series of moves that results in a tie game
    // game.move(game.gameView.gameBoardView.blocks[0][0]); // Player 1
    // game.move(game.gameView.gameBoardView.blocks[0][1]); // Player 2
    // game.move(game.gameView.gameBoardView.blocks[0][2]); // Player 1
    // game.move(game.gameView.gameBoardView.blocks[1][0]); // Player 2
    // game.move(game.gameView.gameBoardView.blocks[1][1]); // Player 1
    // game.move(game.gameView.gameBoardView.blocks[2][1]); // Player 2
    // game.move(game.gameView.gameBoardView.blocks[1][2]); // Player 1
    // game.move(game.gameView.gameBoardView.blocks[2][0]); // Player 2
    // game.move(game.gameView.gameBoardView.blocks[2][2]); // Player 1
    // System.out.printf("%s", game.gameModel.getFinalResult());
    // // assertTrue(game.isGameOver());
    // // assertNull(game.getWinner());
    // }

    // @Test
    // public void testResetGame() {
    // // Reset the game and check if the initial configuration is as expected
    // game.reset();
    // assertEquals(Player.PLAYER_1, game.gameModel.getPlayer());
    // assertEquals(9, game.gameModel.movesLeft);
    // assertFalse(game.isGameOver());
    // assertNull(game.getWinner());
    // }

    // @Test
    // public void testUndoNotAllowedBeforeMove() {
    // // Undo should not be allowed if no moves have been made
    // assertFalse(game.undoMove());
    // }

    // @Test
    // public void testUndoMove() {
    // JButton button = new JButton();

    // // Make a move
    // game.move(null);
    // ;
    // Player currentPlayer = game.gameModel.getPlayer();
    // int movesLeft = game.gameModel.movesLeft;

    // // Verify the move was made successfully
    // assertEquals(Player.PLAYER_2, currentPlayer);
    // assertEquals(8, movesLeft);

    // // Undo the move
    // game.undoMove();

    // // Verify the game is updated appropriately
    // currentPlayer = game.gameModel.getPlayer();
    // movesLeft = game.gameModel.movesLeft;

    // assertEquals(Player.PLAYER_1, currentPlayer);
    // assertEquals(9, movesLeft);
    // }

}
