package sk.tuke.kpi.oop.game.actions;

import sk.tuke.kpi.gamelib.framework.actions.AbstractAction;
import sk.tuke.kpi.oop.game.Keeper;
import sk.tuke.kpi.oop.game.items.Collectible;

public class Drop<T extends Keeper> extends AbstractAction<T> {

    private T player;
    public Drop(){}
    public Drop(T player){
    this.player=player;
    }


    @Override
    public void execute(float deltaTime) {
        if(player==null){
            System.out.println("player null");
        }
        try {

            Collectible item = getActor().getBackpack().peek();
            getActor().getScene().addActor(
                item,
                getActor().getPosX() + item.getWidth() / 2,
                getActor().getPosY() + item.getHeight() / 2
            );
            System.out.println("som dnu");
            getActor().getBackpack().remove(item);
        } catch (Exception e) {
            e.printStackTrace();
        }
        setDone(true);
    }


}
