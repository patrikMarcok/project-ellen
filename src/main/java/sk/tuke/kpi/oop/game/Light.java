package sk.tuke.kpi.oop.game;

import sk.tuke.kpi.gamelib.framework.AbstractActor;
import sk.tuke.kpi.gamelib.graphics.Animation;

public class Light extends AbstractActor implements Switchable, EnergyConsumer{
    private Animation normal_animationoff;

    private Animation normal_animationon;

    //private boolean elektrina;
    private boolean napajanie;
    private boolean state;

    public Light(){
        normal_animationon = new Animation("sprites/light_on.png", 16, 16, 0.1f, Animation.PlayMode.LOOP_PINGPONG);

        normal_animationoff = new Animation("sprites/light_off.png", 16, 16, 0.1f, Animation.PlayMode.LOOP_PINGPONG);
        setAnimation(normal_animationoff);
  //      elektrina = false;
        state=false;
        napajanie=false;
    }
    public boolean isNapajanie(){
        return napajanie;

    }

    public void toggle(){


        /*if(elektrina){
            elektrina = false;
        }else elektrina=true;
*/
      /*  if(state) {
            state = false;
        }else  state=true;
*/
        state = !state;

        if( napajanie && state) {
           // state=true;
            setAnimation(normal_animationon);


        }else{
           // state=false;
            setAnimation(normal_animationoff);

        }

    }
    public void setElectricityFlow(boolean stavreaktora){

        napajanie=stavreaktora;
    }

    @Override
    public void turnOn() {
        if(state==false) this.toggle();
        //state=true;


    }

    @Override
    public void turnOff() {
        if(state) this.toggle();
        //state=false;

    }


    @Override
    public boolean isOn() {
        if(state){
            //normal_animationoff = new Animation("sprites/light_off.png", 16, 16, 0.1f, Animation.PlayMode.LOOP_PINGPONG);
            //setAnimation(normal_animationoff);
            return true;
        }else return false;
    }

    @Override
    public void setPowered(boolean reactorState) {
        napajanie=reactorState;
        if(napajanie && state) setAnimation(normal_animationon);
        else setAnimation(normal_animationoff);

    //    setElectricityFlow(state);
    }
}
