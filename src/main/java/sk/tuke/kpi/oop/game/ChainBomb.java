/*package sk.tuke.kpi.oop.game;


import sk.tuke.kpi.gamelib.Actor;
import sk.tuke.kpi.gamelib.Scene;

//import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

public class ChainBomb extends TimeBomb{
    public ChainBomb(float sec) {
        super(sec);
    }

    public void explode(){
        float x = this.getPosX();
        float y = this.getPosY();
        Ellipse2D.Float kruh = new Ellipse2D.Float(x,y,100,100);
        Scene scene = getScene();
        for(Actor actor: scene.getActors()){
            Rectangle2D.Float activate= new Rectangle2D.Float(actor.getPosX(),actor.getPosY(),actor.getWidth(),actor.getWidth());
            if(kruh.intersects(activate)){
                ((ChainBomb)actor).activate();
            }
         }

    }

    //Ellipse2D.Float;
    //Rectangle2D.Float


    @Override
    public void activate() {
       //
        activate();
        explode();
    }
}
*/
