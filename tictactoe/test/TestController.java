import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import java.beans.Transient;

import model.RowBlockModel;
import model.RowBlockModel.PlayerPiece;
import model.RowGameModel.Player;
import controller.RowGameController;

public class TestController {
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
    public void testRowChecker(){
        for (int i = 0; i < game.gameModel.blocksData.length ; i++) {
            game.gameModel.blocksData[0][i].setPiece(PlayerPiece.X);
        }
        assertEquals(true, game.rowChecker(2, 0));
        assertEquals(true, game.rowChecker(0, 0));
        assertEquals(true, game.rowChecker(1, 0));
    }
    
}
