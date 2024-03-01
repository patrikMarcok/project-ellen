package sk.tuke.kpi.oop.game.characters;

import org.jetbrains.annotations.NotNull;
import sk.tuke.kpi.gamelib.Scene;
import sk.tuke.kpi.gamelib.framework.AbstractActor;
import sk.tuke.kpi.gamelib.graphics.Animation;
import sk.tuke.kpi.gamelib.messages.Topic;
import sk.tuke.kpi.oop.game.Direction;
import sk.tuke.kpi.oop.game.Keeper;
import sk.tuke.kpi.oop.game.Movable;
import sk.tuke.kpi.oop.game.items.Backpack;

import sk.tuke.kpi.oop.game.weapons.Firearm;
import sk.tuke.kpi.oop.game.weapons.Gun;

public class Ripley extends AbstractActor implements Movable, Keeper,Alive, Armed {
    private int speed =0;

    private int ammo=0;
    private Backpack backpack;
    private Animation ripley_anim;
    private Health health;
    private Firearm weapon;

    public static final Topic<Ripley> RIPLEY_DIED = Topic.create("RIPLEY DIED", Ripley.class);

    public Ripley(){
       // super("Ellen");
        this.backpack= new Backpack("Ripley's backpack",10);
        this.health=new Health(100);
        ripley_anim=new Animation("sprites/player.png", 32, 32, 0.1f, Animation.PlayMode.LOOP_PINGPONG);
        setAnimation(ripley_anim);
        speed =1;
        this.weapon= new Gun(100);
//        health.healthcurrent=100;
//        health.max=100;
    }

    @Override
    public Backpack getBackpack() {

        return this.backpack;
    }

    public int getAmmo() {
        return ammo;
    }

    public void setAmmo(int ammo) {
        this.ammo = ammo;
    }

    public int getHealthCurrent() {
        return health.getHealth();
        //return this.health.healthcurrent;
    }

    public void setHealth(int health1) {

        if(health.getHealth()<=0) death();
        this.health.getHealth();
       // this.health.healthcurrent = health1;
    }

    @Override
    public void addedToScene(@NotNull Scene scene) {
        super.addedToScene(scene);
        this.health.onExhaustion(this::death);
    }

    @Override
    public void startedMoving(Direction direction) {
        getAnimation().setRotation(direction.getAngle());
        ripley_anim.play();

    }

    @Override
    public void stoppedMoving() {
        ripley_anim.pause();

    }

    @Override
    public int getSpeed() {

        return speed;
    }

    @Override
    public Health getHealth() {
       // if(health.getHealth()<=0) death();
        return this.health;
    }

    @Override
    public Firearm getFirearm() {
        return this.weapon;
    }

    @Override
    public void setFirearm(Firearm weapon) {
        this.weapon=weapon;
    }

    private void death(){
        getScene().getMessageBus().publish(RIPLEY_DIED,this);
        getScene().cancelActions(this);
    }

}
