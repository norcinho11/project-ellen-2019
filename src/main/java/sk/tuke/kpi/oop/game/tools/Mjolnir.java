package sk.tuke.kpi.oop.game.tools;

import sk.tuke.kpi.gamelib.graphics.Animation;


public class Mjolnir extends Hammer {

    public Mjolnir(){
    super.setRemainingUses(4);
        Animation hammerAnimation = new Animation("sprites/hammer.png");
        setAnimation(hammerAnimation);
}
}
