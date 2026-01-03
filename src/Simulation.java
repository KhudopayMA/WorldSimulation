import actions.Action;
import actions.init_actions.PopulateMap;
import actions.turn_actions.MoveEntities;
import actions.turn_actions.SpawnGrass;
import actions.turn_actions.SpawnHerbivore;
import presentation.Render;
import world.WorldMap;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Simulation {

    private final List<Action> initActions = new ArrayList<>();
    private final List<Action> turnActions = new ArrayList<>();
    private final Render render = new Render();

    private WorldMap worldMap = new WorldMap();
    private int turnCounter = 0;


    public volatile boolean isRunning = true;

    public void startSimulation(){
        createInitActions();
        createTurnActions();

        for (Action action: initActions){
            action.execute(worldMap);
        }

        Thread sumulationThread = new Thread(this.createTurnsLoop(), "turnsLoop");
        Thread commandListenerThread = new Thread(this.createCommandListener(), "commandListener");

        sumulationThread.start();
        commandListenerThread.start();

        try {
            sumulationThread.join();
            commandListenerThread.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

    private synchronized Runnable createTurnsLoop(){
        return  ()-> {
            while (true){
                if (this.isRunning) {
                    turnCounter++;
                    render.renderMap(worldMap);
                    for (Action action: turnActions){
                        action.execute(worldMap);
                    }
                    System.out.println("Turn: " + turnCounter);
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        };
    }

    private synchronized Runnable createCommandListener(){
        return  ()->{
            Scanner scanner = new Scanner(System.in);
            while (true) {
                char userInput = scanner.next().charAt(0);
                if (userInput == ControlKeys.PAUSE.getKey()){
                    this.isRunning = !this.isRunning;
                } else if (userInput == ControlKeys.QUIT.getKey()){
                    System.exit(0);
                }
            }
        };
    }

    private void createInitActions(){
        initActions.add(new PopulateMap());
    }

    private void createTurnActions(){
        turnActions.add(new SpawnGrass());
        turnActions.add(new SpawnHerbivore());
        turnActions.add(new MoveEntities());
    }

}
