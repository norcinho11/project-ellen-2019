package sk.tuke.kpi.oop.game;

import sk.tuke.kpi.gamelib.Actor;
import sk.tuke.kpi.gamelib.actions.ActionSequence;
import sk.tuke.kpi.gamelib.actions.Invoke;
import sk.tuke.kpi.gamelib.actions.Wait;
import sk.tuke.kpi.gamelib.actions.When;
import sk.tuke.kpi.gamelib.graphics.Animation;


import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class
ChainBomb extends TimeBomb {


    private Set<ChainBomb> listOfChainBombs;
    private float timeToDetonation;
    private Animation bombActivated;
    private Animation small_explosion;

    public ChainBomb(float timeToDetonation) {
        super(timeToDetonation);
        this.timeToDetonation = timeToDetonation;
        listOfChainBombs= new HashSet<>();
        bombActivated = new Animation("sprites/bomb_activated.png", 16, 16, 0.2f, Animation.PlayMode.LOOP_PINGPONG);
        small_explosion = new Animation("sprites/small_explosion.png", 16, 16, 0.2f, Animation.PlayMode.ONCE);
    }


    private void collectBombs() {
        List<Actor> listOfActors = getScene().getActors();
        for (Actor actor : listOfActors) {
            if (actor instanceof ChainBomb) {
                listOfChainBombs.add((ChainBomb) actor);
            }
        }
    }

    public void activate () {
        super.activate();
        collectBombs();
        setAnimation(bombActivated);
        new ActionSequence<>(
            new Wait<>(timeToDetonation),
            new Invoke<>(this::createWayToDetonation)
        ).scheduleFor(this);
        new When<>(
            ()-> (small_explosion.getCurrentFrameIndex()==7)
            ,new Invoke<>(() -> getScene().removeActor(this)))
            .scheduleFor(this);

    }

    private void createWayToDetonation(){
        setAnimation(small_explosion);
        float centerPosY=(this.getPosY()-50f+8f);
        float centerPosX=(this.getPosX()-50f+8f);

        Ellipse2D areaOfBomb = new Ellipse2D.Float(centerPosX, centerPosY, (2.0f*50.0f), (2.0f*50.0f));

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
