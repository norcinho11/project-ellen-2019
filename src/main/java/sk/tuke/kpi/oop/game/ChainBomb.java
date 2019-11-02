package sk.tuke.kpi.oop.game;

import sk.tuke.kpi.gamelib.Actor;
import sk.tuke.kpi.gamelib.actions.Invoke;
import sk.tuke.kpi.gamelib.actions.When;


import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ChainBomb extends TimeBomb {


    private Set<ChainBomb> listOfChainBombs;

    public ChainBomb(float timeToDetonation) {
        super(timeToDetonation);
        this.listOfChainBombs= new HashSet<>();

    }


    private void collectBombs() {
        List<Actor> listOfActors = (List<Actor>) getScene().getActors();
        for (Actor actor : listOfActors) {
            if (actor instanceof ChainBomb) {
                listOfChainBombs.add((ChainBomb) actor);

            }
            }
        }
        public void activate () {
            super.activate();
            collectBombs();
            new When<>(
                ()-> (this.getAnimation().getCurrentFrameIndex()==7)
                     ,new Invoke<>(this::createWayToDetonation))
                    .scheduleFor(this);

        }

    private void createWayToDetonation(){
        float centerPosY=(this.getPosY()-50f+8f);
        float centerPosX=(this.getPosX()-50f+8f);

    Ellipse2D areaOfBomb = new Ellipse2D.Float(getPosX(), getPosY(), (2.0f*50.0f), (2.0f*50.0f));

    for(ChainBomb chainBomb:listOfChainBombs){
        float myChainBombPosY=(float)chainBomb.getPosY();
        float myChainBombPosX=(float)chainBomb.getPosX();

        Rectangle2D areaToIntersectWith = new Rectangle2D.Float(myChainBombPosX, myChainBombPosY, 16.0f, 16.0f);
        if((!chainBomb.equals(this)) && areaOfBomb.intersects(areaToIntersectWith)){
            chainBomb.activate();
        }
    }
    }

    }
