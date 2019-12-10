package sk.tuke.kpi.oop.game.items;


import org.jetbrains.annotations.NotNull;
import sk.tuke.kpi.gamelib.ActorContainer;

import java.util.*;

public class Backpack implements ActorContainer<Collectible> {
    private int capacity;
    private String name;
    private Stack<Collectible> myRucksack;
    public Backpack(String name, int capacity){
        this.capacity=capacity;
        this.name= name;
        myRucksack = new Stack<Collectible>();
    }



    /**
     * Container's content.
     * Modifications to the returned list should not reflect in the container.
     */
    @Override
    public @NotNull List<Collectible> getContent() {
       return new ArrayList<>(myRucksack);
    }

    /**
     * @return maximum capacity of the container.
     */
    @Override
    public int getCapacity() {

        return capacity;
    }

    /**
     * @return current size of the container's content.
     */
    @Override
    public int getSize() {

        return myRucksack.size();
    }

    /**
     * @return name of the container.
     */
    @Override
    public @NotNull String getName()
    {
        return name;
    }

    /**
     * Adds actor to the top of the container.
     *
     * @param actor
     * @throws IllegalStateException if the container is already full
     */
    @Override
    public void add(@NotNull Collectible actor) {
        if(actor == null){
            return;
        }
        if (getSize()>=capacity){
            throw new IllegalStateException(this.getName()+ " is full");
        }
        myRucksack.add(actor);
    }

    /**
     * Removes actor from te container.
     *
     * @param actor
     */
    @Override
    public void remove(@NotNull Collectible actor) {
        if (getSize() == 0) {
            throw new IllegalStateException(this.getName() + " is empty");
        }
        myRucksack.remove(actor);
    }
    /**
     * @return actor at the top of the container.
     */
    @Override
    public Collectible peek() {
        if (getSize() == 0) {
            throw new IllegalStateException(this.getName() + " is empty");
        }
        return myRucksack.firstElement();

    }

    /**
     * Moves the actor from the top of the container to the bottom.
     */
    @Override
    public void shift() {
        Collections.rotate(myRucksack, getSize()+1);

    }

    @NotNull
    @Override
    public Iterator<Collectible> iterator() {

        return myRucksack.iterator();
    }
}
