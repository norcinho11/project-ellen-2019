package sk.tuke.kpi.oop.game;


import sk.tuke.kpi.gamelib.actions.Invoke;
import sk.tuke.kpi.gamelib.framework.AbstractActor;
import sk.tuke.kpi.gamelib.framework.Player;
import sk.tuke.kpi.gamelib.framework.actions.Loop;
import sk.tuke.kpi.gamelib.graphics.Animation;

public class Helicopter extends AbstractActor {
    private Player player;

    public Player getPlayer() {
        return player;
    }

    public Helicopter() {

        Animation helicopterAnimation = new Animation("sprites/heli.png", 64, 64, 0.12f);
        setAnimation(helicopterAnimation);
    }

    public void searchAndDestroy() {
        this.player = getScene().getFirstActorByType(Player.class);
        if (this.player == null) {
            return;
        }
        new Loop<>(new Invoke<>(this::helpSearching)).scheduleFor(this);
    }


    private void helpSearching() {
       // while (player.getPosition().getX() != this.getPosition().getX() && player.getPosition().getY() != this.getPosition().getY()) {  //ctrl+q ..doc
            if (this.getPosition().getX() < player.getPosition().getX()) {
                this.setPosition(getPosX() + 1, getPosY());
            }
            if (this.getPosition().getY() < player.getPosition().getY()) {
                this.setPosition(getPosX(), getPosY() + 1);
                //find out how to get nearby the helicopter
            }
        if (this.getPosition().getX() > player.getPosition().getX()) {
            this.setPosition(getPosX() - 1, getPosY());
        }
        if (this.getPosition().getY() > player.getPosition().getY()) {
            this.setPosition(getPosX(), getPosY() - 1);
                 }
            if (player.getPosition().getX() == this.getPosition().getX() && player.getPosition().getY() == this.getPosition().getY()) {
                player.setEnergy(player.getEnergy() - 1);
            }
       // }
    }
}
