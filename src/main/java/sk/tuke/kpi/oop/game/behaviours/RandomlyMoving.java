package sk.tuke.kpi.oop.game.behaviours;


import sk.tuke.kpi.oop.game.Direction;
import sk.tuke.kpi.oop.game.Movable;
import sk.tuke.kpi.oop.game.actions.Move;

public class RandomlyMoving implements Behaviour<Movable>{


    @Override
    public void setUp(Movable actor) {
        if(actor==null) {
            //      actor.startedMoving(Direction.NONE);

            Move<Movable> move = new Move<Movable>(Direction.NORTH, Float.MAX_VALUE);
            move.scheduleFor(actor);
          //  return;
        }
    }
}
