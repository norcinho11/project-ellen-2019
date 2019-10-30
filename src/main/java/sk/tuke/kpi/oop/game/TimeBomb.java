package sk.tuke.kpi.oop.game;

import sk.tuke.kpi.gamelib.framework.AbstractActor;
import sk.tuke.kpi.gamelib.graphics.Animation;

public class TimeBomb extends AbstractActor {
    private Animation bombBeforeExplAnimation;
    private float timeToDetonation;
    private Animation flashBombAnimation;
    private  Animation detonationBomb;
    private boolean isBombActivated;

    public TimeBomb(float timeToDetonation) {

        isBombActivated = false;
        detonationBomb = new Animation("sprites/small_explosion.png",16,16,0.5f, Animation.PlayMode.ONCE);
        flashBombAnimation = new Animation("sprites/bomb_activated.png",16,16,0.5f,Animation.PlayMode.ONCE);
        bombBeforeExplAnimation = new Animation("sprites/bomb.png",16,16);
        setAnimation(bombBeforeExplAnimation);


    }

    public void activate() {
        if(!isBombActivated){
            setAnimation(flashBombAnimation);
            timeToDetonation -=0.0166f;
        }
        if(timeToDetonation<=0f){
            setAnimation(detonationBomb);
        }
    }

    public boolean isActivated() {
        if (isBombActivated) {
            return true;
        }
        return false;
    }
}
