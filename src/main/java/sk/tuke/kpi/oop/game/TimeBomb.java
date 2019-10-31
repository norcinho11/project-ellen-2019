package sk.tuke.kpi.oop.game;

import org.jetbrains.annotations.NotNull;
import sk.tuke.kpi.gamelib.Scene;
import sk.tuke.kpi.gamelib.actions.ActionSequence;
import sk.tuke.kpi.gamelib.actions.Invoke;
import sk.tuke.kpi.gamelib.actions.Wait;
import sk.tuke.kpi.gamelib.actions.When;
import sk.tuke.kpi.gamelib.framework.AbstractActor;
import sk.tuke.kpi.gamelib.graphics.Animation;

public class TimeBomb extends AbstractActor {
    private float timeToDetonation;
    private Animation flashBombAnimation;
    private Animation detonationBomb;
    private boolean isBombActivated;

    @Override
    public void removedFromScene(@NotNull Scene scene) {
        super.removedFromScene(scene);
    }

    public TimeBomb(float timeToDetonation) {
        this.timeToDetonation=timeToDetonation;
        isBombActivated = false;
        detonationBomb = new Animation("sprites/small_explosion.png", 16, 16, 0.5f, Animation.PlayMode.ONCE);
        flashBombAnimation = new Animation("sprites/bomb_activated.png",16,16,0.55f,Animation.PlayMode.LOOP);
        Animation bombBeforeExplAnimation = new Animation("sprites/bomb.png", 16, 16);
        setAnimation(bombBeforeExplAnimation);


    }

    public void activate() {
        if (!isActivated()) {
            isBombActivated = true;
            setAnimation(flashBombAnimation);
            //    timeToDetonation -=0.0166f;
                new Wait<>(this.timeToDetonation);
                new Invoke<>(this::helpActivate).scheduleFor(this);

             //   setAnimation(null);
        }
    }
    private void helpActivate(){
        setAnimation(detonationBomb);
        new When<>(()->detonationBomb.getCurrentFrameIndex()==7,new Invoke<>(()->getScene().removeActor(this))).scheduleFor(this);
    }
    public boolean isActivated() {
        if (isBombActivated) {
            return true;
        }
        return false;
    }
}
