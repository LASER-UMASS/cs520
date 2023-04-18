package view;

import model.Player;
import model.RowGameModel;

import javax.swing.JPanel;
import javax.swing.JTextArea;


/**
 * The GameStatusView class visualizes the game status as either in progress,
 * current player's turn, or finished, either win or tie.
 *
 * NOTE) For the Composite design pattern, this class is-a Component (i.e. View).
 */
public class GameStatusView implements View
{
    private JTextArea playerturn = new JTextArea();

    
    public GameStatusView(JPanel messages) {
	super();

	// This is a View but not a Controller
	this.playerturn.setEditable(false);
	
	messages.add(this.playerturn);
    }

    public void update(RowGameModel model) {
	// Since the game is still in progress, the current player should be shown.
	if (model.getFinalResult() == null) {
	    if (Player.PLAYER_1.equals(model.getPlayer())) {
		this.playerturn.setText("Player " + Player.PLAYER_1 + " to play 'X'");
	    }
	    else {
		playerturn.setText("Player " + Player.PLAYER_2 + " to play 'O'");
	    }
	}
	// Since the game is over (either win or tie), the final result should be shown.
	else {
	    this.playerturn.setText(model.getFinalResult());
	}
    }
}
