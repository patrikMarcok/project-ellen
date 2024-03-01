package sk.tuke.kpi.oop.game;

import org.jetbrains.annotations.NotNull;
//import sk.tuke.kpi.gamelib.Actor;
//import sk.tuke.kpi.gamelib.Actor;
import sk.tuke.kpi.gamelib.Disposable;
import sk.tuke.kpi.gamelib.Scene;
//import sk.tuke.kpi.gamelib.actions.Action;
import sk.tuke.kpi.gamelib.actions.ActionSequence;
import sk.tuke.kpi.gamelib.actions.Invoke;
import sk.tuke.kpi.gamelib.actions.Wait;
import sk.tuke.kpi.gamelib.framework.actions.Loop;


public class DefectiveLight extends Light implements Repairable{
    private Disposable dis;
    private boolean isPowered;
//    private boolean state;

    public DefectiveLight () {
        super();
    }

     public void funkcia(){
         double random =  Math.random();
        //turnOn();
        isPowered();
         if(random <= 0.1 && isPowered){
            toggle();
        }
    }


    public boolean isPowered() {
        //System.out.println(isPowered);
        //setPowered(state);
        isPowered=isNapajanie();
        return isPowered;
    }

    @Override
    public void addedToScene(@NotNull Scene scene) {
        super.addedToScene(scene);
        dis = new Loop<>(new Invoke<>(this::funkcia)).scheduleFor(this);

    }

    @Override
    public boolean repair() {
        turnOn();
        dis.dispose();

        new ActionSequence<>(
        new Wait<>(10),

        new Loop<>(new Invoke<>(this::funkcia))
        ).scheduleFor(this);

        return false;
    }

}
