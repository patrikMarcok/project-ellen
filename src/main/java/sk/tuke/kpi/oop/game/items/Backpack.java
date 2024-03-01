package sk.tuke.kpi.oop.game.items;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import sk.tuke.kpi.gamelib.ActorContainer;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Backpack implements ActorContainer<Collectible> {
    private String name;
    private int capacity;
    private int size;


  private List<Collectible> list;

    public Backpack(String name, int capacity){
        this.list = new ArrayList<>();
        this.name=name;
        this.capacity=capacity;
        this.size=0;
    }



    @Override
    public @NotNull List<Collectible> getContent() {

        return List.copyOf(list);
    }

    @Override
    public int getCapacity() {
        return this.capacity;
    }

    @Override
    public int getSize() {
        return this.size;
    }

    @Override
    public @NotNull String getName() {
        return this.name;
    }

    @Override
    public void add(@NotNull Collectible actor) {
        if (this.size == capacity) {
            throw new IllegalStateException(getName() + " is full");
        }
        System.out.println("som v add");
        this.list.add(actor);
        this.size++;
    }

    @Override
    public void remove(@NotNull Collectible actor) {
            this.list.remove(actor);
    }

    @Override
    public @Nullable Collectible peek() {
        if (this.list.isEmpty()) {
            return null;
        }
        return this.list.get(this.list.size() - 1);
    }

    @Override
    public void shift() {
        if (this.list.isEmpty() || this.list.size() == 1) {
            return;
        }

        this.list.add(0, this.list.remove(this.list.size() - 1));

    }

    @NotNull
    @Override
    public Iterator<Collectible> iterator() {
       // for (Collectible item : this) {
            return list.listIterator();

            // pouzitie predmetu (item) z batohu
        //}
       // return null ;
    }


}
