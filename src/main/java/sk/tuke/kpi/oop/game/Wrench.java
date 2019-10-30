package sk.tuke.kpi.oop.game;

import sk.tuke.kpi.gamelib.Actor;
import sk.tuke.kpi.gamelib.graphics.Animation;
import sk.tuke.kpi.oop.game.tools.BreakableTool;

public class Wrench extends BreakableTool<DefectiveLight> {
    private Animation wrenchAnimation;

    public Wrench(int remainingUses) {
        super(remainingUses);
        setRemainingUses(2);
        if (this == null) {
            return;
        }
        wrenchAnimation = new Animation("sprites/wrench.png");
        setAnimation(wrenchAnimation);
    }

    @Override
    public void useWith(DefectiveLight light) {
        if (light == null) {
            return;
        }
        if (light.repair()) {
            super.useWith(light);
        }
    }
}

