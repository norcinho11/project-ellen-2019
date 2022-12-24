package sk.tuke.kpi.oop.game.behaviours;

import sk.tuke.kpi.gamelib.actions.ActionSequence;
import sk.tuke.kpi.gamelib.actions.Invoke;
import sk.tuke.kpi.gamelib.actions.Wait;
import sk.tuke.kpi.gamelib.framework.actions.Loop;
import sk.tuke.kpi.oop.game.Direction;
import sk.tuke.kpi.oop.game.Movable;
import sk.tuke.kpi.oop.game.actions.Move;

import java.util.Random;


public class RandomlyMoving implements Behaviour<Movable> {
    private Movable movable;
    public RandomlyMoving(){

    }
    @Override
    public void setUp(Movable actor) {
        if(actor == null){
            return;
        }
         this.movable=actor;
        new Loop<>(
            new ActionSequence<>(new Invoke<>(this::makeRandomDir),
                new Wait<>(2.0f))
        ).scheduleFor(movable);
    }
    private void makeRandomDir(){
        if(movable != null){
        Direction[] directions =Direction.values();
        Move<Movable> move = new Move<>(directions[new Random().nextInt(Direction.values().length-1)],2.0f );
        move.scheduleFor(movable);
    }
}
}
