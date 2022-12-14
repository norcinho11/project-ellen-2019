package sk.tuke.kpi.oop.game.scenarios;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import sk.tuke.kpi.gamelib.Actor;
import sk.tuke.kpi.gamelib.ActorFactory;
import sk.tuke.kpi.gamelib.Scene;
import sk.tuke.kpi.gamelib.SceneListener;
import sk.tuke.kpi.oop.game.Locker;
import sk.tuke.kpi.oop.game.Ventilator;
import sk.tuke.kpi.oop.game.characters.Ripley;
import sk.tuke.kpi.oop.game.controllers.KeeperController;
import sk.tuke.kpi.oop.game.controllers.MovableController;
import sk.tuke.kpi.oop.game.items.AccessCard;


public class MissionImpossible implements SceneListener {

    @Override
    public void sceneInitialized(@NotNull Scene scene) {
        Ripley ripley;
        ripley = scene.getFirstActorByType(Ripley.class);
        MovableController movableController = new MovableController(ripley);
        KeeperController keeperController = new KeeperController(ripley);
        scene.follow(ripley);
        scene.getInput().registerListener(movableController);
        scene.getInput().registerListener(keeperController);
    }

    public static class Factory implements ActorFactory {
        public @Nullable Actor create(String type, String name) {
            switch (name) {
                case "ellen":
                    return new Ripley();
                case "access card":
                    return new AccessCard();
                case "ventilator":
                    return new Ventilator();
                case "locker":
                    return new Locker();
                default:
                    return null;
            }

        }
    }
}
