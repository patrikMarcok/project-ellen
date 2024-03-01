package sk.tuke.kpi.oop.game;

import sk.tuke.kpi.gamelib.framework.AbstractActor;
import sk.tuke.kpi.gamelib.graphics.Animation;
import sk.tuke.kpi.oop.game.characters.Ripley;
import sk.tuke.kpi.oop.game.items.Backpack;
import sk.tuke.kpi.oop.game.items.Hammer;
import sk.tuke.kpi.oop.game.items.Usable;


public class Locker extends AbstractActor implements Usable<Ripley> {

    public Locker(){
        Animation normal_animation;
        normal_animation=new Animation("sprites/locker.png",16,16,0.1f);
        setAnimation(normal_animation);
    }


    @Override
    public void useWith(Ripley actor) {
        Hammer hammer=new Hammer();
        Backpack backpack= actor.getBackpack();
        backpack.add(hammer);
    }

    @Override
    public Class<Ripley> getUsingActorClass() {
        return Ripley.class;
    }
}
