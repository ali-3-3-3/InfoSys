class BookingPossibilities {
    private final Driver driver;
    private final Request request;
    private final Service service;
    private static final double CENTS_TO_DOLLARS = 100.0;

    public BookingPossibilities(Driver driver, Request request,
            Service service) {
        this.driver = driver;
        this.request = request;
        this.service = service;
    }

    double fare() {
        return this.request.computeFare(this.service)
            / CENTS_TO_DOLLARS;
    }

    @Override
    public String toString() {
        return String.format("$%.2f using %s (%s)", 
                this.fare(), this.driver.toString(),
                this.service.toString());
    } 
}

