package sk.tuke.kpi.oop.game;

import sk.tuke.kpi.gamelib.framework.AbstractActor;
import sk.tuke.kpi.gamelib.graphics.Animation;
import sk.tuke.kpi.gamelib.graphics.Color;

public class PowerSwitch extends AbstractActor {
    private Switchable device;


    public PowerSwitch(Switchable device) {
        Animation switchAnimation = new Animation("sprites/switch.png");
        setAnimation(switchAnimation);
        this.device=device;
    }

public Switchable getDevice() {
    return this.device;

}
public void switchOn() {
 if(this.device==null){
     return;
 }
        this.device.turnOn();
 getAnimation().setTint(Color.WHITE);

}

public void switchOff(){
    if(this.device==null) {
        return;
    }
            this.device.turnOff();
    getAnimation().setTint(Color.GRAY);
        }

}




