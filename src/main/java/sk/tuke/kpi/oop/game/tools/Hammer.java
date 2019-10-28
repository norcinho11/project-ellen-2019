package sk.tuke.kpi.oop.game.tools;

import org.jetbrains.annotations.NotNull;
import sk.tuke.kpi.gamelib.Scene;
import sk.tuke.kpi.gamelib.graphics.Animation;
import sk.tuke.kpi.oop.game.tools.BreakableTool;

public class Hammer extends BreakableTool {
    private Animation hammerAnimation;


    public Hammer() {

        super.remainingUses=1;
        hammerAnimation = new Animation("sprites/hammer.png");
        setAnimation(hammerAnimation);
    }
}

