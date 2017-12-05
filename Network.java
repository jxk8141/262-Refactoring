public class Network {
    private Driver driver;

    /**
     * Creates instance of network
     * @param driver Driver
     */
    public Network(Driver driver) {
        this.driver = driver;
    }

    /**
     * Starts networking option for players
     * @param playerOne First player
     * @param playerTwo Second player
     */
    public void start(Player playerOne, Player playerTwo) {
        Facade.GameType gameType = this.driver.getGameMode();

        if(gameType == Facade.GameType.HOST_GAME) {
            this.startHostGame(playerTwo);
        } else if(gameType == Facade.GameType.CLIENT_GAME) {
            this.startNetworkGame(playerOne);
        }
    }

    /**
     * Sends a player move to the opposite player
     * @param player Player who wants to send the move
     */
    public void sendMove(Player player) {
        Facade.GameType gameType = this.driver.getGameMode();

        if (gameType == Facade.GameType.HOST_GAME
                || gameType == Facade.GameType.CLIENT_GAME) {
            ((NetworkPlayer) player).sendMove();
        }
    }

    /**
     * Sends current player move and asks other player to send their move
     * @param player Player sending and asking opposite player for move
     */
    public void askForMove(Player player) {
        Facade.GameType gameType = this.driver.getGameMode();

        if (gameType == Facade.GameType.HOST_GAME
                || gameType == Facade.GameType.CLIENT_GAME) {
            ((NetworkPlayer) player).sendMove();
            ((NetworkPlayer) player).waitForPlayer();
        }
    }

    /**
     * Makes player wait for a connection
     * @param player Player
     */
    private void startHostGame(Player player) {
        ((NetworkPlayer)player).waitForConnect();
    }

    /**
     * Connects player to host
     * @param player Player
     */
    private void startNetworkGame(Player player) {
        ((NetworkPlayer)player).connectToHost();
    };
}
