package view;

import model.RowGameModel;
import controller.RowGameController;

import javax.swing.JPanel;
import java.awt.event.*;
import javax.swing.JButton;


/**
 * The GameStatusView class visualizes the game status as either in progress,
 * current player's turn, or finished, either win or tie.
 *
 * NOTE) For the Composite design pattern, this class is-a Component (i.e. View).
 */
public class UndoFunctionality implements View
{
    public JButton undo = new JButton("Undo");

    public UndoFunctionality(JPanel options, RowGameController controller) {
	super();

	options.add(undo);

    undo.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {
        controller.undoGame();
        }
    });
    }

    public void update(RowGameModel model) {
    //Undo should be enabled only when there are moves left to play
        if(model.isThereMoveToUndo() || model.getFinalResult()!=null) {
            this.undo.setEnabled(false);
        } else {
            this.undo.setEnabled(true);
        }
    }
}
