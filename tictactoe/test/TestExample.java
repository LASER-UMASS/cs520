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

    @Test
    public void testCase6() {

        //pre-condition
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
