package sk.tuke.kpi.oop.game.scenarios;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import sk.tuke.kpi.gamelib.*;

import sk.tuke.kpi.gamelib.graphics.Overlay;


import sk.tuke.kpi.oop.game.Locker;
import sk.tuke.kpi.oop.game.Ventilator;

import sk.tuke.kpi.oop.game.characters.Ripley;
import sk.tuke.kpi.oop.game.controllers.KeeperController;
import sk.tuke.kpi.oop.game.controllers.MovableController;
import sk.tuke.kpi.oop.game.items.*;

import sk.tuke.kpi.oop.game.openables.Door;
import sk.tuke.kpi.oop.game.openables.LockedDoor;


public class MissionImpossible implements SceneListener{

    @Override
    public void sceneInitialized(@NotNull Scene scene) {
        Ripley ripley = (Ripley) scene.getFirstActorByName("Ripley");
        MovableController movableController=new MovableController(ripley);
        KeeperController keeperController=new KeeperController(ripley);
        scene.getInput().registerListener(movableController);
        scene.getInput().registerListener(keeperController);


        //Ripley ripley = new Ripley();
//        Energy energy = (Energy)scene.getFirstActorByName("energy");
        Hammer hammer = new Hammer();
        Backpack backpack = ripley.getBackpack();
        scene.follow(ripley);
        FireExtinguisher fireExtinguisher = new FireExtinguisher();
        //scene.getGame().pushActorContainer(backpack);
        backpack.add(hammer);
        backpack.add(fireExtinguisher);
       // System.out.println( + backpack.getCapacity() +backpack.getName());
       // System.out.println( backpack.iterator());

      /*new When<>(
          () -> ripley.intersects(energy),
          new Use<>(energy.useWith(ripley)) {
          }
      ).scheduleFor(this);
        *///scene.addActor(backpack,100,100);
       // new Use<>((energy)).scheduleForIntersectingWith(ripley);

        //new Use<>((Usable<?>) topItem).scheduleForIntersectingWith(this.keeper);


//        Door door = (Door) scene.getFirstActorByName("door");

       // System.out.println("door:" );
       // new When<Ripley>(()->ripley.intersects(door), new Use<Ripley>());//.scheduleFor(this);
       Game game = scene.getGame();
       if(game!=null) {
        //System.out.println( ripley.getBackpack().getSize());
           game.pushActorContainer(ripley.getBackpack());
       }
//        MessageBus messageBus = new MessageBus();
        //messageBus =    scene.getMessageBus().subscribe(Door.DOOR_OPENED,ripley);
       /* new ActionSequence<> (
            new Invoke<Actor>(ripley:: setEnergy(-1))
        );*/

        //for (Actor actor : scene.getActors()){
          //  if (actor instanceof Ripley) {

           // }
        //}

        /////////////////vypisanie energy/////////////

        //////////////////////////////////
    }
    @Override
    public void sceneUpdating(@NotNull Scene scene) {
       Ripley ripley = (Ripley) scene.getFirstActorByName("Ripley");
   /*     MovableController movableController=new MovableController(ripley);
        scene.getInput().registerListener(movableController);


      //  Game game = scene.getGame();
        //if(game!=null)
       // Backpack backpack= ripley.getBackpack();
        //game.pushActorContainer(backpack);

        //ripley.getBackpack().add(new Hammer());
        //scene.getGame().pushActorContainer(ripley.getBackpack());
*/  Overlay overlay = scene.getOverlay();
  //      int windowHeight = scene.getGame().getWindowSetup().getHeight();
//        int yTextPos = windowHeight - GameApplication.STATUS_LINE_OFFSET;
        overlay.drawText(" | Energy:" + ripley.getHealthCurrent(),-300,270);
    }

    public static class Factory implements ActorFactory{


        @Override
        public @Nullable Actor create(@Nullable String type, @Nullable String name) {
            switch (name) {
                case "ellen":
                    return new Ripley();
                case "energy":
                    return new Energy();
                case "door":
                    return new LockedDoor("dvere", Door.Orientation.VERTICAL);
                case "access card":
                    System.out.println("access card");
                    return new AccessCard();
                case "locker":
                    return new Locker();
                case "ventilator":
                    return new Ventilator();

                default:
                    return null;


            }
        }

    }
}
