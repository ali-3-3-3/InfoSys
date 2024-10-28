import java.util.Comparator;

class BookingPosComparator implements Comparator<BookingPossibilities> {
    public int compare(BookingPossibilities b1, BookingPossibilities b2) {
        double diff = b1.fare() - b2.fare();
        if (diff < 0) {
            return -1;
        } else {
            return 0;
        }
    }
}

