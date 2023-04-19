import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.JButton;
import javax.swing.JPanel;

import model.Player;
import model.RowBlockModel;
import view.RowGameGUI;
import view.BlockIndex;
import controller.RowGameController;

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
        assertEquals (Player.PLAYER_1, game.gameModel.getPlayer());
        assertEquals (9, game.gameModel.movesLeft);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNewBlockViolatesPrecondition() {
	RowBlockModel block = new RowBlockModel(null);
    }


    private void checkInitialCondition()
    {
        for (int row = 0; row < 3; row++) {
            for (int column = 0; column < 3; column++) {
                assertEquals("", game.gameModel.blocksData[row][column].getContents());
                assertEquals(true, game.gameModel.blocksData[row][column].getIsLegalMove());
                //assertTrue("all buttons are enabled initially", game.gameView.gameBoardView().isBlockEnabled(new BlockIndex(row, column)));
            }
        }
    }

    //NEED TO RE-EXECUTE
    @Test
    public void testCase5() {

        //pre-conditions 
        assertEquals (9, game.gameModel.movesLeft);
        assertEquals (Player.PLAYER_1, game.gameModel.getPlayer());
        assertEquals (true, game.gameModel.isThereMoveToUndo());
        checkInitialCondition();
        assertNull("final result is null at the beginning of the game", game.gameModel.getFinalResult() );

        //method under test
        game.move((JButton) ((JPanel)((JPanel)game.gameView.gui.getContentPane().getComponent(0)).getComponent(0)).getComponent(0));
        game.move((JButton) ((JPanel)((JPanel)game.gameView.gui.getContentPane().getComponent(0)).getComponent(0)).getComponent(1));
        game.move((JButton) ((JPanel)((JPanel)game.gameView.gui.getContentPane().getComponent(0)).getComponent(0)).getComponent(2));
        game.move((JButton) ((JPanel)((JPanel)game.gameView.gui.getContentPane().getComponent(0)).getComponent(0)).getComponent(3));
        
        game.resetGame();

        //post-condition
        assertEquals (9, game.gameModel.movesLeft);
        assertEquals (Player.PLAYER_1, game.gameModel.getPlayer());
        assertEquals (true, game.gameModel.isThereMoveToUndo());
        checkInitialCondition();
        assertNull("final result is null atfter game is reset", game.gameModel.getFinalResult() );

    }

    @Test
    public void testCase6() {

        //pre-conditions 
        assertEquals (9, game.gameModel.movesLeft);

        //post-condition
        assertEquals (true, game.gameModel.isThereMoveToUndo());
    }

    @Test
    public void testCase7() {

        //pre-conditions 
        game.move((JButton) ((JPanel)((JPanel)game.gameView.gui.getContentPane().getComponent(0)).getComponent(0)).getComponent(0));
        assertEquals (8, game.gameModel.movesLeft);
        assertEquals (false, game.gameModel.blocksData[0][0].getIsLegalMove());
        assertEquals (false, game.gameModel.isThereMoveToUndo());
        
        //method under test
        game.undoGame();

        //post-conditions
        assertEquals (9, game.gameModel.movesLeft);
        assertEquals (true, game.gameModel.blocksData[0][0].getIsLegalMove());
        assertEquals (true, game.gameModel.isThereMoveToUndo());
    }

}
