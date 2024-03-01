package sk.tuke.kpi.oop.game.items;

//import sk.tuke.kpi.gamelib.Actor;
import sk.tuke.kpi.gamelib.graphics.Animation;
import sk.tuke.kpi.oop.game.Reactor;

public class FireExtinguisher extends BreakableTool<Reactor> implements Collectible {


    public FireExtinguisher() {
        super(1);
        Animation normal_animation;
        normal_animation = new Animation("sprites/extinguisher.png");
        setAnimation(normal_animation);
    }

    @Override
    public void useWith(Reactor Actor) {
        if(Actor == null) return;
        if(super.getRemainingUses()>0 && Actor.extinguish()==true) super.useWith(Actor);

    }

    @Override
    public Class<Reactor> getUsingActorClass() {
        return Reactor.class;
    }

    /*@Override
    public void useWith(Reactor Actor) {
        if(Actor!=null) {

            useWith(Actor);
        }
    }*/
}




