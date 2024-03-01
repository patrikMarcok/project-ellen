package sk.tuke.kpi.oop.game.actions;

import sk.tuke.kpi.gamelib.Actor;
import sk.tuke.kpi.gamelib.framework.actions.AbstractAction;
import sk.tuke.kpi.oop.game.Keeper;
import sk.tuke.kpi.oop.game.items.Collectible;

public class Take<T extends Keeper> extends AbstractAction<T> {
    private T player;
    public Take(){}


    public Take(T player){
        this.player=player;
    }

    @Override
    public void execute(float deltaTime) {
        try {
            for (Actor item : getActor().getScene().getActors()) {
                if (item != this.player && getActor().intersects(item)) {
                    getActor().getBackpack().add((Collectible) item);
                    getActor().getScene().removeActor(item);
                    break;
                }
            }
        } catch (IllegalStateException ise) {
            ise.printStackTrace();
        } catch (Exception e) {
            System.err.println("Unexpected");
            e.printStackTrace();
        } finally {
            setDone(true);
        }
    }

    }

