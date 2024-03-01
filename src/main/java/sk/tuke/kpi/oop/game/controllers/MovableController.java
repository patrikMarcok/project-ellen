package sk.tuke.kpi.oop.game.controllers;

import org.jetbrains.annotations.NotNull;
import sk.tuke.kpi.gamelib.Input;
import sk.tuke.kpi.gamelib.KeyboardListener;
import sk.tuke.kpi.oop.game.Direction;
import sk.tuke.kpi.oop.game.Movable;
import sk.tuke.kpi.oop.game.actions.Move;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MovableController implements KeyboardListener {

    private Move<Movable> move;
    private Movable movable1;
    private Set<Direction> pressedKeysDirections;
    public MovableController(Movable movable){
        this.movable1=movable;

        this.pressedKeysDirections=new HashSet<>();
    }
    private Map<Input.Key, Direction> keyDirectionMap = Map.ofEntries(
        Map.entry(Input.Key.UP, Direction.NORTH),
        Map.entry(Input.Key.DOWN, Direction.SOUTH),
        Map.entry(Input.Key.RIGHT, Direction.EAST),
        Map.entry(Input.Key.LEFT, Direction.WEST)



    );

    @Override
    public void keyReleased(@NotNull Input.Key key) {
        if(keyDirectionMap.containsKey(key)){
            pressedKeysDirections.remove(keyDirectionMap.get(key));
            if(move !=null){
                move.stop();
            }
            update();
            //new Move<Movable>(Direction.NONE,Float.MAX_VALUE);
           // pressedKeysDirections.forEach(direction->{System.out.println(pressedKeysDirections);
           // });
        }
    }

    @Override
    public void keyPressed(@NotNull Input.Key key) {
    //       if(keyDirectionMap.containsKey(key)){
               Direction direction = keyDirectionMap.get(key);
                pressedKeysDirections.add(direction);
                if(move!=null) move.stop();
                Direction dir = Direction.NONE;
                for(Direction direction1 : pressedKeysDirections){
                    dir = dir.combine(direction1);
                }
               move = new Move<Movable>(dir,Float.MAX_VALUE);
                move.scheduleFor(movable1);
              /*  if(pressedKeysDirections.size()==2){
                   move.stop();
                   for(int i =0 ; i<pressedKeysDirections.size(); i++) {

                       direction.combine(pressedKeysDirections.);
                   }

                }
                move = new Move<Movable>(direction,Float.MAX_VALUE);

*/
  //         }

    }

    @Override
    public void keyTyped(char character) {

    }

    private void update(){
        Direction dir = Direction.NONE;
        for(Direction direction1 : pressedKeysDirections){
            dir = dir.combine(direction1);
        }
        move = new Move<Movable>(dir,Float.MAX_VALUE);
        move.scheduleFor(movable1);






    }
}
