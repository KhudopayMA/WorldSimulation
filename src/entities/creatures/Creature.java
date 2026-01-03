package entities.creatures;

import entities.Entity;
import world.Cell;
import world.WorldMap;

import java.util.List;
import java.util.Objects;

public abstract class Creature extends Entity {
    protected int hp;
    protected final int speed;
    protected final Class<? extends Entity> targetType;

    public Creature(int hp, int speed, Class<? extends Entity> targetType){
        this.hp = hp;
        this.speed = speed;
        this.targetType = targetType;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Creature creature)) return false;
        return speed == creature.speed;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(speed);
    }

    public Class<? extends Entity> getTargetType(){
        return targetType;
    }

    public void makeMove(WorldMap worldMap, Cell currentCell, List<Cell> path){
        if (!path.isEmpty()){
            Cell newCell;
            if (path.size() <= speed){
                newCell = path.get(path.size()-1);
            } else {
                newCell = path.get(speed-1);
            }
            worldMap.removeCell(currentCell);
            worldMap.addEntity(newCell, this);
        }
    }
}
