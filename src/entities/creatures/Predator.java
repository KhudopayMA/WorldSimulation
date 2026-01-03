package entities.creatures;

import world.Cell;
import world.WorldMap;

import java.util.List;

public class Predator extends Creature{
    private final int attackDamage;

    public Predator(){
        super(10, 2, Herbivore.class);
        this.attackDamage = 2;
    }
    @Override
    public void makeMove(WorldMap worldMap, Cell currentCell, List<Cell> path) {
        if (!path.isEmpty()){
            Cell newCell;
            if (worldMap.getEntityByCell(path.get(path.size()-1)) instanceof  Herbivore){
                newCell = path.get(path.size()-2);
                attack(worldMap, path.get(path.size()-1));
            } else {
                newCell = path.get(speed-1);
            }
            worldMap.removeCell(currentCell);
            worldMap.addEntity(newCell, this);
        }
    }

    public void attack(WorldMap worldMap, Cell herbivoreCell){
        Herbivore herbivore = (Herbivore) worldMap.getEntityByCell(herbivoreCell);
        herbivore.hp = herbivore.hp - attackDamage;
        if (herbivore.hp <= 0){
            worldMap.removeCell(herbivoreCell);
        }
    }
}
