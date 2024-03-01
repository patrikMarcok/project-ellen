package sk.tuke.kpi.oop.game.characters;

import java.util.HashSet;
import java.util.Set;

public class Health {

    private final Set<ExhaustionEffect> effectListeners = new HashSet<>();


    private int healthcurrent,max;
    public Health(int health, int max){
    this.max=max;
    this.healthcurrent=health;
}



    @FunctionalInterface
    public interface ExhaustionEffect {
        void apply();
    }

    public void onExhaustion(ExhaustionEffect effect){
        effectListeners.add(effect);


    }

    public Health(int health){
        this.max=health;
        this.healthcurrent=health;
    }

    public int getHealth() {
        return healthcurrent;
    }


    public void refill(int amount){
    healthcurrent=healthcurrent+amount;
    if(healthcurrent>max){
        healthcurrent=max;
    }
    }

    public void restore(){
    healthcurrent=max;
    }

    public void drain(int amount){
    healthcurrent=healthcurrent-amount;
    if(healthcurrent<0 || healthcurrent==0){
        healthcurrent=0;

    }
//       healthcurrent-= amount;
  //      this.healthcurrent = amount < 0 ? 0 : amount > max ? max : amount;

        if (healthcurrent == 0) {
            for (Health.ExhaustionEffect effect: effectListeners) {
                effect.apply();
            }

            effectListeners.forEach(effect -> effect.apply());
            effectListeners.clear();
        }

    }

    void exhaust(){
    healthcurrent=0;
    drain(1);
    }

public int getValue(){
        return this.healthcurrent;
}

}
