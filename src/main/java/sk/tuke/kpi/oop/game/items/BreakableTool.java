package sk.tuke.kpi.oop.game.items;

//import sk.tuke.kpi.gamelib.Actor;
import sk.tuke.kpi.gamelib.Actor;
import sk.tuke.kpi.gamelib.Scene;
import sk.tuke.kpi.gamelib.framework.AbstractActor;

public abstract class BreakableTool<A extends Actor> extends AbstractActor implements Usable<A> {
    private int remainingUses;

    public BreakableTool(int remainingUses){
        setRemainingUses(remainingUses);
        this.remainingUses=remainingUses;
    }

    public int getRemainingUses(){

        return remainingUses;
    }

    public int setRemainingUses(int remainingUses){
         return this.remainingUses=remainingUses;
    }
    @Override
    public void useWith(A Actor) {
        remainingUses--;
        if(remainingUses<=0){
            Scene scenka =this.getScene();
            scenka.removeActor(this);

        }

    }



}
