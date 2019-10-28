package sk.tuke.kpi.oop.game.tools;

import org.jetbrains.annotations.NotNull;
import sk.tuke.kpi.gamelib.graphics.Animation;

public class Mjolnir extends BreakableTool {
    private Animation hammerAnimation;

public Mjolnir(){
    super.remainingUses=4;
    hammerAnimation = new Animation("sprites/hammer.png");
}
}
