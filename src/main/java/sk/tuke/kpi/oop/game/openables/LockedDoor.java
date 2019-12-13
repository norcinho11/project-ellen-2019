package sk.tuke.kpi.oop.game.openables;


public class LockedDoor extends Door {
    private boolean isLockedBoolean;
    public LockedDoor(String name, Orientation orientation){
        super(name, orientation); //?!
        isLockedBoolean=true;
    }
    public void lock(){
        isLockedBoolean=true;
        close();
    }
    public void unlock(){
        isLockedBoolean=false;
        open();
    }
    public boolean isLocked(){
        return isLockedBoolean;
    }

}
