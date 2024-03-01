package sk.tuke.kpi.oop.game.weapons;

import org.jetbrains.annotations.NotNull;
import sk.tuke.kpi.gamelib.Actor;
import sk.tuke.kpi.gamelib.Scene;
import sk.tuke.kpi.gamelib.actions.Invoke;
import sk.tuke.kpi.gamelib.framework.AbstractActor;
import sk.tuke.kpi.gamelib.framework.actions.Loop;
import sk.tuke.kpi.gamelib.graphics.Animation;
import sk.tuke.kpi.oop.game.Direction;
import sk.tuke.kpi.oop.game.Movable;

import sk.tuke.kpi.oop.game.characters.Alive;
import sk.tuke.kpi.oop.game.characters.Ripley;

public class Bullet extends AbstractActor implements Movable, Fireable {

    public Bullet(){
        Animation normal_animation;
        normal_animation=new Animation("sprites/bullet.png",64,64, 0.1f, Animation.PlayMode.LOOP_PINGPONG);
        setAnimation(normal_animation);
    }

    @Override
    public int getSpeed() {
        return 4;
    }

    @Override
    public void startedMoving(Direction direction) {
            this.getAnimation().play();

    }


    @Override
    public void addedToScene(@NotNull Scene scene) {
        super.addedToScene(scene);
        new Loop<>(new Invoke<Actor>(() -> {
            scene.getActors().forEach(
                actor -> {
                    if (!(actor instanceof Ripley) && (actor instanceof Alive && this.intersects(actor))) {
                        ((Alive) actor).getHealth().drain(10);
                        scene.removeActor(this);
                    }
                }
            );
        })).scheduleFor(this);
    }



    @Override
    public void collidedWithWall() {

      getScene().removeActor(this);

    }


}
