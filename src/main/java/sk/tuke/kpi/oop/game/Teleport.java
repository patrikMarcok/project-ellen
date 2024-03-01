package sk.tuke.kpi.oop.game;

import sk.tuke.kpi.gamelib.framework.AbstractActor;
import sk.tuke.kpi.gamelib.graphics.Animation;

public class Teleport extends AbstractActor {
//    private Teleport destinationTeleport;
    public Teleport(){
        Animation normal_animation;
        normal_animation = new Animation("sprites/lift.png");
        setAnimation(normal_animation);
//        int destination;
    }


    public void getDestination(){
       // return destinationTeleport;
    }

    public void setDestination(Teleport destinationTeleport){
///        Teleport destteleport=new Teleport();
//        destteleport=destinationTeleport;

    }

   /* teleportPlayer(Player player){

    }*/
}
