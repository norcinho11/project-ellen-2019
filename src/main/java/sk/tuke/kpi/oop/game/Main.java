package sk.tuke.kpi.oop.game;


import sk.tuke.kpi.gamelib.*;
import sk.tuke.kpi.oop.game.scenarios.EscapeRoom;

public class Main {
    public static void main(String[] args) {
        WindowSetup windowSetup = new WindowSetup("Project Ellen", 800, 600);
        Game game = new GameApplication(windowSetup);
//        Scene scene = new World("world","maps/mission-impossible.tmx");
 //       Scene missionImpossible = new World("mission-impossible", "maps/mission-impossible.tmx", new MissionImpossible.Factory());
        Scene escapeRoom = new World("escape-room", "maps/escape-room.tmx", new EscapeRoom.Factory());

        game.addScene(escapeRoom);
        // 4.7 MovableController movableController = new MovableController("")
  //      FirstSteps firstSteps = new FirstSteps();
    //    MissionImpossible missionImpossible1 = new MissionImpossible();
        EscapeRoom escapeRoom1 = new EscapeRoom();
        escapeRoom.addListener(escapeRoom1);//check out 1.7
        game.getInput().onKeyPressed(Input.Key.ESCAPE, game::stop);
        game.start();

    }
}
 // before uploading check out private/public/final variables , imports , unused methods , runability
