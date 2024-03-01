package sk.tuke.kpi.oop.game.characters;

import org.jetbrains.annotations.NotNull;
import sk.tuke.kpi.gamelib.Scene;
import sk.tuke.kpi.gamelib.actions.Invoke;
import sk.tuke.kpi.gamelib.actions.When;
import sk.tuke.kpi.gamelib.framework.AbstractActor;

import sk.tuke.kpi.gamelib.framework.actions.Loop;
import sk.tuke.kpi.gamelib.graphics.Animation;
import sk.tuke.kpi.oop.game.Movable;
import sk.tuke.kpi.oop.game.behaviours.Behaviour;

import java.util.Objects;

public class Alien extends AbstractActor implements Movable,Enemy,Alive {
    //private Alien alien;
    private Behaviour<? super Alien> behaviour;
    private Health health;
    public Alien(String name, int initialhealth, Behaviour<? super Alien> behaviour){
        super(name);
        this.health=new Health(initialhealth);
        this.behaviour=behaviour;
        Animation anim = new Animation("sprites/alien.png",32,32,0.1f, Animation.PlayMode.LOOP);
        setAnimation(anim);

    }
    public Alien(int initialHealth, Behaviour<? super Alien> behaviour) {
        this("alien", initialHealth, behaviour);
    }

    public Alien(Behaviour<? super Alien> behaviour) {
        this("alien", 50, behaviour);
    }

    public Alien () {
        this("alien", 50, null);
    }



    @Override
    public Health getHealth() {
        return this.health;
    }

    @Override
    public void addedToScene(@NotNull Scene scene) {
        super.addedToScene(scene);
        if (Objects.nonNull(behaviour)) {
            behaviour.setUp(this);
        }

        this.health.onExhaustion(this::die);
        scene.getActors().forEach(
            actor -> {
                if (actor instanceof Alive && !(actor instanceof Enemy)) {
                    Alive aliveActor = (Alive) actor;
                    new Loop<>(
                        new When<>(
                            () -> actor.intersects(this),
                            new Invoke<>(() -> aliveActor.getHealth().drain(1))
                        )
                    ).scheduleFor(this);
                }
            }
        );


       /* Ripley ripley = (Ripley) scene.getFirstActorByName("ripley");
        super.addedToScene(scene);
       // for(Player player : ) {
            if (ripley.intersects(this)) {

                Ripley player1 = (Ripley) scene.getFirstActorByName("ripley");
                player1.setHealth((getHealth().healthcurrent) - 1);
            }
        //}*/
    }
    public void die () {
        getScene().removeActor(this);
    }

    @Override
    public int getSpeed() {
        return 1;
    }
}
