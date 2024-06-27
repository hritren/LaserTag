package laser.tag.game;

public class GameNotOverException extends RuntimeException {

    public GameNotOverException() {
        super("The game is still ongoing. A winner is yet to be decided");
    }
}
