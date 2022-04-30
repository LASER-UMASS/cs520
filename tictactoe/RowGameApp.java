
// Import Controller, Model, and View classes.
import controller.RowGameController;
import view.RowGameGUI;
import model.RowGameModel;

/**
 * Main class for the game.
 */
public class RowGameApp {
    /**
     * Starts a new game in the GUI.
     *
     * @param args Command line arguments (no use currently).
     */
    public static void main(String[] args) {
        /**
         * Set default values for rows and columns.
         */
        int rows = 3;
        int cols = 3;

        /**
         * Create a new game model, game controller, and game view.
         */
        RowGameModel gameModel = new RowGameModel(rows, cols);
        RowGameController gameController = new RowGameController();
        RowGameGUI gameView = new RowGameGUI(rows, cols);

        /* REGISTER MVC BLOCK */

        gameModel.addView(gameView);
        gameController.addModel(gameModel);
        gameView.addController(gameController);

        /* END MVC BLOCK */
        gameView.gui.setVisible(true);
    }

}
