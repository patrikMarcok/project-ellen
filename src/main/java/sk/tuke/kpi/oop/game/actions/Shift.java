package sk.tuke.kpi.oop.game.actions;



import sk.tuke.kpi.gamelib.framework.actions.AbstractAction;
import sk.tuke.kpi.oop.game.Keeper;


public class Shift<T extends Keeper> extends AbstractAction<T> {

   //
   // public Shift (){}
    public  Shift( ){

    }

    @Override
    public void execute(float deltaTime) {
      //  if(actor!= null){
        //actor.getBackpack().shift();
       // }
        //setDone(true);

        try {
         //   for (Actor item : getActor().getScene().getActors()) {
               // if (item != this.actor && getActor().intersects(item)) {
                    getActor().getBackpack().shift();
                  //  break;
                //}
        //    }
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
