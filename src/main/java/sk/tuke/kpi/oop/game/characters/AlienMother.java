package sk.tuke.kpi.oop.game.characters;

import sk.tuke.kpi.gamelib.framework.AbstractActor;
import sk.tuke.kpi.gamelib.graphics.Animation;

public class AlienMother extends AbstractActor {

    public AlienMother(){
        Animation normal_animation;
        normal_animation=new Animation("sprites/mother.png",112,162, 0.2f, Animation.PlayMode.LOOP_PINGPONG);
        setAnimation(normal_animation);
    }
}
