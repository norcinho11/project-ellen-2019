package sk.tuke.kpi.oop.game.characters;

import sk.tuke.kpi.gamelib.framework.AbstractActor;
import sk.tuke.kpi.gamelib.graphics.Animation;
import sk.tuke.kpi.oop.game.Keeper;
import sk.tuke.kpi.oop.game.Movable;
import sk.tuke.kpi.oop.game.items.Backpack;

import static sk.tuke.kpi.gamelib.graphics.Animation.PlayMode.LOOP_PINGPONG;

public class Ripley extends AbstractActor implements Movable, Keeper {
    Animation playerAnimation;
    private int energy;
    private int ammo;
    private Backpack myBackpack;

    public Ripley() {
        super("Ellen");
        energy = 100;
        ammo = 0;
        playerAnimation = new Animation("sprites/player.png", 32, 32, 0.1f, LOOP_PINGPONG);
        setAnimation(playerAnimation);
        myBackpack = new Backpack("Ripley's backpack", 10);
        this.stoppedMoving();
    }


    @Override
    public int getSpeed() {
        return 2;
    }

    public int getEnergy() {
        return energy;
    }

    public void setEnergy(int energy) {
        this.energy = energy;
        if (energy > 100 || energy < 0) {
            return;
        }
    }

    public int getAmmo() {
        return ammo;
    }

    public void setAmmo(int ammo) {
        this.ammo = ammo;
        if (ammo > 500 || ammo < 0) {
            return;
        }

    }

    @Override
    public Backpack getBackpack() {
        return this.myBackpack;
    }

    public void showRipleyState(){
        //meh  1.7
    }

}//3.4
