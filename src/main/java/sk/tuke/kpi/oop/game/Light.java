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
        if(this.IsLightning && this.isElectricityFlow()){
            setAnimation(light_on);
        }
        if(!this.IsLightning && this.isElectricityFlow()){
            setAnimation(light_off);
        }
}

    public boolean isElectricityFlow() {
        return this.electricityFlow;
    }


    @Override
    public void turnOn() {
            this.IsLightning = true;
            this.electricityFlow=true;
          changeLightAnimation();
    }

    @Override
    public void turnOff() {
            this.IsLightning = false;
            this.electricityFlow=true;
            changeLightAnimation();
    }

    void toogle() {
        if (this.electricityFlow && !this.IsLightning) {
           if(this.electricityFlow){
               return;
            }
            turnOn();
        } if(this.electricityFlow && this.IsLightning){
            if(!this.electricityFlow) {
                return;
            }
            turnOff();
        }
    }

    @Override
    public boolean isOn() {
        if(this.IsLightning==true){
            return true;
        }
        return false;
    }

    @Override
    public void setPowered(boolean isOn) {
            this.electricityFlow = isOn;

        }

    }
