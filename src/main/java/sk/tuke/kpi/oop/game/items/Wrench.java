package sk.tuke.kpi.oop.game.items;

import sk.tuke.kpi.gamelib.graphics.Animation;
import sk.tuke.kpi.oop.game.DefectiveLight;
//import sk.tuke.kpi.oop.game.tools.BreakableTool;

public class Wrench extends BreakableTool<DefectiveLight> implements Collectible {

    public Wrench() {
        super(2);
        //remainingUses=2;
        Animation normal_animation;
        normal_animation = new Animation("sprites/wrench.png", 16, 16, 0.1f, Animation.PlayMode.LOOP_PINGPONG);
        setAnimation(normal_animation);
    }

    @Override
    public void useWith(DefectiveLight Actor) {
        if(Actor == null) return;
        if(super.getRemainingUses()>0 && Actor.repair()==true) super.useWith(Actor);

    }

    @Override
    public Class<DefectiveLight> getUsingActorClass() {
        return DefectiveLight.class;
    }
}
