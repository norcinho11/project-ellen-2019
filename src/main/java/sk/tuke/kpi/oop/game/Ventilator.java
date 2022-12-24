package sk.tuke.kpi.oop.game;

import sk.tuke.kpi.gamelib.framework.AbstractActor;
import sk.tuke.kpi.gamelib.graphics.Animation;
import sk.tuke.kpi.gamelib.messages.Topic;

public class Ventilator extends AbstractActor implements Repairable {
    private Animation ventilatorAnimation;
    private boolean isRepairing;
    public static final Topic<Ventilator>VENTILATOR_REPAIRED = Topic.create("ventilator is repaired", Ventilator.class);

    public Ventilator(){
        isRepairing=false;
     ventilatorAnimation   = new Animation("sprites/ventilator.png",32,32,0.1f);

        setAnimation(ventilatorAnimation);
        ventilatorAnimation.stop();
    }
    @Override
    public boolean repair() {
        if(isRepairing){
            return false;
        }
        ventilatorAnimation.play();
        getScene().getMessageBus().publish(VENTILATOR_REPAIRED,this);
        return true;
    }
}
