import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import model.BlockIndex;
import model.Player;
import model.RowGameModel;
import model.RowBlockModel;
import controller.HumanRowGameController;
import controller.RowGameController;

/**
 * An example test class, which merely shows how to write JUnit tests.
 */
public class TestExample {
    private RowGameController game;

    @Before
    public void setUp() {
	game = new HumanRowGameController();
    }

    @After
    public void tearDown() {
	game = null;
    }

    private void checkInitialConfiguration() {
	// Check the post-conditions for the new RowGameModel
	assertNotNull(game.gameModel);
	// The first player has the initial move
	assertEquals (Player.PLAYER_1, game.gameModel.getPlayer());
	// There are initially 9 possible moves left to make
	assertEquals (9, game.gameModel.movesLeft);
	// Each block is empty and a legal move
	for (int row = 0; row < 3; row++) {
	    for (int col = 0; col < 3; col++) {
		assertEquals("", game.gameModel.blocksData[row][col].getContents());
		assertEquals(true, game.gameModel.blocksData[row][col].getIsLegalMove());
	    } // end for col
	} // end for row
	// The final result is null
	assertNull(game.gameModel.getFinalResult());
    }

    @Test
    public void testNewGame() {
	// The @Before method performs the setup and calls the unit under test.
	//
	// Check the post-conditions (i.e. class invariants)
	this.checkInitialConfiguration();
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNewBlockViolatesPrecondition() {
	// Call the unit under test
	RowBlockModel block = new RowBlockModel(null);
	// Check the post-conditions. See the @Test annotation.
    }

    public void testLegalMoveHelper(BlockIndex blockIndex) {
	// In the setUp method, the RowGameController constructor
	// created a new RowGameModel.
	//
	// Check the pre-conditions (i.e. class invariants)
	this.checkInitialConfiguration();
	// Call the unit under test: Execute a legal move
	game.move(blockIndex);
	// Check the post-conditions (i.e. class invariants)
	assertEquals(Player.PLAYER_2, game.gameModel.getPlayer());
	assertEquals(8, game.gameModel.movesLeft);
	assertEquals("X", game.gameModel.blocksData[blockIndex.getRow()][blockIndex.getColumn()].getContents());
	assertEquals(false, game.gameModel.blocksData[blockIndex.getRow()][blockIndex.getColumn()].getIsLegalMove());
    }

    @Test
    public void testLegalMove() {
	BlockIndex blockIndex = new BlockIndex(0, 0);
	testLegalMoveHelper(blockIndex);
    }
    
    @Test(expected=UnsupportedOperationException.class)
    public void testIllegalMove() {
	// Perform the setup and check the pre-conditions
	BlockIndex blockIndex = new BlockIndex(0, 0);
	testLegalMoveHelper(blockIndex);
	
	// Call the unit under test: Execute an illegal move
	game.move(blockIndex);

	// Check the post-conditions (i.e. class invariants).
	// See the @Test annotation.
    }

    @Test
    public void testGameOverWin() {
	// Perform setup and check the pre-conditions
	game.move(new BlockIndex(0, 0));
	game.move(new BlockIndex(2, 2));
	game.move(new BlockIndex(0, 1));
	game.move(new BlockIndex(2, 1));
	for (int column = 0; column < 2; column++) {
	    assertEquals("X", game.gameModel.blocksData[0][column].getContents());
	} // end for column
	assertEquals(null, game.gameModel.getFinalResult());
	// Call the unit under test: Player 1 has 3 Xs in a row
	BlockIndex player1WinsBlockIndex = new BlockIndex(0, 2);
	game.move(player1WinsBlockIndex);
	// Check the post-conditions
	assertEquals("X", game.gameModel.blocksData[player1WinsBlockIndex.getRow()][player1WinsBlockIndex.getColumn()].getContents());
	assertEquals("Player 1 wins!", game.gameModel.getFinalResult());
    }

    @Test
    public void testGameOverTie() {
	// Perform setup and check the pre-conditions
	for (int column = 0; column < 3; column++) {
	    game.move(new BlockIndex(0, column));
	} // end for column
	for (int column = 0; column < 3; column++) {
	    game.move(new BlockIndex(2, column));
	} // end for column	       
	for (int column = 0; column < 2; column++) {
	    game.move(new BlockIndex(1, column));
	} // end for column
	assertEquals(null, game.gameModel.getFinalResult());
	// Call the unit under test: Neither player wins
	game.move(new BlockIndex(1, 2));
	// Check the post-conditions
	assertEquals(RowGameModel.GAME_END_NOWINNER, game.gameModel.getFinalResult());
    }

    @Test
    public void testReset() {
	// Perform the setup and check the pre-conditions
	BlockIndex blockIndex = new BlockIndex(0, 0);
	testLegalMoveHelper(blockIndex);

	// Call the unit under test: Execute reset
	game.resetGame();

	// Check the post-conditions
	this.checkInitialConfiguration();
    }

    @Test(expected=UnsupportedOperationException.class)
    public void testUndoDisallowed() {
	// Perform the setup and check the pre-conditions
	this.checkInitialConfiguration();

	// Call the unit under test: Execute undo
	game.undo();

	// Check the post-conditions. See the @Test annotation.
    }
    
    @Test
    public void testUndoAallowed() {
	// Perform the setup and check the pre-conditions
	BlockIndex blockIndex = new BlockIndex(0, 0);
	testLegalMoveHelper(blockIndex);
	
	// Call the unit under test: Execute undo
	game.undo();

	// Check the post-conditions
	this.checkInitialConfiguration();
    }
}
