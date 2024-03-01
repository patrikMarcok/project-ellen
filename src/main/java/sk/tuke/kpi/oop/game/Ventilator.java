package sk.tuke.kpi.oop.game;

import sk.tuke.kpi.gamelib.framework.AbstractActor;
import sk.tuke.kpi.gamelib.graphics.Animation;
import sk.tuke.kpi.oop.game.characters.Ripley;


import sk.tuke.kpi.oop.game.items.Usable;

public class Ventilator extends AbstractActor implements Repairable, Usable<Ripley> {

    private Animation animation;
    public Ventilator(){
        animation=new Animation("sprites/ventilator.png",32,32,0.1f,Animation.PlayMode.ONCE);
        setAnimation(animation);
    }


    @Override
    public boolean repair() {
        animation=new Animation("sprites/ventilator.png",32,32,0.1f,Animation.PlayMode.LOOP_PINGPONG);
        setAnimation(animation);
        System.out.println("repairujem");

        return true;
    }



    @Override
    public void useWith(Ripley actor) {
//        Collectible hammer = actor.getBackpack().peek();

        this.repair();
    }

    @Override
    public Class<Ripley> getUsingActorClass() {
        return Ripley.class;
    }
}
