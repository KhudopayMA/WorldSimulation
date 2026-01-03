package actions.turn_actions;

import actions.Action;
import entities.creatures.Herbivore;
import world.Cell;
import world.WorldMap;


public class SpawnHerbivore implements Action {

    @Override
    public void execute(WorldMap worldMap){
        int herbivoreCounter = worldMap.countEntity(Herbivore.class);
        if (herbivoreCounter <= 0){
            while (herbivoreCounter < 2){
                Cell cell = worldMap.getEmtpyCell();
                if (cell == null){
                    break;
                }
                Herbivore herbivore = new Herbivore();
                worldMap.addEntity(cell, herbivore);
                herbivoreCounter++;
            }
        }
    }
}
