package sk.tuke.kpi.oop.game.items;

import sk.tuke.kpi.gamelib.framework.AbstractActor;
import sk.tuke.kpi.gamelib.graphics.Animation;
import sk.tuke.kpi.oop.game.characters.Armed;

public class Ammo extends AbstractActor implements Usable<Armed> {
    public Ammo() {
        Animation ammoAnimation = new Animation("sprites/ammo.png");
        setAnimation(ammoAnimation);
    }

    @Override
    public void useWith(Armed actor) {
        if (actor.intersects(this)) {
            if (actor.getFirearm().getAmmo() == 500) {
                actor.getFirearm().setAmmo(500);
                return;
            }
            if (actor.getFirearm().getAmmo() < 0) {
                return;
            }
            actor.getFirearm().setAmmo(actor.getFirearm().getAmmo() + 50);
            getScene().removeActor(this);
        }
    }

    @Override
    public Class<Armed> getUsingActorClass() {
        return Armed.class;
    }
}
