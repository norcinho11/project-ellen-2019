package sk.tuke.kpi.oop.game.weapons;

public abstract class Firearm {
    private int myMaxAmmo;
    private int currentAmmo;
    public Firearm(int initAmmo, int maxAmmo){
        this.myMaxAmmo=maxAmmo;
       this.currentAmmo=initAmmo;
    }
    public Firearm(int initAmmo){
        this.myMaxAmmo=initAmmo;
    }
    public  int getAmmo(){
        return this.currentAmmo;
    }
    public void reload(int newAmmo){
        if(this.currentAmmo + newAmmo > this.myMaxAmmo){
            this.currentAmmo=this.myMaxAmmo;
            return;
        }
        this.currentAmmo +=newAmmo;
    }
}
