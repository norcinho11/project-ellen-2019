package sk.tuke.kpi.oop.game;

import org.jetbrains.annotations.NotNull;
import sk.tuke.kpi.gamelib.Scene;

public class SmartCooler extends Cooler {
    private Reactor reactor;

    @Override
    public Reactor getReactor() {
        return reactor;
    }

    public SmartCooler(Reactor reactor) {
        super(reactor);

    }

    @Override
    public void addedToScene(@NotNull Scene scene) {
        super.addedToScene(scene);
        if(this==null){
            return;
        }
        if(super.getReactor()==null) {
            return;
        }
            if(super.getReactor().getTemperature()>6000){
                return;
        }
        if(super.getReactor().getTemperature()<=0){
            return;
        }
     if(super.getReactor().getTemperature()>2500){
         this.turnOn();
     }
     if(super.getReactor().getTemperature()<1500){
         this.turnOff();
     }
     if(isOn()){
         this.getReactor().decreaseTemperature(1);
     }
     if (!isOn()){
         this.turnOff();
     }
    }


}
