package sk.tuke.kpi.oop.game;

import sk.tuke.kpi.gamelib.framework.AbstractActor;
import sk.tuke.kpi.gamelib.graphics.Animation;

public class Light extends AbstractActor implements Switchable,EnergyConsumer {
    private Animation light_on;
    private Animation light_off;
    private boolean electricityFlow;
    private boolean IsLightning;


    public Light() {
        electricityFlow = true;
        IsLightning = false;
        light_on = new Animation("sprites/light_on.png");
        light_off = new Animation("sprites/light_off.png");
        setAnimation(light_off);

    }
private void changeLightAnimation(){
        if(this.IsLightning && this.electricityFlow){
            setAnimation(light_on);
        }
        if(this.IsLightning && !this.electricityFlow){
            setAnimation(light_off);
            return;
        }
        else setAnimation(light_off);
}

    public boolean isElectricityFlow() {
        return this.electricityFlow;
    }


    @Override
    public void turnOn() {
        if(!this.isElectricityFlow()){
            return;
        }
            this.IsLightning = true;
          changeLightAnimation();         }



    @Override
    public void turnOff() {
            this.IsLightning = false;
            changeLightAnimation();
    }
    void toggle() {
        this.IsLightning = !this.IsLightning;
        changeLightAnimation();
    }


    @Override
    public boolean isOn() {
        if(this.IsLightning==true && this.electricityFlow){
            return true;
        }
        return false;
    }

    @Override
    public void setPowered(boolean isOn) {
        this.electricityFlow = isOn;
        if(this.IsLightning && this.electricityFlow){
            setAnimation(light_on);
        }
        else setAnimation(light_off);

        }

    }
