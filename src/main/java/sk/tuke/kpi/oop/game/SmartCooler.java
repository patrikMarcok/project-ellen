package sk.tuke.kpi.oop.game;
import org.jetbrains.annotations.NotNull;
import sk.tuke.kpi.gamelib.Scene;
import sk.tuke.kpi.gamelib.actions.Invoke;
import sk.tuke.kpi.gamelib.framework.actions.Loop;

public class SmartCooler extends Cooler{

    public SmartCooler(Reactor reactor) {

        super(reactor);
    }

    private void smartCooling(){

        //super.turnOn();
        super.smart();



    }

    @Override
    public void addedToScene(@NotNull Scene scene) {
        super.addedToScene(scene);
        new Loop<>(new Invoke<>(this::smartCooling)).scheduleFor(this);
    }
}
