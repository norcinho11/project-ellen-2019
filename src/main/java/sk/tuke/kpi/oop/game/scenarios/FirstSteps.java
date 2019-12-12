package sk.tuke.kpi.oop.game.scenarios;

import org.jetbrains.annotations.NotNull;
import sk.tuke.kpi.gamelib.GameApplication;
import sk.tuke.kpi.gamelib.Scene;
import sk.tuke.kpi.gamelib.SceneListener;
import sk.tuke.kpi.oop.game.characters.Ripley;
import sk.tuke.kpi.oop.game.controllers.KeeperController;
import sk.tuke.kpi.oop.game.controllers.MovableController;
import sk.tuke.kpi.oop.game.items.Ammo;
import sk.tuke.kpi.oop.game.items.Backpack;

public class FirstSteps implements SceneListener {
    private Ripley ripley;
    public FirstSteps(){

    }

    @Override
    public void sceneInitialized(@NotNull Scene scene) {

        this.ripley = new Ripley();
        KeeperController keeperController = new KeeperController(ripley);
        scene.getInput().registerListener(keeperController);
        scene.addActor(ripley, 0, 0);
        MovableController movController = new MovableController(ripley);
        scene.getInput().registerListener(movController);
        Ammo ammo = new Ammo();
        scene.addActor(ammo, 100, 100);


        }

    @Override
    public void sceneUpdating(@NotNull Scene scene) {
        int windowHeight = scene.getGame().getWindowSetup().getHeight();
        int yTextPos = windowHeight - GameApplication.STATUS_LINE_OFFSET;
        scene.getGame().getOverlay().drawText("Energy : ", 156,yTextPos);
        scene.getGame().getOverlay().drawText(Integer.toString(ripley.getHealth()), 256,yTextPos);

        scene.getGame().getOverlay().drawText("Ammo : ", 356,yTextPos);
        scene.getGame().getOverlay().drawText(Integer.toString(ripley.getAmmo()), 456,yTextPos);
        Backpack backpack = new Backpack("Ripley's backpack",3);
        scene.getGame().pushActorContainer(backpack);
    }
}
