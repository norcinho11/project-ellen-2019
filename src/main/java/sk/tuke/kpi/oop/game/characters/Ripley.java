package sk.tuke.kpi.oop.game.characters;


import org.jetbrains.annotations.NotNull;
import sk.tuke.kpi.gamelib.Scene;
import sk.tuke.kpi.gamelib.framework.AbstractActor;
import sk.tuke.kpi.gamelib.graphics.Animation;
import sk.tuke.kpi.gamelib.messages.Topic;
import sk.tuke.kpi.oop.game.Keeper;
import sk.tuke.kpi.oop.game.Movable;
import sk.tuke.kpi.oop.game.items.Backpack;
import sk.tuke.kpi.oop.game.weapons.Firearm;

import static sk.tuke.kpi.gamelib.graphics.Animation.PlayMode.LOOP_PINGPONG;
import static sk.tuke.kpi.gamelib.graphics.Animation.PlayMode.ONCE;

public class Ripley extends AbstractActor implements Movable, Keeper, Alive,Armed {
    private int ammo;
    private Backpack myBackpack;
    private Health ripleysHealth;
    private Firearm weapon;
    public static final Topic<Ripley>RIPLEY_DIED =Topic.create("Ripley died hahaha" , Ripley.class);


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
    public Health getHealth() {
        return ripleysHealth;
    }

    @Override
    public Firearm getFirearm() {
        return this.weapon;
    }

    @Override
    public void setFirearm(Firearm weapon) {
        this.weapon= weapon;
    }

    @Override
    public void addedToScene(@NotNull Scene scene) {
        super.addedToScene(scene);
        ripleysHealth.onExhaustion(() ->{
            getScene().cancelActions(this);
            Animation deathAnimation = new Animation("sprites/player_die.png",32,32,0.1f,ONCE);
            setAnimation(deathAnimation);
            deathAnimation.play();
            getScene().getMessageBus().publish(RIPLEY_DIED, this);
        });
    }
}
