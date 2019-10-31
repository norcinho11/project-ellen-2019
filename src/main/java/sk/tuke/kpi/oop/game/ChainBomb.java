package sk.tuke.kpi.oop.game;

import org.jetbrains.annotations.NotNull;
import sk.tuke.kpi.gamelib.Scene;

import java.awt.geom.Ellipse2D;

public class ChainBomb extends TimeBomb {
    public ChainBomb(float timeToDetonation) {
        super(timeToDetonation);
    }

    @Override
    public void addedToScene(@NotNull Scene scene) {
        super.addedToScene(scene);
    }
    public void location(){
        Ellipse2D.Float chain1=new Ellipse2D.Float(getPosX(), getPosY(), getWidth(), getHeight());
    }
    public void activateAllChainBomb(){
        if(this== getScene().getFirstActorByType(TimeBomb.class)){

        }
    }

    @Override
    public void activate() {
        super.activate();
    }

}
