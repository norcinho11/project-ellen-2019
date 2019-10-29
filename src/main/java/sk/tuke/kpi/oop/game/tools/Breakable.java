package sk.tuke.kpi.oop.game.tools;

import sk.tuke.kpi.gamelib.graphics.Animation;
import sk.tuke.kpi.oop.game.Reactor;

public class Breakable extends BreakableTool<Reactor> {


    public Breakable() {
        super(1);
        Animation myextinguisher = new Animation("sprites/reactor_extinguished.png");

        setAnimation(myextinguisher);

    }

    @Override
    public void useWith(Reactor actor) {
        if(actor == null){
            return;}
        int uses = this.getRemainingUses();
        if(uses>0){

            this.setRemainingUses(uses-1);
        }
        else if(uses==0){
            getScene().removeActor(this);
            return;
        }
    }
}

