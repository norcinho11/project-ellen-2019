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
        if(this.IsLightning==true){
            setAnimation(light_on);
        }
        if(this.IsLightning==false){
            setAnimation(light_off);
        }
}

    public boolean isElectricityFlow() {
        return this.electricityFlow;
    }


    @Override
    public void turnOn() {
        if (this.electricityFlow == true && this.IsLightning == false) {
            this.IsLightning = true;
          changeLightAnimation();
        }
    }

    @Override
    public void turnOff() {
        if (this.electricityFlow == true && this.IsLightning == true) {
            this.IsLightning = false;
            changeLightAnimation();
        }
    }

    void toogle() {
        if (this.electricityFlow == true && this.IsLightning == false) {
            this.IsLightning=true;
            setAnimation(light_on);
        } else{
            setAnimation(light_off);
            this.IsLightning=false;
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
