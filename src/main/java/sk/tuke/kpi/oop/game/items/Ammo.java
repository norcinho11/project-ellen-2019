package sk.tuke.kpi.oop.game.items;

import sk.tuke.kpi.gamelib.framework.AbstractActor;
import sk.tuke.kpi.gamelib.graphics.Animation;
import sk.tuke.kpi.oop.game.characters.Armed;
import sk.tuke.kpi.oop.game.characters.Ripley;
import sk.tuke.kpi.oop.game.weapons.Firearm;

public class Ammo extends AbstractActor implements Usable<Ripley>, Armed {
   public Ammo(){
       Animation ammoAnimation = new Animation("sprites/ammo.png");
       setAnimation(ammoAnimation);
   }
    @Override
    public void useWith(Ripley actor) {
if(actor.intersects(this)){
    if(actor.getAmmo()== 500){
        actor.setAmmo(500);
        return;
    }
    if(actor.getAmmo()<0){
        return;
    }
    actor.setAmmo(actor.getAmmo()+50);
    getScene().removeActor(this);
}
    }

    @Override
    public Class<Ripley> getUsingActorClass() {
        return Ripley.class;
    }

    @Override
    public Firearm getFirearm() {
        return null;
    }

    @Override
    public void setFirearm(Firearm weapon) {

    }
}
