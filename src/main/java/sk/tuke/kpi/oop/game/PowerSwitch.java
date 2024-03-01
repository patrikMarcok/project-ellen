package sk.tuke.kpi.oop.game;

import sk.tuke.kpi.gamelib.framework.AbstractActor;
import sk.tuke.kpi.gamelib.graphics.Animation;

public class PowerSwitch extends AbstractActor implements Switchable{
    private Switchable switchable;


    public PowerSwitch (Switchable switchable){
        this.switchable=switchable;
        Animation normal_animation;
        normal_animation = new Animation("sprites/switch.png");
        setAnimation(normal_animation);
    }

    public void toggle(){
        if(switchable.isOn()==true){
            switchable.turnOff();
        }else switchable.turnOn();

    }



    public Switchable getDevice(){
        return switchable;
    }

    public void switchOn(){
        if(switchable==null) return;

        switchable.turnOn();
    }

    public void switchOff(){
        if(switchable==null) return;

        switchable.turnOff();
    }



    @Override
    public void turnOn() {
        if(switchable==null) return;
        switchable.turnOn();
    }

    @Override
    public void turnOff() {
        if(switchable==null) return;
        switchable.turnOff();
    }

    @Override
    public boolean isOn() {

        if(switchable.isOn()==true){
            return true;
        }else return false;
    }
}
