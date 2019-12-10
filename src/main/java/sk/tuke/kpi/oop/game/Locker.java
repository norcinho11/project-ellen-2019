package sk.tuke.kpi.oop.game;

import sk.tuke.kpi.gamelib.framework.AbstractActor;
import sk.tuke.kpi.gamelib.graphics.Animation;
import sk.tuke.kpi.oop.game.characters.Ripley;
import sk.tuke.kpi.oop.game.items.Hammer;
import sk.tuke.kpi.oop.game.items.Usable;

public class Locker extends AbstractActor implements Usable<Ripley> {
    public Locker(){
        Animation lockerAnimation = new Animation("sprites/locker.png",16,16);
        setAnimation(lockerAnimation);
    }
    @Override
    public void useWith(Ripley actor) {
    if(actor.intersects(this)){
       getScene().getActors().add(new Hammer());
    }
    }

    @Override
    public Class<Ripley> getUsingActorClass() {
        return Ripley.class;
    }
}
