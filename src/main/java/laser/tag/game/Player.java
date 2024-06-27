package laser.tag.game;

public class Player {

    String name;
    long hits;

    public Player(String name) {
        this.name = name;
        hits = 0;
    }

    public void hit() {
        this.hits++;
    }

    public String getName() {
        return name;
    }

    public long getHits() {
        return hits;
    }
}
