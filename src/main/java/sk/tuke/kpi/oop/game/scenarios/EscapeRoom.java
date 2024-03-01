package sk.tuke.kpi.oop.game.scenarios;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import sk.tuke.kpi.gamelib.*;

import sk.tuke.kpi.oop.game.behaviours.Behaviour;
import sk.tuke.kpi.oop.game.characters.Alien;
import sk.tuke.kpi.oop.game.characters.AlienMother;
import sk.tuke.kpi.oop.game.characters.Ripley;
import sk.tuke.kpi.oop.game.controllers.KeeperController;
import sk.tuke.kpi.oop.game.controllers.MovableController;

public class EscapeRoom implements SceneListener {

    @Override
    public void sceneInitialized(@NotNull Scene scene) {
        Ripley ripley = (Ripley) scene.getFirstActorByName("Ripley");
        MovableController movableController=new MovableController(ripley);
        KeeperController keeperController=new KeeperController(ripley);
        scene.getInput().registerListener(movableController);
        scene.getInput().registerListener(keeperController);
        scene.follow(ripley);
    }

    @Override
    public void sceneCreated(@NotNull Scene scene) {

    //    for(i: World.ACTOR_ADDED_TOPIC.getName()) {

      //  }
    }

    public static class Factory implements ActorFactory {

        @Override
        public @Nullable Actor create(@Nullable String type, @Nullable String name) {
            switch (name) {
                case "ellen":
                    return new Ripley();
              //  case "alien":
                //    return new Alien("allien", 100, B);
                case "alien mother":
                    return new AlienMother();

                default:
                    return null;

            }

        }

    }
}
