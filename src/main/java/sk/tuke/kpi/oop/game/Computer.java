package sk.tuke.kpi.oop.game;

import sk.tuke.kpi.gamelib.framework.AbstractActor;
import sk.tuke.kpi.gamelib.graphics.Animation;

public class Computer extends AbstractActor implements EnergyConsumer{

    private Animation computerAnimation;
    private boolean isComputerOn;


    public Computer() {
        isComputerOn=false;
        computerAnimation = new Animation("sprites/computer.png", 80, 48, 0.2f, Animation.PlayMode.LOOP_PINGPONG);
        setAnimation(computerAnimation);

    }

    public int add(int x, int y) {
        if (isComputerOn) {
            return x + y;
        }
        return 0;
    }
    public float add(float x, float y) {
        if (isComputerOn) {
            return x + y;
        }

            return 0;
    }

    public int sub(int x, int y) {
        if (isComputerOn) {
            return x - y;
        }
        return 0;
    }

    public float sub(float x, float y) {
        if (isComputerOn) {
            return x - y;
        }
        return 0;
    }

    @Override
    public void setPowered(boolean isOn) {
    if(isOn){
        computerAnimation.stop();
    }
    else {
        computerAnimation.play();

        isComputerOn = true;
    }
    }
}
