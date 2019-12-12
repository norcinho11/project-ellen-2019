package sk.tuke.kpi.oop.game.characters;


import sk.tuke.kpi.gamelib.framework.AbstractActor;
import sk.tuke.kpi.gamelib.graphics.Animation;
import sk.tuke.kpi.oop.game.Keeper;
import sk.tuke.kpi.oop.game.Movable;
import sk.tuke.kpi.oop.game.items.Backpack;
import sk.tuke.kpi.oop.game.weapons.Firearm;

import static sk.tuke.kpi.gamelib.graphics.Animation.PlayMode.LOOP_PINGPONG;

public class Ripley extends AbstractActor implements Movable, Keeper, Alive,Armed {
    private int ammo;
    private Backpack myBackpack;
    private Health ripleysHealth;

    public Ripley() {
        super("Ellen");
        ammo = 0;

        Animation playerAnimation = new Animation("sprites/player.png", 32, 32, 0.1f, LOOP_PINGPONG);
        setAnimation(playerAnimation);
        ripleysHealth = new Health(100, 100);
        myBackpack = new Backpack("Ripley's backpack", 10);
        this.stoppedMoving();
    }


    @Override
    public int getSpeed() {
        return 2;
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

    @Override
    public int getHealth() {
        return ripleysHealth.getValue();
    }

    @Override
    public Firearm getFirearm() {
        return null;
    }

    @Override
    public void setFirearm(Firearm weapon) {

    }
}
