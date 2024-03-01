package sk.tuke.kpi.oop.game.items;

//import sk.tuke.kpi.gamelib.Scene;
//import sk.tuke.kpi.gamelib.framework.AbstractActor;
import sk.tuke.kpi.gamelib.graphics.Animation;

public class Mjolnir extends Hammer{



    public Mjolnir(){
        super.setRemainingUses(4);
        Animation normal_animation;
        //this.remainingUses= 4;
        normal_animation=new Animation("sprites/hammer.png");
        setAnimation(normal_animation);
    }

    public int getMjolnir() {
        return super.getRemainingUses();
    }
/*
    public void use() {
        //   use=getHammer();
        use--;
        if(use==0){
            Scene scenka =getScene();
            scenka.removeActor(this);
        }

    }
*/
}
