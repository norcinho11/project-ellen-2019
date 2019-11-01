package sk.tuke.kpi.oop.game;


import org.jetbrains.annotations.NotNull;
import sk.tuke.kpi.gamelib.Scene;
import sk.tuke.kpi.gamelib.actions.Invoke;
import sk.tuke.kpi.gamelib.framework.AbstractActor;
import sk.tuke.kpi.gamelib.framework.Player;
import sk.tuke.kpi.gamelib.framework.actions.Loop;
import sk.tuke.kpi.gamelib.graphics.Animation;

public class Teleport extends AbstractActor {
    private Teleport destination;
    private boolean avaibleToTeleport;
    private  Animation teleportAnimation;
    public Teleport getDestination(){
        return destination;
    }

    public void setDestination(Teleport destinationTeleport){
        if(this == destinationTeleport){ return;}
            this.destination = destinationTeleport; }

    @Override
    public void addedToScene(@NotNull Scene scene) {
        super.addedToScene(scene);
        new Loop<>(new Invoke<>(this::teleportPlayer)).scheduleFor(getScene().getFirstActorByType(Player.class));
    }



    public Teleport(Teleport teleport){
        teleportAnimation = new Animation("sprites/lift.png");
        setAnimation(teleportAnimation);
        this.setDestination(teleport);
    }

    public void teleportPlayer(Player player){
        if(this != this.destination && (this.destination != null)){
            if(this.avaibleToTeleport && (!this.intersects(player))){
                this.avaibleToTeleport = false;
            }

            if(this.intersects(player) && !this.avaibleToTeleport){
                getDestination().avaibleToTeleport = true;
                player.setPosition(getDestination().getPosX() + (getDestination().getWidth()/2) - (player.getWidth()/2), getDestination().getPosY() + (getDestination().getHeight()/2) - (player.getHeight()/2));
            }
        }
    }
}




