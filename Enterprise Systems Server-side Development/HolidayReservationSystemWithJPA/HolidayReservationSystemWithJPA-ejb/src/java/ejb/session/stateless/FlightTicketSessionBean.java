package ejb.session.stateless;

import entity.ItineraryItem;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Random;
import javax.ejb.Stateless;



@Stateless

public class FlightTicketSessionBean implements FlightTicketSessionBeanLocal 
{
    @Override
    public List<ItineraryItem> searchFlights(Date departureDate, Date returnDate, String departureCity, String destinationCity)
    {
        Random random = new Random((new Date()).getTime());
        
        List<ItineraryItem> flightTickets = new ArrayList<>();
        
        Date departureFlightTakeoff = departureDate;
        departureFlightTakeoff.setHours(random.nextInt(24));
        departureFlightTakeoff.setMinutes(((random.nextInt(60) + 4) / 5) * 5);
        
        GregorianCalendar departureFlightLandingCalendar = new GregorianCalendar();
        departureFlightLandingCalendar.setTime(departureFlightTakeoff);
        departureFlightLandingCalendar.add(GregorianCalendar.HOUR_OF_DAY, random.nextInt(10) + 1);        
        Date departureFlightLanding = departureFlightLandingCalendar.getTime();
        
        Date returnFlightLanding = returnDate;
        returnFlightLanding.setHours(random.nextInt(24));
        returnFlightLanding.setMinutes(((random.nextInt(60) + 4) / 5) * 5);
        
        GregorianCalendar returnFlightTakeoffCalendar = new GregorianCalendar();
        returnFlightTakeoffCalendar.setTime(returnFlightLanding);
        returnFlightTakeoffCalendar.add(GregorianCalendar.HOUR_OF_DAY, (random.nextInt(10) + 1) * -1);
        Date returnFlightTakeoff = returnFlightTakeoffCalendar.getTime();
        
        String departureFlightNumber = String.valueOf((char)(random.nextInt(26) + 'A')) + String.valueOf((char)(random.nextInt(26) + 'A'));
        String returnFlightNumber = departureFlightNumber;
        departureFlightNumber = departureFlightNumber + random.nextInt(10) + random.nextInt(10) + random.nextInt(10);
        returnFlightNumber = returnFlightNumber + random.nextInt(10) + random.nextInt(10) + random.nextInt(10);
        
        flightTickets.add(new ItineraryItem(1, departureFlightTakeoff, "Board flight " + departureFlightNumber + " from " + departureCity + " Airport"));
        flightTickets.add(new ItineraryItem(2, departureFlightLanding, "Flight " + departureFlightNumber + " lands at " + destinationCity + " Airport"));
        flightTickets.add(new ItineraryItem(3, returnFlightTakeoff, "Board flight " + returnFlightNumber + " from " + destinationCity + " Airport"));
        flightTickets.add(new ItineraryItem(4, returnFlightLanding, "Flight " + returnFlightNumber + " lands at " + departureCity + " Airport"));                
        
        return flightTickets;
    }
}