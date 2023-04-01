package view;

import model.RowGameModel;

/**
 * The View interfaces supports updating the visualizations of the Model.
 *
 * NOTE) For the Composite design pattern, the View interface is the Component interface.
 */
public interface View
{
    public void update(RowGameModel model);
}
