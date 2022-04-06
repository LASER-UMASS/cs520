import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import model.RowBlockModel;
import model.RowBlockModel.PlayerPiece;
import view.RowGameStatusView;
import controller.RowGameController;

public class TestModel {
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
    public void testGetPiece(){
        game.gameModel.blocksData[0][0].setPiece(PlayerPiece.X);
        assertEquals(PlayerPiece.X , game.gameModel.blocksData[0][0].getPiece());

    }
}
