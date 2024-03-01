package sk.tuke.kpi.oop.game.items;

import sk.tuke.kpi.gamelib.framework.AbstractActor;
import sk.tuke.kpi.gamelib.graphics.Animation;
import sk.tuke.kpi.oop.game.openables.LockedDoor;

public class AccessCard extends AbstractActor implements Usable<LockedDoor>,Collectible{

    public AccessCard(){
    Animation anim;
        anim=new Animation("sprites/key.png", 16, 16);
        setAnimation(anim);
    }

    @Override
    public void useWith(LockedDoor actor) {
        if(actor.isLocked()){
            actor.unlock();
        }else actor.lock();
    }

    @Override
    public Class<LockedDoor> getUsingActorClass() {
        return LockedDoor.class;
    }
}
