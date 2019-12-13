package sk.tuke.kpi.oop.game.weapons;

import org.jetbrains.annotations.NotNull;
import sk.tuke.kpi.gamelib.Actor;
import sk.tuke.kpi.gamelib.Scene;
import sk.tuke.kpi.gamelib.actions.Invoke;
import sk.tuke.kpi.gamelib.framework.AbstractActor;
import sk.tuke.kpi.gamelib.framework.actions.Loop;
import sk.tuke.kpi.gamelib.graphics.Animation;
import sk.tuke.kpi.oop.game.Direction;
import sk.tuke.kpi.oop.game.characters.Alive;
import sk.tuke.kpi.oop.game.characters.Ripley;

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

    @Override
    public void addedToScene(@NotNull Scene scene) {
        super.addedToScene(scene);
        new Loop<>(
            new Invoke<>(this::destroyEnemy)
        ).scheduleFor(this);
    }
    private void destroyEnemy(){
        for(Actor actor : getScene().getActors()){
            if((actor instanceof Alive && !(actor instanceof Ripley))&& actor.intersects(this)){
                ((Alive) actor).getHealth().drain(10);
                getScene().cancelActions(this);
                getScene().removeActor(this);
                break;
            }
        }
    }
}
