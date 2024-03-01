package sk.tuke.kpi.oop.game.scenarios;

import org.jetbrains.annotations.NotNull;

import sk.tuke.kpi.gamelib.Scene;
import sk.tuke.kpi.gamelib.SceneListener;

import sk.tuke.kpi.gamelib.graphics.Overlay;

import sk.tuke.kpi.oop.game.characters.Ripley;

import sk.tuke.kpi.oop.game.items.Hammer;



public class FirstSteps implements SceneListener {


  //  @Override
   // public void sceneCreated(@NotNull Scene scene) {

   // }

    @Override
    public void sceneInitialized(@NotNull Scene scene) {
        Ripley ripley = new Ripley();
        Hammer hammer = new Hammer();
//        Backpack backpack = new Backpack("backpack",10);
//       MovableController movableController=new MovableController(ripley);
        scene.addActor(ripley, 0,0);
        //scene.scheduleAction(new Move(Direction.NORTH,3),ripley);
        //scene.scheduleAction(new Move(Direction.EAST,3),ripley);
       // scene.getInput().registerListener(movableController);
//        scene.addActor(new Energy(),100,10);
        scene.addActor(hammer,100,100);

        //scene.getGame().pushActorContainer(backpack);
        //backpack.add(hammer);
        //scene.addActor(backpack.peek(),100,100);
        //scene.getGame().pushActorContainer(ripley.getBackpack());


        /////////////////vypisanie energy/////////////

        //////////////////////////////////
    }

    @Override
    public void sceneUpdating(@NotNull Scene scene) {
        Ripley ripley = (Ripley) scene.getFirstActorByName("Ripley");
        Overlay overlay = scene.getOverlay();
        //scene.getGame().getOverlay();
  //      int windowHeight = scene.getGame().getWindowSetup().getHeight();
//        int yTextPos = windowHeight - GameApplication.STATUS_LINE_OFFSET;
        overlay.drawText(" | Energy:" + ripley.getHealthCurrent(),-300,270);
      //  scene.getGame().pushActorContainer(ripley.getBackpack());
    }
}
