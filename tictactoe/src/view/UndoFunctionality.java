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
public class UndoFunctionality implements View
{
    public JButton undo = new JButton("Undo");

    public UndoFunctionality(JPanel options) {
	super();

	options.add(undo);
    undo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                controller.undoMoves();
            }
        });
    }

    public void update(RowGameModel model) {
    //Undo should be enabled only when there are moves left to play
        if(model.lastMovedBlock.matches(-1,-1)) {
            this.undo.setEnabled(false);
        } else {
            this.undo.setEnabled(true);
        }
    }
}
