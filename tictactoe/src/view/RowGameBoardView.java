package view;

import javax.swing.JButton;

import model.RowGameModel;

public class RowGameBoardView {
    public JButton[][] blocks = new JButton[3][3];

    public void update(RowGameModel gameModel, int row, int column) {
        blocks[row][column].setText(gameModel.blocksData[row][column].getContents());
        blocks[row][column].setEnabled(gameModel.blocksData[row][column].getIsLegalMove());
    }

}
