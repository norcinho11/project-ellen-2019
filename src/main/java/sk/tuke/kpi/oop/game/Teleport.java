package sk.tuke.kpi.oop.game;


import org.jetbrains.annotations.NotNull;
import sk.tuke.kpi.gamelib.Actor;
import sk.tuke.kpi.gamelib.Scene;
import sk.tuke.kpi.gamelib.framework.AbstractActor;
import sk.tuke.kpi.gamelib.framework.Player;
import sk.tuke.kpi.gamelib.graphics.Animation;

public class Teleport extends AbstractActor {
    private Animation teleportAnimation;
    private Teleport destinationTeleport;
    private Player player;

    public Teleport(Teleport destinationTeleport) {
        teleportAnimation = new Animation("sprites/lift.png", 48, 48);
        setAnimation(teleportAnimation);
        this.player = player;
        Teleport teleport = this;
        if (this.destinationTeleport == null) {
            return;
            //  teleportPlayer(this.player);
        }

        // this.destinationTeleport=destinationTeleport;

    }

    @Override
    public void addedToScene(@NotNull Scene scene) {
        super.addedToScene(scene);
        scene.getFirstActorByName("Player");
    }

    @Override
    public boolean intersects(@NotNull Actor actor) {
        return super.intersects(actor);
    }

    public Teleport getDestination() {
        return destinationTeleport;
    }

    public void setDestination(Teleport destinationTeleport) {
        this.destinationTeleport = destinationTeleport;
    }

    public void teleportPlayer(Player player) {
        if ((this.player.getPosition().getY() == this.getPosition().getY()) && (this.player.getPosition().getX() == this.getPosition().getX())) {
            this.player.setPosition(destinationTeleport.getPosX(), destinationTeleport.getPosY());
        }
    }
}
