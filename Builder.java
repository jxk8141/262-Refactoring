public class Builder {

    private String name;
    private int num;
    private Rules rules;
    private Driver driver;

    public Builder setName(String name) {
        this.name = name;
        return this;
    }

    public Builder setNum(int num){
        this.num = num;
        return this;
    }

    public Builder setRules(Rules rules){
        this.rules = rules;
        return this;
    }

    public Builder setDriver(Driver driver){
        this.driver = driver;
        return this;
    }

    public int getName() {
        return this.num;
    }

    public int getNum() {
        return this.num;
    }

    public Rules getRules() {
        return this.rules;
    }

    public Driver getDriver(){
        return this.driver;
    }

    public LocalPlayer buildLocalPlayer(){
        return new LocalPlayer(this);
    }

    public NetworkPlayer buildNetworkPlayer(){
        return new NetworkPlayer(this);
    }
}
