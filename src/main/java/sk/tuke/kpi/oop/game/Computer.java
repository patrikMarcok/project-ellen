package sk.tuke.kpi.oop.game;

import sk.tuke.kpi.gamelib.framework.AbstractActor;
import sk.tuke.kpi.gamelib.graphics.Animation;

public class Computer extends AbstractActor implements EnergyConsumer{
    private boolean stav;
    public Computer() {
        stav=true;
        setAnimation(
            new Animation(
                "sprites/computer.png",
                80,
                48,
                0.2f,
                Animation.PlayMode.LOOP));
    }
    @Override
    public void setPowered(boolean state1) {
     stav=state1;
    }
    public int add(int a, int b){
        //scitanie
        if(stav){
        System.out.println("add int");
        return a+b;}
        else return 0;
    }
    public float add(float a, float b){
        //scitanie
        if(stav) {
            System.out.println("add float");
            return a + b;
        }else return 0;
    }

    public int sub(int a, int b){
        //odcitanie
        if(stav) {
        System.out.println("sub int");
        return a-b;
        }else return 0;
    }
    public float sub(float a, float b){
        //odcitanie
            if(stav) {
        System.out.println("sub float");
        return a-b;
            }else return 0;
    }


}
