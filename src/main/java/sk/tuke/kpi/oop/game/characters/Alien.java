package sk.tuke.kpi.oop.game.characters;

import org.jetbrains.annotations.NotNull;
import sk.tuke.kpi.gamelib.Actor;
import sk.tuke.kpi.gamelib.Scene;
import sk.tuke.kpi.gamelib.actions.ActionSequence;
import sk.tuke.kpi.gamelib.actions.Invoke;
import sk.tuke.kpi.gamelib.actions.Wait;
import sk.tuke.kpi.gamelib.actions.When;
import sk.tuke.kpi.gamelib.framework.AbstractActor;
import sk.tuke.kpi.gamelib.framework.actions.Loop;
import sk.tuke.kpi.gamelib.graphics.Animation;
import sk.tuke.kpi.oop.game.Movable;
import sk.tuke.kpi.oop.game.behaviours.Behaviour;

public class Alien extends AbstractActor implements Movable,Enemy,Alive {
    private Health health;
    private Behaviour<? super Alien> behaviour;
    private  Animation alienAnimation = new Animation("sprites/alien.png",32,32,0.1f);

    public Alien(){
        setAnimation(alienAnimation);
        alienAnimation.stop();
        this.health = new Health(50, 50);
    }

  public Alien(int newHealth,Behaviour<? super Alien> behaviour){
      setAnimation(alienAnimation);
      alienAnimation.stop();
      this.health = new Health(newHealth, newHealth);
    this.behaviour=behaviour;

  }

    @Override
    public int getSpeed() {
        return 1;
    }

    @Override
    public Health getHealth() {
        return this.health;
    }

    @Override
    public void addedToScene(@NotNull Scene scene) {
        super.addedToScene(scene);
        if (behaviour == null) {
            return;
        } else {
            this.behaviour.setUp(this);
        }

            for (Actor actor : scene.getActors()) {
                if ((!(actor instanceof Enemy) )&& actor instanceof Alive) {
                    damagingRipley((Alive) actor);
                }
        }
    }
    public void damagingRipley(Alive alive){
        new Loop<>(new ActionSequence<>(
            new When<>(()->alive.intersects(this),
                new Invoke<>(()->alive.getHealth().drain(1))),
            new Wait<>(0.065f))).scheduleFor(this);
    }
}
