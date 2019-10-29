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
        if(super.getReactor()==null){
            return;
        }
     if(super.getReactor().getTemperature()>2500){
         super.turnOn();
     }
     if(super.getReactor().getTemperature()<1500){
         super.turnOff();
     }
     if(isOn()){
         this.getReactor().decreaseTemperature(1);
     }
    }

}
