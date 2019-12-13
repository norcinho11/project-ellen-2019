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

    public enum Orientation{HORIZONTAL(1,0),VERTICAL(0,1);
    private final int dx;
    private final int dy;
    Orientation(int dx,int dy){
        this.dx=dx;
        this.dy=dy;
    }

        public int getDx() {
            return dx;
        }

        public int getDy() {
            return dy;
        }
    }
    private String name;
    private Orientation orientation;
    private boolean isDoorOpen;
    private Animation vdoorAnimation= new Animation("sprites/vdoor.png",16,32,0.1f);
    private Animation hdoorAnimation = new Animation("sprites/hdoor.png",32,16,0.1f);
  private   Animation openedDoorAnimation= new Animation("sprites/vdoor.png",16,32,0.1f, Animation.PlayMode.ONCE);
 private    Animation closedDoorAnimation= new Animation("sprites/vdoor.png",16,32,0.1f, Animation.PlayMode.ONCE_REVERSED);
    public static final Topic<Door> DOOR_OPENED = Topic.create("door opened", Door.class);
    public static final Topic<Door> DOOR_CLOSED = Topic.create("door closed", Door.class);

    public Door(String name,Orientation orientation){
        this.name=name;
        this.orientation=orientation;
        isDoorOpen=false;
        if(orientation == Orientation.HORIZONTAL){
          setAnimation(hdoorAnimation);
          }
        else if(orientation == Orientation.VERTICAL){
            setAnimation(vdoorAnimation);
        }
 }

    @NotNull
    @Override
    public String getName() {
        return name;
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
