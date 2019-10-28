package sk.tuke.kpi.oop.game.tools;

import sk.tuke.kpi.gamelib.framework.AbstractActor;
import sk.tuke.kpi.oop.game.Usable;

public abstract class BreakableTool<T extends AbstractActor> extends AbstractActor implements Usable<T> {

    private int remainingUses;


    public int getRemainingUses(){
        return this.remainingUses;
    }
     public BreakableTool(int remainingUses){
        this.remainingUses=remainingUses;


     }

    @Override
    public void useWith(T actor) {
        if(this.remainingUses>0){
            this.remainingUses--;
        }
        else if(this.remainingUses==0){
            getScene().removeActor(this);
            return;
        }
    }
}
