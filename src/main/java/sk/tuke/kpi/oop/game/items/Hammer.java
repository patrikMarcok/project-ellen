package sk.tuke.kpi.oop.game.items;

import sk.tuke.kpi.gamelib.graphics.Animation;
import sk.tuke.kpi.oop.game.Reactor;
import sk.tuke.kpi.oop.game.Repairable;

public class Hammer extends BreakableTool<Repairable> implements Collectible{



    public Hammer(){
    super(1);
    Animation normal_animation;
    normal_animation=new Animation("sprites/hammer.png");
    setAnimation(normal_animation);
    }

 //   @Override
    public void useWith(Reactor Actor) {
        if(Actor == null) return;
        if(super.getRemainingUses()>0 && Actor.repair()==true) super.useWith(Actor);

    }

//arena init
public Class<Repairable> getUsingActorClass() {
    return Repairable.class;
}



}
