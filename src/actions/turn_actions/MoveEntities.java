package actions.turn_actions;

import actions.Action;
import entities.Entity;
import entities.creatures.Creature;
import entities.creatures.Herbivore;
import entities.creatures.Predator;
import world.Cell;
import world.Pathfinder;
import world.WorldMap;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MoveEntities implements Action {

    @Override
    public void execute(WorldMap worldMap) {
        List<Map.Entry<Cell, Entity>> herbivores = new ArrayList<>();
        List<Map.Entry<Cell, Entity>> predators = new ArrayList<>();
        for (Map.Entry<Cell, Entity> entity: worldMap.getEntities().entrySet()){
            if (entity.getValue() instanceof Herbivore){
                herbivores.add(entity);
            } else if (entity.getValue() instanceof Predator){
                predators.add(entity);
            }
        }
        for (Map.Entry<Cell, Entity> herbivore: herbivores){
            List<Cell> path = Pathfinder.findPath(worldMap, herbivore.getKey(), (Creature)herbivore.getValue());
            ((Creature) herbivore.getValue()).makeMove(worldMap, herbivore.getKey(), path);
        }
        for (Map.Entry<Cell, Entity> predator: predators){
            List<Cell> path = Pathfinder.findPath(worldMap, predator.getKey(), (Creature)predator.getValue());
            ((Creature) predator.getValue()).makeMove(worldMap, predator.getKey(), path);
        }
    }
}
