package sk.tuke.kpi.oop.game.tools;

import org.jetbrains.annotations.NotNull;
import sk.tuke.kpi.gamelib.Actor;
import sk.tuke.kpi.gamelib.framework.AbstractActor;
import sk.tuke.kpi.gamelib.graphics.Animation;
import sk.tuke.kpi.oop.game.Usable;

public abstract class BreakableTool extends AbstractActor implements Usable {

    public int remainingUses;
    public Animation breakableTool;
    void removeFromScene(@NotNull Animation animation) {
    };
    public int getRemainingUses(){
        return this.remainingUses;
    }
     protected BreakableTool(){
        remainingUses=1;


     }
public void use(int number){
        this.remainingUses= number;
        if(this.remainingUses>0){
            this.remainingUses--;
        }
        else if(this.remainingUses==0){
            getScene().removeActor(this);
            return;
        }
}

    @Override
    public void useWith(Actor actor) {
    }
}
