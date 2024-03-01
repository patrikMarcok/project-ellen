package sk.tuke.kpi.oop.game.items;


import sk.tuke.kpi.gamelib.Scene;
import sk.tuke.kpi.gamelib.framework.AbstractActor;

import sk.tuke.kpi.gamelib.graphics.Animation;
import sk.tuke.kpi.oop.game.characters.Alive;

public class Energy/*<A extends Ripley>*/ extends AbstractActor implements Usable<Alive>{
   // private int energy;

    public Energy(){
        //this.energy=100;
        Animation anim_energy;
        anim_energy = new Animation("sprites/energy.png");
        setAnimation(anim_energy);

    }

    @Override
    public void useWith(Alive actor) {
        //Ripley ripley=(Ripley)getScene().getFirstActorByName("Ripley");
        //Player player1=(Player)getScene().getFirstActorByName("Player");
        System.out.println("som dnu");
       // if(ripley.intersects(this)){
            //actor.setHealth(100);
            //actor.setEnergy(100);
            System.out.println("som dnu");
            Scene scenka =this.getScene();
            scenka.removeActor(this);
           if(actor!=null) actor.getHealth().refill(100);

        //}

    }

    @Override
    public Class<Alive> getUsingActorClass() {
        return Alive.class;
    }

}
