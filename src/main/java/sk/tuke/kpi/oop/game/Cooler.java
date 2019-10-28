package sk.tuke.kpi.oop.game;

import org.jetbrains.annotations.NotNull;
import sk.tuke.kpi.gamelib.Scene;
import sk.tuke.kpi.gamelib.actions.Invoke;
import sk.tuke.kpi.gamelib.framework.AbstractActor;
import sk.tuke.kpi.gamelib.framework.actions.Loop;
import sk.tuke.kpi.gamelib.graphics.Animation;

public class Cooler extends AbstractActor implements Switchable{
    private Animation coolerAnimation;
    private boolean CoolerState;
    private Reactor reactor;
    public Reactor getReactor() {
        return reactor;
    }

    public Cooler(Reactor reactor){
        CoolerState=false;
        coolerAnimation = new Animation("sprites/fan.png", 32,32,0.0f );
        setAnimation(coolerAnimation);
        this.reactor=reactor;

    }
    @Override
    public void turnOn(){
        if(this.CoolerState==false){
            this.CoolerState=true;
            setAnimation(coolerAnimation);
            this.coolerAnimation.setFrameDuration(0.2f);

        }
    }
    @Override
    public void turnOff(){
        if(this.CoolerState==true){
            this.CoolerState=false;
            setAnimation(coolerAnimation);
            this.coolerAnimation.setFrameDuration(0.0f);
        }
    }
    @Override
    public boolean isOn(){
        return this.CoolerState;
    }

    private void coolReactor(){
        if(isOn()){
            //this.reactor=this.getReactor();
        this.reactor.decreaseTemperature(1);
        }
    }

    @Override
    public void addedToScene(@NotNull Scene scene) {
        super.addedToScene(scene);
       //new Invoke<>(this::coolReactor).scheduleFor(this.reactor);
       new Loop<>(new Invoke<Reactor>(this::coolReactor)).scheduleFor(this.reactor);

    }

}
