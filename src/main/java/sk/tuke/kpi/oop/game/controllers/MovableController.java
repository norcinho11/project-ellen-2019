package sk.tuke.kpi.oop.game.controllers;

import org.jetbrains.annotations.NotNull;
import sk.tuke.kpi.gamelib.Input;
import sk.tuke.kpi.gamelib.KeyboardListener;
import sk.tuke.kpi.oop.game.Direction;
import sk.tuke.kpi.oop.game.Movable;
import sk.tuke.kpi.oop.game.actions.Move;

import java.util.Map;
import java.util.Set;

public class MovableController implements KeyboardListener {
    private Movable actor;
    private Move movementStorage;
    private Input.Key defaultKey;
    private float max = Float.MAX_VALUE;

    public Movable getActor() {
        return actor;
    }

    public MovableController(Movable actor){
        this.actor=actor;

    }
    private  Map<Input.Key, Direction> keyDirectionMap = Map.ofEntries(
        Map.entry(Input.Key.UP, Direction.NORTH),
        Map.entry(Input.Key.DOWN,Direction.SOUTH),
        Map.entry(Input.Key.RIGHT, Direction.WEST),
        Map.entry(Input.Key.LEFT, Direction.EAST)
    );
    private Set<Direction> defaultDirections = Set.of(Direction.EAST,Direction.NORTH,Direction.WEST,Direction.SOUTH);


    @Override
    public void keyPressed(@NotNull Input.Key key) {
        //System.out.println(key);
        if(keyDirectionMap.containsKey(key)){
            if(this.defaultKey==null){
                this.defaultKey=key;
            }
            if(movementStorage != null){
                movementStorage.stop();
            }
            movementStorage= new Move(keyDirectionMap.get(key).combine(keyDirectionMap.get(defaultKey)), max);
            movementStorage.scheduleFor(actor);

        }


    }


    @Override
    public void keyReleased(@NotNull Input.Key key) {

        if(keyDirectionMap.containsKey(key)){
            movementStorage.stop();
            actor.getScene().cancelActions(actor);

            if(this.defaultKey==key){
                this.defaultKey=null;
            }
            if(defaultDirections.contains(movementStorage.getDirection())) {
                return;
            }
            else {
                for (Input.Key unknownKey : keyDirectionMap.keySet()) {
                    if(keyDirectionMap.get(key).combine(keyDirectionMap.get(unknownKey)).equals(movementStorage.getDirection())) {
                        this.defaultKey = unknownKey;
                        break;
                    }
                }
                movementStorage = new Move(keyDirectionMap.get(defaultKey), max);
                movementStorage.scheduleFor(actor);
            }
        }

    }
}

