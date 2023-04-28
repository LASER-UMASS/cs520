package view;

import controller.RowGameController;
import model.RowGameModel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;


public class UndoViewController implements View
{
    private JButton undo;

    
    public UndoViewController(JPanel parent, RowGameController controller) {
	super();

	this.undo = new JButton("Undo");
	parent.add(this.undo);

	// This is the Controller aspect.
	this.undo.addActionListener(new ActionListener() {
	   public void actionPerformed(ActionEvent e) {
	       controller.undo();
	   }
        });
    }

    public void update(RowGameModel model) {
	// This is the View aspect.
	//
	// In the initial configuration, undo is not allowed
	if (model.movesLeft == 9) {
	    this.undo.setEnabled(false);
	}
	// If the game is finished (either win or tie), undo is not allowed
	else if (model.getFinalResult() != null) {
	    this.undo.setEnabled(false);
	}
	// If neither of the above, undo is allowed
	else {
	    this.undo.setEnabled(true);
	}
    }
}
