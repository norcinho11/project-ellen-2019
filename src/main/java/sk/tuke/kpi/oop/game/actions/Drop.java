package sk.tuke.kpi.oop.game.actions;

import sk.tuke.kpi.gamelib.framework.actions.AbstractAction;
import sk.tuke.kpi.oop.game.Keeper;
import sk.tuke.kpi.oop.game.items.Collectible;

public class Drop <K extends Keeper> extends AbstractAction<K> {
    /**
     * Executes (one step of) the action. Called by the scene this
     * action was scheduled on, prior to rendering.
     *
     * @param deltaTime time passed from the previous execution
     */
    @Override
    public void execute(float deltaTime) {
        if(getActor()==null){
            setDone(true);
            return;
        }
        setDone(true);
        try {


            int posX = getActor().getPosX();
            int posY = getActor().getPosY();
            Collectible item = getActor().getBackpack().peek();
            getActor().getScene().addActor(item, posX, posY);
            getActor().getBackpack().remove(item);

        } catch (Exception ex) {
            getActor().getScene().getOverlay().drawText(ex.getMessage(), 300, 300).showFor(2);

        }
    }
}
