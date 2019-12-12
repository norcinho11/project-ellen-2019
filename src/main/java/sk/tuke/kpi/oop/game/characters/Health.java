package sk.tuke.kpi.oop.game.characters;



public class Health {
    @FunctionalInterface
    public interface ExhaustionEffect {
        void apply();
    }
    private int myInitHealth;
   private int myMaxHealth;
   private int currentHealth;
    public Health(int initHealth, int maxHealth){
        this.myInitHealth=initHealth;
        this.myMaxHealth=maxHealth;
    }
    public Health(int initHealth){
        myMaxHealth=initHealth;
    }
    public int getValue(){
        return this.currentHealth;
    }
   public void refill(int amount){
        if(amount +currentHealth >myMaxHealth){
            return;
        }
       currentHealth += amount;
    }
    public void restore(){
        this.currentHealth= this.myMaxHealth;
    }
    public void drain(int mount){
        if(currentHealth - mount <0){
            return;
        }
        currentHealth -= mount;
    }
    public void exhaust(){
        currentHealth =0;
    }
    public void onExhaustion(ExhaustionEffect effect){


        }
    }
