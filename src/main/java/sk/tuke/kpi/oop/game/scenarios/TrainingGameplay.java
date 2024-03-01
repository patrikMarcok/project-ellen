package sk.tuke.kpi.oop.game.scenarios;

import org.jetbrains.annotations.NotNull;
import sk.tuke.kpi.gamelib.Scene;
import sk.tuke.kpi.gamelib.framework.Scenario;
import sk.tuke.kpi.oop.game.Reactor;
import sk.tuke.kpi.oop.game.characters.Ripley;


public class TrainingGameplay extends Scenario {
    @Override
    public void setupPlay(@NotNull Scene scene) {
        Reactor reactor = new Reactor();  // vytvorenie instancie reaktora
        scene.addActor(reactor, 64, 64);  // pridanie reaktora do sceny na poziciu [x=64, y=64]
        reactor.turnOn();

        Ripley ripley = new Ripley();
        scene.addActor(ripley, 25,25);

        /*Cooler cooler = new Cooler(reactor);
        scene.addActor(cooler, 200, 200);  // pridanie reaktora do sceny na poziciu [x=64, y=64]
        new ActionSequence<>(
            new Wait<>(5),
            new Invoke<>(cooler::turnOn)
        ).scheduleFor(cooler);
   */ }
}

