package sk.tuke.kpi.oop.game;

import sk.tuke.kpi.gamelib.framework.AbstractActor;
import sk.tuke.kpi.gamelib.graphics.Animation;

public class Light extends AbstractActor implements Switchable,EnergyConsumer {
    private Animation light_on;
    private Animation light_off;
    private Reactor reactor;
    private boolean electricityFlow;
    private boolean IsLightning;


    public Light() {
        electricityFlow = false;
        IsLightning = false;
        light_on = new Animation("sprites/light_on.png");
        light_off = new Animation("sprites/light_off.png");
        setAnimation(light_off);

    }


    public boolean getElectricityFlow() {
        return this.electricityFlow;
    }


    @Override
    public void turnOn() {
        if (this.electricityFlow == true && this.IsLightning == false) {
            this.IsLightning = true;
            setAnimation(light_on);
        }
    }

    @Override
    public void turnOff() {
        if (this.electricityFlow == true && this.IsLightning == true) {
            this.IsLightning = false;
            setAnimation(light_off);
        }
    }

    void switchLight() {
        this.IsLightning = !this.IsLightning;
        if (this.electricityFlow == true && this.IsLightning == false) {
            setAnimation(light_on);
        } else{
            setAnimation(light_off);
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
