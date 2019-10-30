package sk.tuke.kpi.oop.game.tools;

import sk.tuke.kpi.gamelib.graphics.Animation;
import sk.tuke.kpi.oop.game.DefectiveLight;

public class Wrench extends BreakableTool<DefectiveLight> {

    public Wrench(int remainingUses) {
        super(remainingUses);
        setRemainingUses(2);
        if (this == null) {
            return;
        }
        Animation wrenchAnimation = new Animation("sprites/wrench.png");
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

