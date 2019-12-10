package sk.tuke.kpi.oop.game.items;

import sk.tuke.kpi.gamelib.graphics.Animation;
import sk.tuke.kpi.oop.game.Repairable;


public class Mjolnir extends Hammer {

    public Mjolnir(){
    super.setRemainingUses(4);
        Animation hammerAnimation = new Animation("sprites/hammer.png");
        setAnimation(hammerAnimation);
}

    @Override
    public void useWith(Repairable actor) {
        if(actor==null){
            return;
        }
        super.useWith(actor);
    }
}
