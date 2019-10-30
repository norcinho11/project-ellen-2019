package sk.tuke.kpi.oop.game;

import org.jetbrains.annotations.NotNull;
import sk.tuke.kpi.gamelib.Scene;
//import sk.tuke.kpi.gamelib.actions.Invoke;
//import sk.tuke.kpi.gamelib.actions.When;
//import sk.tuke.kpi.gamelib.framework.actions.Loop;

public class SmartCooler extends Cooler {
    private Reactor reactor;

    @Override
    public Reactor getReactor() {
        return reactor;
    }

    public SmartCooler(Reactor reactor) {
        super(reactor);

    }

    public void coolReactor(){
        if(isOn()){
            //this.reactor=this.getReactor();
            super.getReactor().decreaseTemperature(1);
        }
    }


    @Override
    public void addedToScene(@NotNull Scene scene) {
        super.addedToScene(scene);
        if(super.getReactor()==null) {
            return;
        }
          //if (super.getReactor() != null) {
          //      new When<Reactor>(getReactor().getTemperature()>2500,this::coolReactor).scheduleFor(this);
          //     new Loop<>(new Invoke<Reactor>(this::coolReactor)).scheduleFor(super.getReactor());
           // }
            if (super.getReactor().getTemperature() <= 0) {
                return;
            }
            if (super.getReactor().getTemperature() > 2500) {
                this.turnOn();
            }
            if (super.getReactor().getTemperature() < 1500) {
                this.turnOff();
            }

//        }
}
}
