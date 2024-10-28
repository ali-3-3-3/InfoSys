class Request {
    private final int distance;
    private final int passengers;
    private final int time;

    public Request(int distance, int passengers, int time) {
        this.distance = distance;
        this.passengers = passengers;
        this.time = time;
    }
    
    int computeFare(Service service) {
        return service.computeFare(this.distance, this.passengers, this.time);
    }

    public String toString() {
        return String.format("%dkm for %dpax @ %dhrs", this.distance, this.passengers, this.time);
    }

}

