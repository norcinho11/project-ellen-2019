package sk.tuke.kpi.oop.game;

import org.jetbrains.annotations.NotNull;
import sk.tuke.kpi.gamelib.Scene;
import sk.tuke.kpi.gamelib.framework.AbstractActor;
import sk.tuke.kpi.gamelib.graphics.Animation;
import sk.tuke.kpi.oop.game.actions.PerpetualReactorHeating;
import java.util.HashSet;
import java.util.Set;

public class Reactor extends AbstractActor implements Switchable, Repairable {

    private int temperature;
    private int damage;
    private Animation normalReactor;
    private Animation hotReactor;
    private Animation brokenReactor;
    private Animation defaultReactor;
    private Animation extinguisherAnimation;
    private Animation extinguishedReactor;
    private EnergyConsumer device;
    private boolean isOn;
    private Set<EnergyConsumer>devices;

    public int getDamage() {
        return this.damage;
    }

    public int getTemperature() {
        return this.temperature;
    }

    public Reactor() {
        temperature = 0;
        damage = 0;
        isOn = false;
       devices = new HashSet<>();
        defaultReactor = new Animation("sprites/reactor.png");
        normalReactor = new Animation("sprites/reactor_on.png", 80, 80, 0.1f, Animation.PlayMode.LOOP_PINGPONG);
        hotReactor = new Animation("sprites/reactor_hot.png", 80, 80, 0.05f, Animation.PlayMode.LOOP_PINGPONG);
        brokenReactor = new Animation("sprites/reactor_broken.png", 80, 80, 0.1f, Animation.PlayMode.LOOP_PINGPONG);
        extinguishedReactor = new Animation("sprites/reactor_extinguished.png");
        extinguisherAnimation = new Animation("sprites/extinguisher.png");
        updateAnimation();
        setAnimation(defaultReactor);
    }

    public void increaseTemperature(int increment) {
        int temperature;
        if (!this.isOn) {
            return;
        }
        int newIncrement;
        newIncrement = Math.max(0, increment);

        if (this.damage < 33) {
            this.temperature += newIncrement;
        } else if (this.damage < 66) {
            this.temperature += Math.ceil(newIncrement * 1.5);
        } else {
            this.temperature += (newIncrement * 2);
        }
        if(this.temperature>=6000 && damage !=100){
            this.damage=100;
            turnOff();
            for(EnergyConsumer device : devices){
                device.setPowered(false);
            }
        }
            if (this.temperature > 2000) {
            temperature = this.temperature - 2000;
            this.normalReactor.setFrameDuration(this.normalReactor.getFrameDuration()+0.015f); // locate this to teh right position
            this.damage = Math.min((int) (temperature / 40), 100);
        }
        updateAnimation();
    }

    public void decreaseTemperature(int decrement) {
        if(!this.isOn){
            return;
        }
        int newDecrement;
        newDecrement = Math.max(0, decrement);
        if (this.isOn) {
            if (this.damage < 50) {
                this.temperature -= newDecrement;
            } else if (this.damage < 100) {
                this.temperature -= (newDecrement / 2);
            }
            if (this.temperature < 0) {
                this.temperature = 0;
            }
            if (this.temperature <= 4000) {
                updateAnimation();
            }
        }

    }

    private void updateAnimation() {
        if (this.temperature < 4000) {
            setAnimation(normalReactor);
        } else if (this.temperature >= 4000 && this.temperature < 6000) {
            setAnimation(hotReactor);
        } else if(this.temperature>=6000){
            this.damage=100;
            turnOff();
            setAnimation(brokenReactor);
        }
    }
@Override
    public boolean repair() {
    if(!isOn){
        return false;
    }
        if (this.damage >= 0 && this.damage < 100) {
            if (this.damage > 50) {
                this.damage -= 50;
                this.temperature = (this.damage * 40) + 2000;
            }
        } else if (this.damage <= 50) {
            this.damage = 0;
            this.temperature = 2000;
        }
        else if(this.damage==100) {
            return false;
        }
            else if(this.damage==0){
                return false;
        }
        updateAnimation();
            return true;
    }


    public void turnOn() {
        this.isOn = true;
        setAnimation(normalReactor);
        if (this.damage == 100) {
            turnOff();
        }
        for(EnergyConsumer device:devices){
            device.setPowered(true);
        }
    }

    public void turnOff() {

        this.isOn = false;
        setAnimation(defaultReactor);
        if (this.damage == 100) {
            setAnimation(brokenReactor);
            //make sure temp/damage wont be changeable

        }
        for (EnergyConsumer device:devices){
            device.setPowered(false);
        }

    }


    public boolean isOn() {
        return isOn;
    }

    public void addDevice(EnergyConsumer device) {//add more devices, meh
                   devices.add(device);

            if (this.device == null) {
                return;

        }
        for (EnergyConsumer myDevice : devices) {
            if (this.isOn) {
                this.device = myDevice;
                myDevice.setPowered(this.isOn());
            }
            if (!this.isOn) {
                myDevice.setPowered(false);
                return;
            }
//shit+f6 ... refactor
        }
    }

    public void removeDevice(EnergyConsumer device) {
                if (this.device == null) {
            return;

        }
        for (EnergyConsumer myDevice : devices) {
            if (this.isOn) {
                this.device = myDevice;
                myDevice.setPowered(false);
            }
            if (!this.isOn) {
                myDevice.setPowered(false);
                return;
            }
            devices.remove(device);
        }
    }

    public boolean extinguish() {
        setAnimation(extinguisherAnimation);
        this.temperature -= 4000;
        setAnimation(extinguishedReactor);
        if(this.damage !=100){
            return false;
        }
        return true;
    }

    @Override
    public void addedToScene(@NotNull Scene scene) {
        super.addedToScene(scene);
        new PerpetualReactorHeating(1).scheduleFor(this);
    }
}
