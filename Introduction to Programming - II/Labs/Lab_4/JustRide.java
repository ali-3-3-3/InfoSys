class JustRide implements Service {
    
    private static final int PER_KM = 22;
    private static final int SURCHARGE = 500;
    private static final int MORNING_PEAK = 600;
    private static final int EVENING_PEAK = 900;
    
    @Override
    public int computeFare(int distance, int passengers, int time) {
        if (time < MORNING_PEAK || time > EVENING_PEAK) {
            return PER_KM * distance;
        } else {
            return PER_KM * distance + SURCHARGE;
        }
    }

    @Override
    public String toString() {
        return String.format("JustRide");
    }
}

