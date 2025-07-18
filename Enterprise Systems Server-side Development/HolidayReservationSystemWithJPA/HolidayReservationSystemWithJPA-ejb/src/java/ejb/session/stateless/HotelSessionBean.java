package ejb.session.stateless;

import entity.ItineraryItem;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Random;
import javax.ejb.Stateless;



@Stateless

public class HotelSessionBean implements HotelSessionBeanLocal 
{
    @Override
    public List<ItineraryItem> searchHotelRooms(Date departureFlightLanding, Date returnFlightTakeoff, String departureCity, String destinationCity)
    {
        Random random = new Random((new Date()).getTime());
        
        List<ItineraryItem> hotelRooms = new ArrayList<>();
        
        GregorianCalendar checkInDateTimeCalendar = new GregorianCalendar();
        checkInDateTimeCalendar.setTime(departureFlightLanding);
        checkInDateTimeCalendar.add(GregorianCalendar.HOUR_OF_DAY, 2);
        Date checkInDateTime = checkInDateTimeCalendar.getTime();
        
        GregorianCalendar checkOutDateTimeCalendar = new GregorianCalendar();
        checkOutDateTimeCalendar.setTime(returnFlightTakeoff);
        checkOutDateTimeCalendar.add(GregorianCalendar.HOUR_OF_DAY, -2);
        Date checkOutDateTime = checkOutDateTimeCalendar.getTime();
        
        String hotelName = String.valueOf((char)(random.nextInt(26) + 'A')) + String.valueOf((char)(random.nextInt(26) + 'A')) + String.valueOf((char)(random.nextInt(26) + 'A'));
        
        hotelRooms.add(new ItineraryItem(1, checkInDateTime, "Check-in to Hotel " + hotelName));
        hotelRooms.add(new ItineraryItem(2, checkOutDateTime, "Check-out from Hotel " + hotelName));
        
        return hotelRooms;
    }
}