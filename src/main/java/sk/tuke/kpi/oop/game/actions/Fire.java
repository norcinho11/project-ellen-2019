package sk.tuke.kpi.oop.game.actions;

import sk.tuke.kpi.gamelib.framework.actions.AbstractAction;
import sk.tuke.kpi.oop.game.Direction;
import sk.tuke.kpi.oop.game.characters.Armed;
import sk.tuke.kpi.oop.game.weapons.Fireable;

public class Fire<A extends Armed> extends AbstractAction<A> {
    public Fire(){

    }
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
        Fireable fireable = getActor().getFirearm().fire();
    if(fireable ==null){
        getActor().getScene().getOverlay().drawText("Out of ammo ! ", 120, 300);
        setDone(true);
        return;
    }
    else {
        Direction directionOfBullet = Direction.fromAngle(270f);
        Move<Fireable> boom = new Move<>(directionOfBullet, 10000000.0f);
        getActor().getScene().addActor(fireable,getActor().getPosX()+(16/2),getActor().getPosY()+(16/2));
        boom.scheduleFor(fireable);
        setDone(true);
    }

    }
}
