package sk.tuke.kpi.oop.game.openables;

import org.jetbrains.annotations.NotNull;
import sk.tuke.kpi.gamelib.Actor;
import sk.tuke.kpi.gamelib.Scene;
import sk.tuke.kpi.gamelib.framework.AbstractActor;
import sk.tuke.kpi.gamelib.graphics.Animation;
import sk.tuke.kpi.gamelib.map.MapTile;
import sk.tuke.kpi.gamelib.messages.Topic;
import sk.tuke.kpi.oop.game.items.Usable;

public class Door extends AbstractActor implements Openable, Usable<Actor> {
 private boolean isDoorOpen;
  private   Animation openedDoorAnimation= new Animation("sprites/vdoor.png",16,32,0.1f, Animation.PlayMode.ONCE);
 private    Animation closedDoorAnimation= new Animation("sprites/vdoor.png",16,32,0.1f, Animation.PlayMode.ONCE_REVERSED);
    public static final Topic<Door> DOOR_OPENED = Topic.create("door opened", Door.class);
    public static final Topic<Door> DOOR_CLOSED = Topic.create("door closed", Door.class);

    public Door(){
        setAnimation(closedDoorAnimation);

        isDoorOpen=false;
 }

    @Override
    public void useWith(Actor actor) {

    }

    @Override
    public Class<Actor> getUsingActorClass() {
        return Actor.class;
    }

    @Override
    public void open() {
        isDoorOpen=true;
        setAnimation(openedDoorAnimation);
        getScene().getMap().getTile((getPosX()/16), (getPosY()/16)).setType(MapTile.Type.CLEAR);
        getScene().getMap().getTile((getPosX()/16), (getPosY()/16)+1).setType(MapTile.Type.CLEAR);
        getScene().getMessageBus().publish(DOOR_OPENED, this);
    }

    @Override
    public void close() {
        isDoorOpen=false;
        setAnimation(closedDoorAnimation);
        getScene().getMap().getTile((getPosX()/16), (getPosY()/16)).setType(MapTile.Type.WALL);
        getScene().getMap().getTile((getPosX()/16), (getPosY()/16)+1).setType(MapTile.Type.WALL);
        getScene().getMessageBus().publish(DOOR_CLOSED, this);
    }

    @Override
    public boolean isOpen() {
        return isDoorOpen;
    }

    @Override
    public void addedToScene(@NotNull Scene scene) {
        super.addedToScene(scene);
        getScene().getMap().getTile((getPosX()/16), (getPosY()/16)).setType(MapTile.Type.WALL);
        getScene().getMap().getTile((getPosX()/16), (getPosY()/16)+1).setType(MapTile.Type.WALL);

    }
}
