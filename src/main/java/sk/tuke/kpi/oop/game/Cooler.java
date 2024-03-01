package sk.tuke.kpi.oop.game;

import org.jetbrains.annotations.NotNull;
import sk.tuke.kpi.gamelib.Scene;
import sk.tuke.kpi.gamelib.actions.Invoke;
import sk.tuke.kpi.gamelib.framework.AbstractActor;
import sk.tuke.kpi.gamelib.framework.actions.Loop;
import sk.tuke.kpi.gamelib.graphics.Animation;

public class Cooler extends AbstractActor implements Switchable {

    private Animation normal_animation;
    private boolean stav;
    private Reactor reactor;

    public Cooler(Reactor reactor){
        this.reactor=reactor;
        this.stav=false;
        normal_animation=new Animation("sprites/fan.png",32, 32, 0.0f);
        setAnimation(normal_animation);

    }

    @Override
    public void turnOn(){
        normal_animation=new Animation("sprites/fan.png",32, 32, 0.1f, Animation.PlayMode.LOOP_PINGPONG);
        setAnimation(normal_animation);
        this.stav=true;
    }
    @Override
    public void turnOff(){
        normal_animation=new Animation("sprites/fan.png",32, 32, 0.0f);
        setAnimation(normal_animation);
        this.stav=false;

    }

    public void smart (){
        if(reactor==null) return;
        if(reactor.getTemperature()<1500){
            turnOff();
        }else turnOn();

    }



    @Override
    public boolean isOn(){
        if(stav==true){
            return true;
        }else return false;

    }

    private void coolReactor(){
        if(stav==true && reactor!=null) {
           // if (reactor.isRunning()==false) {
                int damage = reactor.getDamage();
                boolean temp = reactor.isRunning();

                if (temp == true && damage <= 50) {
                    reactor.decreaseTemperature(1);
                } else reactor.decreaseTemperature(2);
            }
        //}
    }

    @Override
    public void addedToScene(@NotNull Scene scene) {
        super.addedToScene(scene);
        new Loop<>(new Invoke<>(this::coolReactor)).scheduleFor(this);
    }

   /* @Override
    public void setPowered(boolean bool) {
       //;
    }*/

}
