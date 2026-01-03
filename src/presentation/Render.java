package presentation;

import entities.Entity;
import entities.Grass;
import entities.Rock;
import entities.Tree;
import entities.creatures.Herbivore;
import entities.creatures.Predator;
import world.WorldMap;


public class Render {
    public void renderMap(WorldMap worldMap){
        System.out.println();
        for (int x = 0; x < worldMap.getWidth(); x++){
            for (int y = 0; y < worldMap.getHeight(); y++){
                Entity entity = worldMap.getEntityByCoordinates(x, y);
                if (entity == null){
                    System.out.print(Emoji.PLAIN);
                } else {
                    System.out.print(getEmojiForEntity(entity));
                }
                System.out.print("\t");
            }
            System.out.println();
        }
    }

    private Emoji getEmojiForEntity(Entity entity){
        if (entity instanceof Grass){
            return Emoji.GRASS;
        } else if (entity instanceof Predator){
            return Emoji.PREDATOR;
        } else if (entity instanceof Herbivore){
            return Emoji.HERBIVORE;
        } else if (entity instanceof Tree){
            return Emoji.TREE;
        } else if (entity instanceof Rock){
            return Emoji.ROCK;
        }
        return null;
    }
}
