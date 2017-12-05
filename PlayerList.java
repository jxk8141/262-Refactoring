import java.util.ArrayList;
import java.util.List;

public class PlayerList {
    private Player[] players;
    private Player activePlayer;
    private Player passivePlayer;

    public PlayerList() {
        this.players = new Player[2];
    }

    public void switchActivePassivePlayers() {
        Player tempHold = activePlayer;
        activePlayer = passivePlayer;
        passivePlayer = tempHold;
    }

    public void setPlayerOne(Player player) {
        players[0] = player;
    }

    public void setPlayerTwo(Player player) {
        players[1] = player;
    }

    public void setActivePlayer(Player player) {
        activePlayer = player;
    }

    public void setPassivePlayer(Player player) {
        passivePlayer = player;
    }

    public Player getPlayerOne() {
        return players[0];
    }

    public Player getPlayerTwo() {
        return players[1];
    }

    public Player getActivePlayer() {
        return activePlayer;
    }

    public Player getPassivePlayer() {
        return passivePlayer;
    }

    public Player getPlayer(int id) {
        return players[id - 1];
    }

    public Player[] getPlayers() {
        return players;
    }
}
