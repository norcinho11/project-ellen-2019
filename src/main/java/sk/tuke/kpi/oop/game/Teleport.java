package sk.tuke.kpi.oop.game;

import sk.tuke.kpi.gamelib.framework.AbstractActor;
import sk.tuke.kpi.gamelib.framework.Player;
import sk.tuke.kpi.gamelib.graphics.Animation;

public class Teleport extends AbstractActor {
    private Animation teleportAnimation;
    private Teleport destinationTeleport;
    public Teleport(Teleport destinationTeleport){
        teleportAnimation= new Animation("sprites/lift.png",48,48);
        setAnimation(teleportAnimation);
        this.destinationTeleport=destinationTeleport;

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
