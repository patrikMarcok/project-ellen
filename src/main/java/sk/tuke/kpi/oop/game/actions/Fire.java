package sk.tuke.kpi.oop.game.actions;

import sk.tuke.kpi.gamelib.Actor;
import sk.tuke.kpi.gamelib.framework.actions.AbstractAction;
import sk.tuke.kpi.oop.game.Direction;
import sk.tuke.kpi.oop.game.characters.Armed;
import sk.tuke.kpi.oop.game.weapons.Fireable;

import java.util.Objects;


public class Fire<T extends Armed & Actor> extends AbstractAction<T> {
    private boolean isdone;
    //private Armed player;
    public Fire(){}



    @Override
    public void execute(float deltaTime) {
        /*    if(player!=null){
                getActor().getFirearm().fire();
            }
          */
        //isdone=true;
        T executingActor = getActor();
        if  (Objects.nonNull(executingActor) && !isDone()) {

            Fireable bullet = executingActor.getFirearm().fire();
            if (Objects.isNull(bullet)) {
                setDone(true);
                return;
            }

            bullet.getAnimation().setRotation(Direction.fromAngle(executingActor.getAnimation().getRotation()).getAngle());
            int bulletX = executingActor.getPosX() + 10;
            int bulletY = executingActor.getPosY() + 10;
            executingActor.getScene().addActor(bullet, bulletX, bulletY);
            new Move<Fireable>(Direction.fromAngle(executingActor.getAnimation().getRotation()), Float.MAX_VALUE).scheduleFor(bullet);
        }
        isdone=true;
        setDone(true);

    }

    public boolean isDone(){
        return isdone;
    }
}
