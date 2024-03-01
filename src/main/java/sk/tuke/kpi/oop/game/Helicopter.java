package sk.tuke.kpi.oop.game;

import sk.tuke.kpi.gamelib.Actor;
import sk.tuke.kpi.gamelib.actions.Invoke;
import sk.tuke.kpi.gamelib.framework.AbstractActor;
import sk.tuke.kpi.gamelib.framework.Player;
import sk.tuke.kpi.gamelib.framework.actions.Loop;
import sk.tuke.kpi.gamelib.graphics.Animation;
//import sk.tuke.kpi.gamelib.graphics.BatchOverlay;

//import javax.swing.event.AncestorEvent;
//import java.sql.BatchUpdateException;

public class Helicopter extends AbstractActor{
    private Animation normal_animation;
   // private int x,y;
    private Player player;

    public Helicopter(){
        normal_animation=new Animation("sprites/heli.png",64,64, 0.1f, Animation.PlayMode.LOOP_PINGPONG);
        setAnimation(normal_animation);
    }

    public Player getPlayer() {
        return this.player;
    }


    public void searchAndDestroy() {
        Actor player;
        if(getScene()==null) {
        System.out.println("null");
        }


        player = getScene().getFirstActorByName("Player");
        if(player instanceof Player){
            player = (Player) player;
        }
        new Loop<>(new Invoke<>(this::heli)).scheduleFor(player);
    }

    public void heli(){
        Actor player;

        player = getScene().getFirstActorByName("Player");

        if(player instanceof Player){
            player = (Player) player;
        }
        int x=this.getPosX();
        int y=this.getPosY();

        if (player.getPosX() > this.getPosX()) x++;
        if (player.getPosX() < this.getPosX()) x--;
        if (player.getPosY() > this.getPosY()) y++;
        if (player.getPosY() < this.getPosY()) y--;

/*
        if (getPlayer().getPosX() > this.getPosX()) x++;
        if (getPlayer().getPosX() < this.getPosX()) x--;
        if (getPlayer().getPosY() > this.getPosY()) y++;
        if (getPlayer().getPosY() < this.getPosY()) y--;
  */
        this.setPosition(x, y);
        normal_animation=new Animation("sprites/heli.png",64,64, 0.1f, Animation.PlayMode.LOOP_PINGPONG);
        setAnimation(normal_animation);



        if (player.intersects(this)){

            Player player1=(Player)getScene().getFirstActorByName("Player");
            player1.setEnergy(player1.getEnergy()-1);
            }




    }
}
