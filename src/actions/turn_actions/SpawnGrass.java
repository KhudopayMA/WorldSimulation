package actions.turn_actions;

import actions.Action;
import entities.Grass;
import world.Cell;
import world.WorldMap;


public class SpawnGrass implements Action {

    @Override
    public void execute(WorldMap worldMap){
        int grassCounter = worldMap.countEntity(Grass.class);
        if (grassCounter < 2){
            while (grassCounter < 2){
                Cell cell = worldMap.getEmtpyCell();
                if (cell == null){
                    break;
                }
                Grass grass = new Grass();
                worldMap.addEntity(cell, grass);
                grassCounter++;
            }
        }
    }
}
