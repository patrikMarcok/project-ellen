package sk.tuke.kpi.oop.game.items;


import sk.tuke.kpi.gamelib.framework.AbstractActor;
import sk.tuke.kpi.gamelib.graphics.Animation;
import sk.tuke.kpi.oop.game.characters.Armed;
import sk.tuke.kpi.oop.game.characters.Ripley;

public class Ammo extends AbstractActor implements Usable<Armed>,Collectible {
    private int ammo1 = 50;

    private Ripley ripley;
    public Ammo() {
        Animation anim_ammo;
        this.ammo1 = ammo1;
        anim_ammo = new Animation("sprites/ammo.png");
        setAnimation(anim_ammo);

    }

    public void setAmmo(){
        if(ripley.getAmmo()<=450){
            ripley.setAmmo(ripley.getAmmo()+50);
        }
    }


    public void reload(int newAmmo){
        if(newAmmo>0) this.ammo1=this.ammo1+newAmmo;
    }




    @Override
    public void useWith(Armed actor) {
        if (actor != null && actor.getFirearm().getAmmo() < 500) {


            actor.getFirearm().reload(50);
            getScene().removeActor(this);

        }
    }

    @Override
    public Class<Armed> getUsingActorClass() {
        return Armed.class;
    }


}
