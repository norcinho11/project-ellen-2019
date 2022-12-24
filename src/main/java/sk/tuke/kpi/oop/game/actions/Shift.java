package sk.tuke.kpi.oop.game.actions;

import sk.tuke.kpi.gamelib.framework.actions.AbstractAction;
import sk.tuke.kpi.oop.game.Keeper;

public class Shift <K extends Keeper> extends AbstractAction<K> {
    /**
     * Executes (one step of) the action. Called by the scene this
     * action was scheduled on, prior to rendering.
     *
     * @param deltaTime time passed from the previous execution
     */
    @Override
    public void execute(float deltaTime) {
        setDone(true);
        if(getActor()==null){
            return;
        }
        try {

            getActor().getBackpack().shift();
        }
        catch (Exception ex){
            getActor().getScene().getOverlay().drawText("empty", 300, 300).showFor(2);

        }
    }
}
