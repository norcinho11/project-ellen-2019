package sk.tuke.kpi.oop.game.tools;

import sk.tuke.kpi.gamelib.graphics.Animation;
import sk.tuke.kpi.oop.game.Reactor;

public class Hammer extends BreakableTool<Reactor> {


    public Hammer() {
        super(1);
        if(this==null){
            return;
        }
        Animation hammerAnimation = new Animation("sprites/hammer.png");
        setAnimation(hammerAnimation);
    }

    @Override
    public void useWith(Reactor actor) {
        if(actor.repair()) {
            super.useWith(actor);
        }

    }
}

