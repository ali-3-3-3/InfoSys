class TakeACab implements Service {

    private static final int BOOKING_FEE = 200;
    private static final int PER_KM = 33;
    
    @Override
    public int computeFare(int distance, int passengers, int time) {
        return BOOKING_FEE + PER_KM * distance;
    }

    @Override
    public String toString() {
        return String.format("TakeACab");
    }
}

