package sk.tuke.kpi.oop.game;

import org.jetbrains.annotations.NotNull;
import sk.tuke.kpi.gamelib.Actor;
import sk.tuke.kpi.gamelib.Scene;

//import java.awt.geom.Ellipse2D;
import java.util.List;

public class ChainBomb extends TimeBomb {
    private TimeBomb timeBomb1;
    private TimeBomb timeBomb2;
    public ChainBomb(float timeToDetonation) {
        super(timeToDetonation);
    }
    private List<Actor> listOfActors;
    @Override
    public void addedToScene(@NotNull Scene scene) {
        super.addedToScene(scene);
        this.listOfActors = scene.getActors();

       // Ellipse2D.Float chain1 = new Ellipse2D.Float(timeBomb1.getPosX(), timeBomb1.getPosY(), 50, 50);
      //  Ellipse2D.Float chain2 = new Ellipse2D.Float(timeBomb2.getPosX(), timeBomb2.getPosY(), 50, 50);
   //     if (timeBomb1.isActivated()) {
     //       if (chain1.intersects(timeBomb2.getPosX(), timeBomb2.getPosY(), 50, 50)) {
       //         timeBomb2.activate();
         //   }
       // }
    }
    private void collectBombs(){
        this.listOfActors = getScene().getActors();
        for(Actor actor: listOfActors){
            if(actor==getScene().getFirstActorByType(ChainBomb.class)){
            listOfActors.add((ChainBomb) actor);
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

    }

}
