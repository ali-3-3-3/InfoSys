package ejb.session.stateless;

import entity.ItineraryItem;
import java.util.Date;
import java.util.List;
import javax.ejb.Local;



@Local

public interface HotelSessionBeanLocal
{
    public List<ItineraryItem> searchHotelRooms(Date departureFlightLanding, Date returnFlightTakeoff, String departureCity, String destinationCity);
}