package world;

import entities.Entity;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class WorldMap {
    private final int width;
    private final int height;
    private final Map<Cell, Entity> entities;

    public WorldMap(int width, int height){
        this.width = width;
        this.height = height;
        this.entities = new HashMap<>();
    }

    public WorldMap(){
        this.width = 5;
        this.height = 5;
        this.entities = new HashMap<>();
    }

    public int getWidth(){
        return width;
    }

    public int getHeight(){
        return height;
    }

    public Entity getEntityByCoordinates(int x, int y){
        return entities.get(new Cell(x, y));
    }

    public Entity getEntityByCell(Cell cell){
        return entities.get(cell);
    }

    public void addEntity(Cell cell, Entity entity){
        entities.put(cell, entity);
    }
    public <T extends Entity> int countEntity(Class<T> entityClass){
        int entityCounter = 0;
        for (Map.Entry<Cell, Entity> entityEntry: entities.entrySet()){
            if (entityClass.isInstance(entityEntry.getValue())){
                entityCounter++;
            }
        }
        return entityCounter;
    }

    public void removeCell(Cell cell){
        entities.remove(cell);
    }

    public Map<Cell, Entity> getEntities(){
        return entities;
    }

    public boolean isCellEmpty(int x, int y){
        return entities.containsKey(new Cell(x, y));
    }

    public Cell getEmtpyCell(){
        int attempts = height * width;
        Random random = new Random();
        while (attempts > 0){
            int x= random.nextInt(width);
            int y= random.nextInt(height);
            if (!isCellEmpty(x, y)){
                return new Cell(x, y);
            }
            attempts--;
        }
        return null;
    }



}
