package sk.tuke.kpi.oop.game;

import org.jetbrains.annotations.NotNull;
import sk.tuke.kpi.gamelib.Actor;
import sk.tuke.kpi.gamelib.Scene;

import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.util.HashSet;
import java.util.List;

public class ChainBomb extends TimeBomb {

    private Rectangle2D.Float area;
    private Ellipse2D.Float area2;
    private List<ChainBomb>listOfChainBombs;

    public ChainBomb(float timeToDetonation) {
        super(timeToDetonation);
        area= new Rectangle2D.Float(this.getPosX(), this.getPosY(), this.getWidth(), getHeight());
        float areaPosX=(float) this.area.getX();
        float areaPosY=(float) this.area.getY();
        area2 = new Ellipse2D.Float(areaPosY,areaPosX,50,50);
    }

    @Override
    public void addedToScene(@NotNull Scene scene) {
        super.addedToScene(scene);


    }
    private void collectBombs(){
        List<Actor> listOfActors = (List<Actor>) getScene().getActors();
        for(Actor actor: listOfActors){
            if(actor instanceof ChainBomb){
            listOfChainBombs.add((ChainBomb) actor);
                ChainBomb chainBombb = (ChainBomb) actor;
            if(area2.intersects(chainBombb.area)){
                chainBombb.activate();
            }
            }
        }
    }
    @Override
    public boolean intersects(@NotNull Actor actor) {
        return super.intersects(actor);
    }

    @Override
    public void activate() {
        super.activate();

        collectBombs();
    }

}
