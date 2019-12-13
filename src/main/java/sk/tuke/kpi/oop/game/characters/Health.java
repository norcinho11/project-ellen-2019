package sk.tuke.kpi.oop.game.characters;


import java.util.ArrayList;
import java.util.List;

public class Health {
    @FunctionalInterface
    public interface ExhaustionEffect {
        void apply();
    }
    private boolean alreadyOut;
    private int myMaxHealth;
    private int currentHealth;
    private List<ExhaustionEffect> exhEffList = new ArrayList<>();

    public Health(int initHealth, int maxHealth) {

        this.currentHealth = initHealth;
        this.myMaxHealth = maxHealth;
    }

    public Health(int initHealth) {
        currentHealth = initHealth;
        myMaxHealth = initHealth;
    }

    public int getValue() {
        return this.currentHealth;
    }

    public void refill(int amount) {
        if (amount + currentHealth > myMaxHealth) {
            currentHealth=myMaxHealth;
            return;
        }
        currentHealth += amount;
    }

    public void restore() {
        this.currentHealth = this.myMaxHealth;
    }

    public void drain(int mount) {
        if (currentHealth - mount < 0) {
            currentHealth= 0;
            exhaust();
            return;
        }
        currentHealth -= mount;
    }

    public void exhaust() {
        currentHealth = 0;
        if(!alreadyOut){
            alreadyOut=true;
            this.exhEffList.forEach(ExhaustionEffect::apply);
        }

    }

    public void onExhaustion(ExhaustionEffect effect) {
        this.exhEffList.add(effect);

    }
}
