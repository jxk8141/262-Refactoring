public class Network {
    private Driver driver;

    public Network(Driver driver) {
        this.driver = driver;
    }

    public void start(Player playerOne, Player playerTwo) {
        Facade.GameType gameType = this.driver.getGameMode();

        if(gameType == Facade.GameType.HOST_GAME) {
            this.startHostGame(playerTwo);
        } else if(gameType == Facade.GameType.CLIENT_GAME) {
            this.startNetworkGame(playerOne);
        }
    }

    private void startHostGame(Player player) {
        ((NetworkPlayer)player).waitForConnect();
    }

    private void startNetworkGame(Player player) {
        ((NetworkPlayer)player).connectToHost();
    };
}
