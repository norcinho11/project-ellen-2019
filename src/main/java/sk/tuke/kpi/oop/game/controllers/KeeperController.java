package sk.tuke.kpi.oop.game.controllers;

import org.jetbrains.annotations.NotNull;
import sk.tuke.kpi.gamelib.Actor;
import sk.tuke.kpi.gamelib.Input;
import sk.tuke.kpi.gamelib.KeyboardListener;
import sk.tuke.kpi.oop.game.Keeper;
import sk.tuke.kpi.oop.game.actions.Drop;
import sk.tuke.kpi.oop.game.actions.Shift;
import sk.tuke.kpi.oop.game.actions.Take;
import sk.tuke.kpi.oop.game.actions.Use;
import sk.tuke.kpi.oop.game.items.Usable;

public class KeeperController implements KeyboardListener {

    private Keeper actor;

    public KeeperController(Keeper keeper) {
        this.actor = keeper;

    }

    @Override
    public void keyPressed(@NotNull Input.Key key) {
       switch (key) {
            case ENTER: {
                new Take<Keeper>().scheduleFor(actor);
                break;
            }
            case S: {
                //shift
                new Shift<Keeper>().scheduleFor(actor);
                break;
            }
            case BACKSPACE: {
                //drop
                new Drop<Keeper>().scheduleFor(actor);
                break;
            }
            case U: {
                for (Actor item : actor.getScene().getActors() ){
                    if (item instanceof Usable && item.intersects(actor)) {
                        new Use<>((Usable<?>) item).scheduleForIntersectingWith(actor);
                        break;
                    }
                }
            }
          // case B: {
              // 2.11

           //}
           default:   return;
        }
    }
}
