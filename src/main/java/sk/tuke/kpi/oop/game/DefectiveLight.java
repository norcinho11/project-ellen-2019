package sk.tuke.kpi.oop.game;

import org.jetbrains.annotations.NotNull;
import sk.tuke.kpi.gamelib.Scene;
import sk.tuke.kpi.gamelib.actions.Invoke;
import sk.tuke.kpi.gamelib.framework.actions.Loop;

public class DefectiveLight extends Light implements Repairable {
    //private Light light;

    public Light getLight() {
        return this;
    }

    public DefectiveLight(){



    }

    private double randomNumber(double min, double max){
        max=Math.floor(max);
        min=Math.ceil(min);
        int number =20;
        return Math.floor(Math.random() * (max - min)) + min;
}
public void myLightOnOff(){
        if(randomNumber(0, 20)==1){
            //super.setElectricityFlow(true || false);
            this.switchLight();
        }
}

    @Override
    public void addedToScene(@NotNull Scene scene) {
        super.addedToScene(scene);
        //new Invoke<>(this::myLightOnOff).scheduleFor(this);
        new Loop<>(new Invoke<>(this::myLightOnOff)).scheduleFor(this);
    }

    @Override
    public boolean repair() {
        return false;
    }
}


