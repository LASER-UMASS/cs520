import controller.HumanRowGameController;
import controller.RowGameController;

public class RowGameApp 
{
    /**
     * Starts a new game in the GUI.
     */
    public static void main(String[] args) {
        RowGameController game = new HumanRowGameController();
        game.gameView.gui.setVisible(true);
    }
}
