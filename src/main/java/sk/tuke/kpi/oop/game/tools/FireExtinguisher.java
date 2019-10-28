package sk.tuke.kpi.oop.game.tools;

import org.jetbrains.annotations.NotNull;
import sk.tuke.kpi.gamelib.graphics.Animation;
import sk.tuke.kpi.oop.game.tools.BreakableTool;

public class FireExtinguisher extends BreakableTool {

    private Animation myextinguisher;

    void removeFromScene(@NotNull Animation animation) {
    }

    public FireExtinguisher() {
        myextinguisher = new Animation("sprites/reactor_extinguished.png");

        setAnimation(myextinguisher);
        super.remainingUses=1;
        //super.use(1);
        //if(super.use(0)){
          //  removeFromScene(myextinguisher);
            //return;
        //}

    }

}

