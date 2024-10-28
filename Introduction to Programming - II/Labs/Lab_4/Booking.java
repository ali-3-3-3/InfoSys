class Booking implements Comparable<Booking> {
    private final Driver driver;
    private final Request request;

    public Booking(Driver driver, Request request) {
        this.driver = driver;
        this.request = request;
    }

    double fare(Driver driver) {
        if (this.driver.fareComputation_1(this.request) > 
                this.driver.fareComputation_2(this.request)) {
            return this.driver.fareComputation_2(this.request);
        } else {
            return this.driver.fareComputation_1(this.request);
        }
    }

    @Override
    public int compareTo(Booking other) {
        if (this.fare(this.driver) > other.fare(other.driver) ||
            this.fare(this.driver) < other.fare(other.driver)) {
            return Double.compare(this.fare(this.driver), 
                    other.fare(this.driver));
        } else {
            return Integer.compare(this.driver.getWaitingTime(), 
                    other.driver.getWaitingTime());
        }
    }

    @Override
    public String toString() {
        return String.format("$%.2f using %s (%s)", 
                this.fare(this.driver), this.driver.toString(),
                this.driver.getService(this.request));
    } 
}
