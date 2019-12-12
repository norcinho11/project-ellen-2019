package sk.tuke.kpi.oop.game.actions;

import sk.tuke.kpi.gamelib.Actor;
import sk.tuke.kpi.gamelib.framework.actions.AbstractAction;
import sk.tuke.kpi.oop.game.Keeper;
import sk.tuke.kpi.oop.game.items.Collectible;



public class Take <K extends Keeper> extends AbstractAction<K> {
  private   Collectible collectibleActor;

    /**
     * Executes (one step of) the action. Called by the scene this
     * action was scheduled on, prior to rendering.
     *
     * @param deltaTime time passed from the previous execution
     */
    @Override
    public void execute(float deltaTime) {
        if(getActor()==null){
            return;
        }
      setDone(true);
        try {
            for (Actor actor : getActor().getScene().getActors()) {
                if(actor instanceof Collectible && getActor().intersects(actor)) {
                    collectibleActor = (Collectible) actor;
                    return;
                }
            }
            getActor().getBackpack().add(collectibleActor);
            getActor().getScene().removeActor(collectibleActor);

        } catch (Exception ex) {
            getActor().getScene().getOverlay().drawText(ex.getMessage(), 100, 200).showFor(2);
        }
    }
}
