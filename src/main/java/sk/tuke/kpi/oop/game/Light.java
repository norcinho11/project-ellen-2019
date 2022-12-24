package sk.tuke.kpi.oop.game;

import sk.tuke.kpi.gamelib.framework.AbstractActor;
import sk.tuke.kpi.gamelib.graphics.Animation;

public class Light extends AbstractActor implements Switchable,EnergyConsumer {
    private Animation light_on;
    private Animation light_off;
    private boolean electricityFlow;
    private boolean IsLightning;


    public Light() {
        electricityFlow = false;
        IsLightning = false;
        light_on = new Animation("sprites/light_on.png");
        light_off = new Animation("sprites/light_off.png");
        setAnimation(light_off);

    }
    private void changeLightAnimation(){
        if(this.getAnimation()==light_off && this.electricityFlow){
            setAnimation(light_on);
            return;
        }
        if(!this.electricityFlow){
            setAnimation(light_off);
        }
        setAnimation(light_off);
    }

    public boolean isElectricityFlow() {
        return this.electricityFlow;
    }


    @Override
    public void turnOn() {
        this.IsLightning = true;
        if(this.electricityFlow) {
            setAnimation(light_on);
        }
    }

    @Override
    public void turnOff() {
        this.IsLightning = false;
        setAnimation(light_off);
    }
    void toggle() {
        this.IsLightning = !this.IsLightning;
        changeLightAnimation();
    }


    @Override
    public boolean isOn() {
        if(this.IsLightning){
            return true;
        }
        return false;
    }

    @Override
    public void setPowered(boolean isOn) {
        this.electricityFlow = isOn;
        if(!this.electricityFlow && this.IsLightning){
            setAnimation(light_off);
        }
        if(this.IsLightning && this.electricityFlow && (getAnimation() != light_on)){
            setAnimation(light_on);
        }
    }

}
