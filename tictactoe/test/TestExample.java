import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import java.beans.Transient;

import javax.swing.JButton;

import model.RowBlockModel;
import model.RowGameModel;
import model.RowBlockModel.PlayerPiece;
import model.RowGameModel.Player;
import view.RowGameStatusView.GameStatus;
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
        assertEquals (Player.One, game.gameModel.player);
        assertEquals (9, game.gameModel.movesLeft);
        assertEquals(null, game.gameModel.getFinalResult());
        for (int i = 0; i < game.gameModel.blocksData.length; i++) {
            for (int j = 0; j < game.gameModel.blocksData.length; j++) {
                assertEquals(PlayerPiece.Empty, game.gameModel.blocksData[i][j].getPiece()); 
            }
        }
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNewBlockViolatesPrecondition() {
	    RowBlockModel block = new RowBlockModel((RowGameModel) null);
    }

    /**
     * Test for "One of the players win" BEGIN
     */
    @Test
    public void testP1Wins(){
        //set the board so player X has three-in-a-row
        game.gameView.boardView.blocks[0][0].doClick(); //X
        game.gameView.boardView.blocks[1][0].doClick(); //O
        game.gameView.boardView.blocks[0][1].doClick(); //X
        game.gameView.boardView.blocks[1][1].doClick(); //O
        game.gameView.boardView.blocks[0][2].doClick(); //X
        assertEquals("Player 1 wins!", game.gameView.statusView.playerturn.getText());

    }

    @Test
    public void testP2Wins(){
        //set the board so player X has three-in-a-row
        game.gameView.boardView.blocks[0][0].doClick(); //X
        game.gameView.boardView.blocks[1][0].doClick(); //O
        game.gameView.boardView.blocks[0][1].doClick(); //X
        game.gameView.boardView.blocks[1][1].doClick(); //O
        game.gameView.boardView.blocks[2][0].doClick(); //X
        game.gameView.boardView.blocks[1][2].doClick(); //O
        assertEquals("Player 2 wins!", game.gameView.statusView.playerturn.getText());

    }

    /**
     * Test for "One of the players win" END
     */

     /**
      * Test for "The two players tie"
      */
    @Test
    public void twoPlayersTie(){

        game.gameView.boardView.blocks[0][0].doClick(); //X
        game.gameView.boardView.blocks[0][2].doClick(); //O
        game.gameView.boardView.blocks[0][1].doClick(); //X
        game.gameView.boardView.blocks[1][0].doClick(); //O
        game.gameView.boardView.blocks[1][1].doClick(); //X
        game.gameView.boardView.blocks[2][1].doClick(); //O
        game.gameView.boardView.blocks[1][2].doClick(); //X
        game.gameView.boardView.blocks[2][2].doClick(); //O
        game.gameView.boardView.blocks[2][0].doClick(); //X

        assertEquals("Game ends in a draw" ,game.gameView.statusView.playerturn.getText());
    }

    /**
     * Test for "Reset"
    */
    @Test
    public void testReset(){
        game.gameView.reset.doClick();
        testNewGame();
    }
    /**
     * Test "Illegal Move"
     */
    @Test
    public void testIllegalMove(){
        boolean flag = false;
        RowBlockModel[][] ogBoard = new RowBlockModel[3][3];
        for (int i = 0; i < ogBoard.length; i++) {
            for (int j = 0; j < ogBoard.length; j++) {
                ogBoard[j][i] = new RowBlockModel(game.gameModel.blocksData[j][i]);
            }
        }
        game.gameView.boardView.blocks[1][0].doClick();
        for (int i = 0; i < ogBoard.length; i++) {
            for (int j = 0; j < ogBoard.length; j++) {
                flag = (flag || ogBoard[j][i].equals(game.gameModel.blocksData[j][i]));
            }
        }
        assertEquals(true, flag);
    }
    /**
     * Test "Legal Move"
     */
    @Test
    public void testLegalMove(){
        boolean flag = false;
        RowBlockModel[][] ogBoard = new RowBlockModel[3][3];
        for (int i = 0; i < ogBoard.length; i++) {
            for (int j = 0; j < ogBoard.length; j++) {
                ogBoard[j][i] = new RowBlockModel(game.gameModel.blocksData[j][i]);
            }
        }
        game.gameView.boardView.blocks[1][0].doClick();
        for (int i = 0; i < ogBoard.length; i++) {
            for (int j = 0; j < ogBoard.length; j++) {
                flag = (flag & ogBoard[j][i].equals(game.gameModel.blocksData[j][i]));
            }
        }
        assertEquals(false, flag);
    }
}
