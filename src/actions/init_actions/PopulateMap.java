package actions.init_actions;

import actions.Action;
import entities.Grass;
import entities.Rock;
import entities.Tree;
import entities.creatures.Herbivore;
import entities.creatures.Predator;
import world.Cell;
import world.WorldMap;


public class PopulateMap implements Action {

    @Override
    public void execute( WorldMap worldMap){
        Herbivore herbivore1 = new Herbivore();
        Herbivore herbivore2 = new Herbivore();
        Grass grass1 = new Grass();
        Grass grass2 = new Grass();
        Predator predator1 = new Predator();
        Tree tree = new Tree();
        Rock rock  = new Rock();
        worldMap.getEntities().put(new Cell(2, 3),herbivore1);
        worldMap.getEntities().put(new Cell(1, 1),herbivore2);
        worldMap.getEntities().put(new Cell(0, 0),grass1);
        worldMap.getEntities().put(new Cell(3, 1),grass2);
        worldMap.getEntities().put(new Cell(0, 1),predator1);
        worldMap.getEntities().put(new Cell(2, 2),tree);
        worldMap.getEntities().put(new Cell(3, 2),rock);

    }
}
