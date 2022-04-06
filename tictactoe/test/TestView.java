import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import model.RowBlockModel;
import view.RowGameStatusView;
import view.RowGameStatusView.GameStatus;
import controller.RowGameController;

public class TestView {
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
    public void testCompCUpdate(){
        game.gameView.statusView.update(GameStatus.START);
        assertEquals("Player 1 to play 'X'", game.gameView.statusView.playerturn.getText());
    }
}
