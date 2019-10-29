package sk.tuke.kpi.oop.game.tools;

import sk.tuke.kpi.gamelib.Actor;
import sk.tuke.kpi.gamelib.framework.AbstractActor;

public abstract class BreakableTool<T extends Actor> extends AbstractActor implements Usable<T> {

    public void setRemainingUses(int remainingUses) {
        this.remainingUses = remainingUses;
    }

    private int remainingUses;


    public int getRemainingUses(){
        return this.remainingUses;
    }
     public BreakableTool(int remainingUses){
        this.remainingUses=remainingUses;


     }

    @Override
    public void useWith(T actor) {
        if(this.getRemainingUses()>0){
            this.setRemainingUses(this.getRemainingUses()-1);
        }
        if(this.getRemainingUses()==0){
            getScene().removeActor(this);
            return;
        }
    }
}
