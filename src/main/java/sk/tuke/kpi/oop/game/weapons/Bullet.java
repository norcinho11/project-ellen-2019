package sk.tuke.kpi.oop.game.weapons;

import sk.tuke.kpi.gamelib.framework.AbstractActor;
import sk.tuke.kpi.gamelib.graphics.Animation;
import sk.tuke.kpi.oop.game.Direction;

public class Bullet extends AbstractActor implements Fireable {
    public Bullet(){
        Animation bulletAnimation = new Animation("sprites/bullet.png",16,16);
        setAnimation(bulletAnimation);
    }

    @Override
    public int getSpeed() {
        return 4;
    }

    @Override
    public void startedMoving(Direction direction) {
        //getDirection
        }

    @Override
    public void collidedWithWall() {
        getScene().removeActor(this);
    }
}
