import controller.ComputerRowGameController;
import controller.HumanRowGameController;
import controller.RowGameController;

public class RowGameApp 
{
    public static final String HUMAN_VS_HUMAN = "HUMAN_VS_HUMAN";
    public static final String HUMAN_VS_COMPUTER = "HUMAN_VS_COMPUTER";
    
    /**
     * Starts a new game in the GUI.
     */
    public static void main(String[] args) {
	// Perform input validation
	if (args.length != 1) {
	    System.err.println("Must specify a single argument of either " + HUMAN_VS_HUMAN + " or " + HUMAN_VS_COMPUTER);
	    System.exit(1);
	}
	String vsArg = args[0];
        RowGameController game = null;
	if (HUMAN_VS_HUMAN.equals(vsArg)) {
	    game = new HumanRowGameController();
	}
	else if (HUMAN_VS_COMPUTER.equals(vsArg)) {
	    game = new ComputerRowGameController();
	}
	else {
	    System.err.println("Must specify either " + HUMAN_VS_HUMAN + " or " + HUMAN_VS_COMPUTER);
	    System.exit(1);
	}
        game.gameView.gui.setVisible(true);
    }
}
