package sk.tuke.kpi.oop.game.scenarios;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import sk.tuke.kpi.gamelib.*;
import sk.tuke.kpi.oop.game.characters.AlienMother;
import sk.tuke.kpi.oop.game.characters.Ripley;
import sk.tuke.kpi.oop.game.controllers.KeeperController;
import sk.tuke.kpi.oop.game.controllers.MovableController;
import sk.tuke.kpi.oop.game.items.Backpack;

public class EscapeRoom implements SceneListener {
  private   Ripley ripley;
    @Override
    public void sceneInitialized(@NotNull Scene scene) {
        scene.follow(scene.getFirstActorByType(Ripley.class));
        this.ripley = scene.getFirstActorByType(Ripley.class);
        KeeperController keeperController = new KeeperController(ripley);
        scene.getInput().registerListener(keeperController);
        scene.addActor(ripley, 150, 150);
        MovableController movController = new MovableController(ripley);
        scene.getInput().registerListener(movController);
        System.out.println(scene.getFirstActorByType(Ripley.class));
    }

    @Override
    public void sceneUpdating(@NotNull Scene scene) {
        int windowHeight = scene.getGame().getWindowSetup().getHeight();
        int yTextPos = windowHeight - GameApplication.STATUS_LINE_OFFSET;
        scene.getGame().getOverlay().drawText("Health : ", 156,yTextPos);
        scene.getGame().getOverlay().drawText(Integer.toString(ripley.getHealth()), 256,yTextPos);

        scene.getGame().getOverlay().drawText("Ammo : ", 356,yTextPos);
        scene.getGame().getOverlay().drawText(Integer.toString(ripley.getAmmo()), 456,yTextPos);
        Backpack backpack = new Backpack("Ripley's backpack",3);
        scene.getGame().pushActorContainer(backpack);
    }

    public static class Factory implements ActorFactory {
        /**
         * Factory method for creating an actor based on given {@code type} and {@code name},
         * of which both are optional, but at least one should be given.
         *
         * @param type
         * @param name
         */
        @Override
        public @Nullable Actor create(@Nullable String type, @Nullable String name) {

            switch (name) {
                case "ellen":
                    return new Ripley();
                case "alien mother":
                    return new AlienMother();
                default:
                    return null;
            }
        }

    }
}
