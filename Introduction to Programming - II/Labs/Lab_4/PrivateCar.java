import java.util.List;

class PrivateCar implements Driver {
   
    private final String license;
    private final int waitingTime; 
    private final String name = "PrivateCar";
    private static final double CENTS_TO_DOLLARS = 100.0;

    public PrivateCar(String license, int waitingTime) {
        this.license = license;
        this.waitingTime = waitingTime;
    }

    @Override
    public String getLicense() {
        return this.license;
    }

    @Override
    public int getWaitingTime() {
        return this.waitingTime;
    }

    @Override
    public double fareComputation_1(Request request) {
        return request.computeFare(new JustRide()) / CENTS_TO_DOLLARS;
    }

    @Override
    public double fareComputation_2(Request request) {
        return request.computeFare(new ShareARide()) / CENTS_TO_DOLLARS;
    }

    @Override
    public String getService(Request request) {
        if (request.computeFare(new JustRide()) > 
                request.computeFare(new ShareARide())) {
            return "ShareARide";
        } else {
            return "JustRide";
        }
    }

    @Override
    public List<Service> listOfServices() {
        List<Service> servicesAvailable = List.of(new JustRide(), 
                new ShareARide());

        return servicesAvailable;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return String.format("%s (%d mins away) %s", this.getLicense(), 
                this.getWaitingTime(), this.getName());
    }

}

