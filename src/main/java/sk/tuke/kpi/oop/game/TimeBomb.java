package sk.tuke.kpi.oop.game;

import sk.tuke.kpi.gamelib.framework.AbstractActor;
import sk.tuke.kpi.gamelib.graphics.Animation;

public class TimeBomb extends AbstractActor {
    private Animation bombBeforeExplAnimation;
    private Animation flashBombAnimation;
    //private  Animation detonationBomb;
    private boolean isBombActivated;

    public TimeBomb(float timeToDetonation) {
        isBombActivated = false;
       // detonationBomb = new Animation("sprites/small_explosion.png");
        flashBombAnimation = new Animation("sprites/bomb_activated.png");
        bombBeforeExplAnimation = new Animation("sprites/bomb.png");
        setAnimation(bombBeforeExplAnimation);


    }

    public void activate() {

    }

    public boolean isActivated() {
        if (isBombActivated) {
            return true;
        }
        return false;
    }
}
