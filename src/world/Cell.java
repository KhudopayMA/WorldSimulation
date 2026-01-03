package world;

import java.util.Objects;

public class Cell {
    public final int x;
    public final int y;
    private final int hash;

    public Cell(int x, int y){
        this.x = x;
        this.y = y;
        this.hash = Objects.hash(x, y);
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Cell cell)) return false;
        if (hash != o.hashCode()) return false;
        return x == cell.x && y == cell.y;
    }

    @Override
    public int hashCode() {
        return hash;
    }

}
