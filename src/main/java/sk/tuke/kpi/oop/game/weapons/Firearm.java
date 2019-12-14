package sk.tuke.kpi.oop.game.weapons;

public abstract class Firearm {
    private int myMaxAmmo;
    private int currentAmmo;

    public Firearm(int initAmmo, int maxAmmo) {
        this.myMaxAmmo = maxAmmo;
        this.currentAmmo = initAmmo;
    }

    abstract protected Fireable createBullet();

    public Firearm(int initAmmo) {
        this.myMaxAmmo = initAmmo;
        currentAmmo = initAmmo;
    }

    public int getAmmo() {
        return this.currentAmmo;
    }

    public void setAmmo(int currentAmmo) {
        this.currentAmmo = currentAmmo;
    }

    public void reload(int newAmmo) {
        if (this.currentAmmo + newAmmo > this.myMaxAmmo) {
            this.currentAmmo = this.myMaxAmmo;
            return;
        }
        this.currentAmmo += newAmmo;
    }

    public Fireable fire() {
        if (currentAmmo != 0) {
            currentAmmo--;
            return createBullet();
        }
        return null;
    }

    public int getMyMaxAmmo() {
        return myMaxAmmo;
    }
}
