class Researcher {
    private final int arrivalTime;
    private final int stayTime;

    public Researcher(int arrivalTime, int stayTime) {
        this.arrivalTime = arrivalTime;
        this.stayTime = stayTime;
    }

    int getArrivalTime() {
        return this.arrivalTime;
    }

    int getStayTime() {
        return this.stayTime;
    }
}
