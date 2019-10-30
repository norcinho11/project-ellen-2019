package sk.tuke.kpi.oop.game;

import org.jetbrains.annotations.NotNull;
import sk.tuke.kpi.gamelib.Scene;
import sk.tuke.kpi.gamelib.actions.Invoke;
import sk.tuke.kpi.gamelib.framework.actions.Loop;

public class DefectiveLight extends Light implements Repairable {
    private boolean isRepairing;
    private float save;

    public Light getLight() {
        return this;
    }

    public DefectiveLight(){
        if(super.isElectricityFlow()==false){
            return;
        }
        isRepairing=false;


    }

    private double randomNumber(double min, double max){
        double newMax=Math.floor(max);
        double newMin=Math.ceil(min);
        return Math.floor(Math.random() * (newMax - newMin)) + newMin;
}
public void myLightOnOff(){
    if(isRepairing){
        if(!super.isElectricityFlow()){
            return;
        }
        this.save -=0.0166;

        if(this.save<0){
            isRepairing=false;
        }
        return;
    }
        if(randomNumber(0, 20)==1){

            //super.setElectricityFlow(true || false);
            this.toggle();
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
        if(isRepairing){
            return false;
        }
        isRepairing=true;
        save=10f;
        this.turnOn();
        return true;
    }
}


