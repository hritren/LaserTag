package laser.tag.game;

public class Game {

    private static final Long NUMBER_OF_HITS_TO_WIN = 10L;

    private Player player1;

    private Player player2;

    private GameState gameState;

    public Game() {
        gameState = GameState.NOT_STARTED;
    }

    public void handleHit(String playerName) {
        if (gameState.equals(GameState.ONGOING)) {
            registerHit(playerName);
        } else {
            addPlayer(playerName);
        }
    }

    private boolean checkIdValidity(String playerName) {
        return player1.getName().equals(playerName)|| player2.getName().equals(playerName);
    }

    private void addPlayer(String playerName) {
        if (player1 == null) {
            player1 = new Player(playerName);
            System.out.printf("Registered %s%n", playerName);
            return;
        }
        if (player1.getName().equals(playerName)) {
            return;
        }
        player2 = new Player(playerName);
        System.out.printf("Registered %s%n", playerName);
        updateScoreBoard();
        gameState = GameState.ONGOING;
    }

    private void registerHit(String playerName) {
        if (!checkIdValidity(playerName)) {
            return;
        }

        if (player1.getName().equals(playerName)) {
            updateGame(player1);
            return;
        }
        updateGame(player2);
    }

    private void updateGame(Player player) {
        player.hit();
        updateScoreBoard();
        if (player.getHits() == NUMBER_OF_HITS_TO_WIN) {
            gameState = GameState.NOT_STARTED;
            player1 = player2 = null;
            System.out.printf("Winner is: %s%n", player.getName());
        }
    }

    private void updateScoreBoard() {
        System.out.printf("Current score: %s - %d   %s - %d%n", player1.getName(), player2.getHits(), player2.getName(), player1.getHits());
    }

}
