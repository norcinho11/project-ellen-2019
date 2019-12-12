package sk.tuke.kpi.oop.game.characters;

import org.jetbrains.annotations.NotNull;
import sk.tuke.kpi.gamelib.Scene;
import sk.tuke.kpi.gamelib.framework.AbstractActor;
import sk.tuke.kpi.gamelib.graphics.Animation;
import sk.tuke.kpi.oop.game.Movable;

public class Alien extends AbstractActor implements Movable,Enemy,Alive {
  public Alien(){
      Animation alienAnimation = new Animation("sprites/alien.png",32,32,0.1f);
      setAnimation(alienAnimation);

  }

    @Override
    public int getSpeed() {
        return 0;
    }

    @Override
    public int getHealth() {
        return 0;
    }

    @Override
    public void addedToScene(@NotNull Scene scene) {
        //if(){

        //}
    }
}
