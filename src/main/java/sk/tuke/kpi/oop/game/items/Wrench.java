package sk.tuke.kpi.oop.game.items;

import sk.tuke.kpi.gamelib.graphics.Animation;
import sk.tuke.kpi.oop.game.DefectiveLight;

public class Wrench extends BreakableTool<DefectiveLight> implements Collectible {

    public Wrench() {
        super(2);
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
    /*            this.setRemainingUses(this.getRemainingUses()-1);
                return;
            }
            if(this.getRemainingUses()==0){
                getScene().removeActor(this);
                return;
        }

*/
}

    @Override
    public Class<DefectiveLight> getUsingActorClass() {
        return DefectiveLight.class;
    }
}

