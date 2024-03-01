package sk.tuke.kpi.oop.game;

import org.jetbrains.annotations.NotNull;
import sk.tuke.kpi.gamelib.Scene;
import sk.tuke.kpi.gamelib.framework.AbstractActor;
import sk.tuke.kpi.gamelib.graphics.Animation;
//import sk.tuke.kpi.oop.game.tools.BreakableTool;
//import sk.tuke.kpi.oop.game.tools.Hammer;
import sk.tuke.kpi.oop.game.actions.PerpetualReactorHeating;
//import sk.tuke.kpi.oop.game.tools.FireExtinguisher;

import java.util.HashSet;
import java.util.Set;

public class Reactor extends AbstractActor implements Switchable, EnergyConsumer, Repairable {

    private int temperature;
    private int damage;
    private Animation normal_animation;
    private Animation normal_animationhot;
    private Animation normal_animationdes;


    private int state;
    private Light light;

    //private EnergyConsumer device;

    private Set<EnergyConsumer> devices;

    public Reactor() {
        light=null;

        //switchable=null;
        state=0;
        temperature = 0;
        damage = 0;
        normal_animation = new Animation("sprites/reactor.png", 80, 80, 0.1f, Animation.PlayMode.LOOP_PINGPONG);
        setAnimation(normal_animation);
        devices = new HashSet<>();
    }

    public boolean extinguish(){
        //fireExtinguisher.useWith();
        if(state==-1) {
            temperature=4000;
            repairWith();

            normal_animation = new Animation("sprites/reactor_extinguished.png", 80, 80, 0.1f, Animation.PlayMode.LOOP_PINGPONG);
            setAnimation(normal_animation);
            return true;
        }
        return false;
    }
@Override
    public boolean repair(/* Hammer kladivo*/){

        if(damage<100 && damage > 50){

            damage-=50;
            temperature=damage*40+2000;
            //temperature=
            updateAnimation();

            return true;
        } else if (damage>0){
            damage = 0;
            repair();//
            temperature=damage*40+2000;
            updateAnimation();

            return true;
        }else return false;
        //temperature=damage*40+2000;

    }

    public void addDevice(EnergyConsumer device){
        //light = newLight;

        devices.add(device);
        if(device==null) return;

        if(this.isOn()){
            device.setPowered(true);
        }else device.setPowered(false);
          //  newLight.setElectricityFlow(true);

    }

    public void removeDevice(EnergyConsumer device) {
       devices.remove(device);
       device.setPowered(false);

        }

    public void addSwitch(Switchable newSwitch){
//        Switchable switchable;
      //  switchable=newSwitch;
    }


    public int getDamage() {
        return damage;
    }

    public int getTemperature() {
        return temperature;
    }


    public void increaseTemperature(int increment) {
        int incre = increment;
        temperature = getTemperature();
        //temperature = temperature+increment;
        damage = getDamage();
        if(state==1 && increment >0) {
           /* if (increment >= 2000 || temperature >= 2000) {
                */if (damage >= 33 && damage <= 66) {
                    incre = (int) Math.ceil(increment * 1.5);
                }else if (damage > 66) {
                    incre = 2 * increment;
                }
                if (temperature >= 2000) damage = (int) Math.floor((temperature - 2000) / 40);
                else if (increment > 2000) damage = (int) Math.floor((incre - 2000) / 40);

          /*  if(temperature==2000 || (temperature>=4000 && temperature<4010)|| temperature==6000){

            }*/
            temperature += incre;
            updateAnimation();
        }
        if (temperature > 6000) {
          //   temperature = 6000;
            damage=100;
             turnOff();

        }

        updateAnimation();

    }


    public void decreaseTemperature(int decrement) {
       // int decre=decrement;
        damage=getDamage();
        if(state==1 && decrement>0) {
            if (damage >= 50 && damage < 100 && state == 1) {
                temperature -= decrement / 2;
            } else temperature -= decrement;
        }
        //damage = getDamage();
       /* if(state==1 && decrement >0) {
            //if (temperature >= 2000) {
                if (damage >= 33 && damage <= 66 && temperature >= 2000) {
                    decre = (int) Math.ceil(decre * 1.5);
                }

                if (damage > 66) {
                    decre = 2 * decrement;
                }


               if (temperature >= 2000) {
                    damage = (int) Math.floor((temperature-2000) / 40);
                } else if (decrement > 2000) {
                    damage = (int) Math.floor((decre - 2000) / 40);
                }

            //}
         */   if(temperature<0) temperature=0;


        updateAnimation();
    }


    public void updateAnimation(){
        temperature=getTemperature();
        if (temperature >= 4000 && temperature<6000/* && normal_animationhot!=normal_animationhot*/) {
            normal_animationhot = new Animation("sprites/reactor_hot.png", 80, 80, 0.1f, Animation.PlayMode.LOOP_PINGPONG);
            setAnimation(normal_animationhot);
            /*if(light!=null) {

                light.setElectricityFlow(this.isRunning());
            }*/
        }

        else if (temperature >= 6000/* && normal_animationdes!=normal_animationdes*/) {
            normal_animationdes = new Animation("sprites/reactor_broken.png", 80, 80, 0.1f, Animation.PlayMode.LOOP_PINGPONG);
            setAnimation(normal_animationdes);
            state =-1;
            setPowered(false);

            /* if(light!=null) {

                light.setElectricityFlow(false);
            }*/
        }
        else if (temperature <= 4000 && state==1/* && normal_animation!=normal_animation*/) {
            normal_animation = new Animation("sprites/reactor_on.png", 80, 80, 0.1f, Animation.PlayMode.LOOP_PINGPONG);
            setAnimation(normal_animation);
            setPowered(true);
            /*if(light!=null) {

                light.setElectricityFlow(this.isRunning());
            }*/
        }
    }

    public void repairWith(){

        if(damage>0 && damage < 100){
            damage-=50;
        }
        if(damage<0){
            damage=0;
        }
    }
@Override
    public void turnOn(){
       if(state>-1) {
           state = 1;
           //light.setPowered(true);
           //  updateAnimation();
           normal_animation = new Animation("sprites/reactor_on.png", 80, 80, 0.1f, Animation.PlayMode.LOOP_PINGPONG);
           setAnimation(normal_animation);

           for(EnergyConsumer i : devices) {
               i.setPowered(true);
           }
           /*if (devices != null) {

               devices.setPowered(true);
           }*/
       }
    }
    public void turnOff(){
        state=0;
        setPowered(false);
        if(damage==100) {
            normal_animation = new Animation("sprites/reactor_broken.png", 80, 80, 0.1f, Animation.PlayMode.LOOP_PINGPONG);
            setAnimation(normal_animation);
            setPowered(false);
            if(light!=null) light.setElectricityFlow(false);
        }else  normal_animation = new Animation("sprites/reactor.png", 80, 80, 0.1f, Animation.PlayMode.LOOP_PINGPONG);
        setAnimation(normal_animation);

        for(EnergyConsumer i : devices) {
            i.setPowered(false);
        }
        /*  if(device!=null) {

            device.setPowered(false);
        }*/
    }


    @Override
    public boolean isOn() {
        if(this.isRunning()==true){
            return true;
        }else return false;
    }

    public boolean isRunning(){
        if(state==1){
            return true;
        }else return false;

    }

    @Override
    public void addedToScene(@NotNull Scene scene) {
        super.addedToScene(scene);
        new PerpetualReactorHeating(1).scheduleFor(this);

    }

    @Override
    public void setPowered(boolean bool) {


    }
//
/*
    @Override
    public boolean repair() {

        return false;
    }*/
}
