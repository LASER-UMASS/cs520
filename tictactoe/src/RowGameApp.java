import controller.AbstractRowGameRules;
import controller.RowGameController;
import controller.TicTacToeGameRules;

public class RowGameApp 
{
    /**
     * Starts a new game in the GUI.
     */
    public static void main(String[] args) {
	if (args.length != 1) {
	    System.err.println("The game rules to followed must be specified.");
	    System.exit(1);
	}

        RowGameController game = new RowGameController(args[0]);
        game.gameView.gui.setVisible(true);
    }
}