package sk.tuke.kpi.oop.game.tools;

import sk.tuke.kpi.gamelib.graphics.Animation;
import sk.tuke.kpi.oop.game.Reactor;


public class Mjolnir extends Hammer {

    public Mjolnir(){
    super.setRemainingUses(4);
        Animation hammerAnimation = new Animation("sprites/hammer.png");
        setAnimation(hammerAnimation);
}

    @Override
    public void useWith(Reactor actor) {
        if(actor==null){
            return;
        }
        super.useWith(actor);
    }
}
