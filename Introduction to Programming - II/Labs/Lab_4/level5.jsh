void findBestBooking(Request request, List<Driver> listOfCars) {

    ImList<BookingPossibilities> listOfBookings = new 
        ImList<BookingPossibilities>();

    BookingPosComparator bookingComp = new BookingPosComparator();

    for (Driver car : listOfCars) {
        for (Service service : car.listOfServices()) {
            listOfBookings = listOfBookings.add(new 
                BookingPossibilities(car, request, service));

        }
    }

    listOfBookings = listOfBookings.sort(bookingComp);

    for (BookingPossibilities booking : listOfBookings) {
        System.out.println(booking);

    }

} 


