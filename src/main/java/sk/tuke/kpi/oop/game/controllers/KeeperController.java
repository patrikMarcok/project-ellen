package sk.tuke.kpi.oop.game.controllers;

import org.jetbrains.annotations.NotNull;
import sk.tuke.kpi.gamelib.Actor;
import sk.tuke.kpi.gamelib.Input;
import sk.tuke.kpi.gamelib.KeyboardListener;
import sk.tuke.kpi.oop.game.Keeper;
import sk.tuke.kpi.oop.game.actions.Drop;
import sk.tuke.kpi.oop.game.actions.Shift;
import sk.tuke.kpi.oop.game.actions.Take;
import sk.tuke.kpi.oop.game.actions.Use;
import sk.tuke.kpi.oop.game.items.Collectible;
import sk.tuke.kpi.oop.game.items.Usable;

import java.util.Objects;

public class KeeperController implements KeyboardListener {

private Keeper keeper;
public  KeeperController(Keeper keeper){
    this.keeper=keeper;
}


    @Override
    public void keyPressed(@NotNull Input.Key key) {
   // if(keeper!=null){
    switch (key){
            case ENTER:
                /////doplnit argument
                new Take<>(this.keeper).scheduleFor(this.keeper);
                break;
             case BACKSPACE:
                new Drop<>(this.keeper).scheduleFor(this.keeper);
                break;
            case S:
                new Shift<>().scheduleFor(this.keeper);
                break;
            case U:
               // System.out.println("som vo for");
                ucko();
                break;
            case B:
                Collectible topItem = this.keeper.getBackpack().peek();

                if (topItem instanceof Usable) {
                    new Use<>((Usable<?>) topItem).scheduleForIntersectingWith(this.keeper);
                    this.keeper.getBackpack().remove(Objects.requireNonNull(topItem));
                    break;
                }

            default: break;
    }
    }//}


    private void ucko(){
        for (Actor item : this.keeper.getScene().getActors()) {
            //     Actor item = this.keeper.getScene().getFirstActorByName("ripley");
            System.out.println(item);
            if (item instanceof Usable && this.keeper.intersects(item)) {
                new Use<>((Usable<?>) item).scheduleForIntersectingWith(this.keeper);
            }

        }
    }
}
