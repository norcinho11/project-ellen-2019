package sk.tuke.kpi.oop.game;

import sk.tuke.kpi.gamelib.Actor;

public interface Movable extends Actor {
    default void collidedWithWall() {

    }
    int getSpeed();

    default void startedMoving(Direction direction){
        getAnimation().play();
        getAnimation().setRotation(direction.getAngle());
        //System.out.println(direction.getAngle());
    };
    default void stoppedMoving(){
        getAnimation().stop();
    };

}
