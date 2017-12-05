import java.util.ArrayList;
import java.util.List;

public class PlayerList {
    private Player[] players;
    private Player activePlayer;
    private Player passivePlayer;

    /**
     * Creates instance of PlayerList
     */
    public PlayerList() {
        this.players = new Player[2];
    }

    /**
     * Makes active player passive and the passive player active
     */
    public void switchActivePassivePlayers() {
        Player tempHold = activePlayer;
        activePlayer = passivePlayer;
        passivePlayer = tempHold;
    }

    /**
     * Sets the first player
     * @param player Player one
     */
    public void setPlayerOne(Player player) {
        players[0] = player;
    }

    /**
     * Sets the second player
     * @param player Player two
     */
    public void setPlayerTwo(Player player) {
        players[1] = player;
    }

    /**
     * Sets a player as active
     * @param player Active player
     */
    public void setActivePlayer(Player player) {
        activePlayer = player;
    }

    /**
     * Sets a player as passive
     * @param player Passive player
     */
    public void setPassivePlayer(Player player) {
        passivePlayer = player;
    }

    /**
     * Gets first player
     * @return Player one
     */
    public Player getPlayerOne() {
        return players[0];
    }

    /**
     * Gets second player
     * @return Player two
     */
    public Player getPlayerTwo() {
        return players[1];
    }

    /**
     * Gets active player
     * @return Active player
     */
    public Player getActivePlayer() {
        return activePlayer;
    }

    /**
     * Gets passive player
     * @return Passive player
     */
    public Player getPassivePlayer() {
        return passivePlayer;
    }

    /**
     * Gets a player by id (1, 2)
     * @param id Player id (1, 2)
     * @return Player
     */
    public Player getPlayer(int id) {
        return players[id - 1];
    }

    /**
     * Gets all players (player one and player two)
     * @return Array of players
     */
    public Player[] getPlayers() {
        return players;
    }
}
