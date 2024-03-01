package sk.tuke.kpi.oop.game;

import sk.tuke.kpi.gamelib.*;
import sk.tuke.kpi.gamelib.backends.lwjgl.LwjglBackend;

import sk.tuke.kpi.oop.game.scenarios.EscapeRoom;

public class Main {



    public static void main(String[] args) {
        // nastavenie okna hry: nazov okna a jeho rozmery
        WindowSetup windowSetup = new WindowSetup("Project Ellen", 800, 600);


        // vytvorenie instancie hernej aplikacie
        // pouzijeme implementaciu rozhrania `Game` triedou `GameApplication`
        Game game = new GameApplication(windowSetup, new LwjglBackend());  // v pripade Mac OS bude druhy parameter "new Lwjgl2Backend()"

        // vytvorenie sceny pre hru
        // pouzijeme implementaciu rozhrania `Scene` triedou `World`
        //Scene scene = new World("world", "maps/mission-impossible.tmx");

       /*
        Scene missionImpossible = new World("mission-impossible", "maps/mission-impossible.tmx", new MissionImpossible.Factory());

        MissionImpossible missionImpossible1 = new MissionImpossible();
        missionImpossible.addListener(missionImpossible1);

        game.addScene(missionImpossible);
*/
        Scene escapeRoom = new World("mission-impossible", "maps/escape-room.tmx",/*new MissionImpossible.Factory()); */new EscapeRoom.Factory());
        EscapeRoom escapeRoom1 = new EscapeRoom();
        escapeRoom.addListener(escapeRoom1);
        game.addScene(escapeRoom);


        game.getInput().onKeyPressed(Input.Key.ESCAPE, game::stop);
        // spustenie hry
        game.start();
    }


}
