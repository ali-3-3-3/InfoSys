class Player {
    int index;
    int state;

    public Player(int index, int state) {
        this.index = index;
        this.state = state;
    }

    int getPlayerNo() {
        return this.index;
    }

    boolean foldedHands() {
        return this.state == 1;
    }

    boolean fist() {
        return this.state == 2;
    }

    void nextState() {
        this.state = this.state + 1;
    }

    @Override
    public String toString() {
        return String.format("%d : %d", this.state);
    }
}