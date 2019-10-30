package sk.tuke.kpi.oop.game;

import sk.tuke.kpi.gamelib.framework.AbstractActor;
import sk.tuke.kpi.gamelib.framework.Player;
import sk.tuke.kpi.gamelib.graphics.Animation;

public class Teleport extends AbstractActor {
    private Animation teleportAnimation;
    private Teleport destinationTeleport;
    public Teleport(char A){
        teleportAnimation= new Animation("sprites/lift.png");
        setAnimation(teleportAnimation);

    }
    public Teleport getDestination(Teleport destinationTeleport){
        return destinationTeleport;
    }
    public void setDestination(Teleport destinationTeleport){
       this.destinationTeleport=destinationTeleport;
    }
    public void teleportPlayer(Player player){

    }
}
