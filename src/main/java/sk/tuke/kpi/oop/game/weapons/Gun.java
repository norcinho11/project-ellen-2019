package sk.tuke.kpi.oop.game.weapons;

public class Gun extends Firearm {
    public Gun(int initialAmmo, int maximumAmmo) {
        super(initialAmmo, maximumAmmo);
    }
        @Override
            protected Fireable makeBullet(){
            return new Bullet();
        }
}
