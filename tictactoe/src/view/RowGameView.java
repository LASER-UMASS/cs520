package view;

import model.RowGameModel;


/**
 * The RowGameView interface provides a visualization of the 
 * RowGameModel.
 *
 * This is part of the Composite design pattern, specifically
 * the Component. It is also part of the Observer design pattern,
 * specifically the Observer.
 */
public interface RowGameView
{
    public void update(RowGameModel gameModel);
}
