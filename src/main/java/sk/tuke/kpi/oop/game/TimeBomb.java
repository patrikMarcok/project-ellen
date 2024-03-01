package sk.tuke.kpi.oop.game;

//import sk.tuke.kpi.gamelib.Actor;
//import sk.tuke.kpi.gamelib.Scene;
//import sk.tuke.kpi.gamelib.actions.When;
import sk.tuke.kpi.gamelib.actions.ActionSequence;
import sk.tuke.kpi.gamelib.actions.Invoke;
import sk.tuke.kpi.gamelib.actions.Wait;
import sk.tuke.kpi.gamelib.actions.When;
import sk.tuke.kpi.gamelib.framework.AbstractActor;
import sk.tuke.kpi.gamelib.graphics.Animation;

public class TimeBomb extends AbstractActor {
    private Animation normal_animation;
    private boolean stav;
    private float time;

    public TimeBomb(float sec){
        this.time = sec;
        stav=false;
        normal_animation = new Animation("sprites/bomb.png", 16, 16, 0.1f, Animation.PlayMode.LOOP_PINGPONG);
        setAnimation(normal_animation);

    }

    public void activate() {
        stav = true;
        normal_animation = new Animation("sprites/bomb_activated.png", 16, 16, 0.1f, Animation.PlayMode.LOOP_PINGPONG);
        setAnimation(normal_animation);


            new ActionSequence<> (
                new Wait<>( time),
                new Invoke<>(this::counter)
            ).scheduleFor(this);

    }
    private void counter(){
            normal_animation = new Animation("sprites/small_explosion.png", 16, 16, 0.01f, Animation.PlayMode.ONCE);
            setAnimation(normal_animation);

            new When<>(
                () -> normal_animation.getFrameCount() == normal_animation.getCurrentFrameIndex() + 1,
                new Invoke<>(
                    () -> getScene().removeActor(this)

                )
            ).scheduleFor(this);


    }

    public boolean isActivated(){
        if(stav){
            return true;
        }else return false;
    }
}
