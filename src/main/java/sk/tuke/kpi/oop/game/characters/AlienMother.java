package sk.tuke.kpi.oop.game.characters;

import sk.tuke.kpi.gamelib.graphics.Animation;

public class AlienMother extends Alien {
    public AlienMother(){
        Health health= new Health(200, 200);
        Animation alienAnimation = new Animation("sprites/mother.png",112,162,0.2f);
        setAnimation(alienAnimation);
    }
}
