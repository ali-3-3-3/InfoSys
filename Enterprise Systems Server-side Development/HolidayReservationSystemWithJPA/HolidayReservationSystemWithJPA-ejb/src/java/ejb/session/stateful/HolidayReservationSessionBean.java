package ejb.session.stateful;

import ejb.session.stateless.CarRentalSessionBeanLocal;
import ejb.session.stateless.CheckoutSessionBeanLocal;
import ejb.session.stateless.FlightTicketSessionBeanLocal;
import ejb.session.stateless.HotelSessionBeanLocal;
import entity.ItineraryItem;
import entity.Transaction;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import javax.annotation.PreDestroy;
import javax.ejb.EJB;
import javax.ejb.Remove;
import javax.ejb.Stateful;
import util.enumeration.PaymentModeEnum;
import util.exception.CheckoutException;
import util.helper.BigDecimalHelper;



@Stateful

public class HolidayReservationSessionBean implements HolidayReservationSessionBeanRemote 
{
    @EJB
    private FlightTicketSessionBeanLocal flightTicketSessionBeanLocal;
    @EJB
    private HotelSessionBeanLocal hotelSessionBeanLocal;
    @EJB
    private CarRentalSessionBeanLocal carRentalSessionBeanLocal;
    @EJB
    private CheckoutSessionBeanLocal checkoutSessionBeanLocal;
    
    private Date departureDate;
    private Date returnDate;
    private String departureCity;
    private String destinationCity;
    private Integer numberOfTravellers;
    
    private BigDecimal totalAmount;
    
    private List<ItineraryItem> itineraryItems;
    
    
    
    @Remove
    @Override
    public void remove()
    {
        // Do nothing
    }
    
    
    
    @PreDestroy
    public void preDestroy()
    {
        if(itineraryItems != null)
        {
            itineraryItems.clear();
            itineraryItems = null;
        }
    }

    
        
    @Override
    public List<ItineraryItem> searchHolidays(Date departureDate, Date returnDate, String departureCity, String destinationCity, Integer numberOfTravellers)
    {
        Random random = new Random((new Date()).getTime());
        
        this.departureDate = departureDate;
        this.returnDate = returnDate;
        this.departureCity = departureCity;
        this.destinationCity = destinationCity;
        this.numberOfTravellers = numberOfTravellers;       

        List<ItineraryItem> flightTickets = flightTicketSessionBeanLocal.searchFlights(departureDate, returnDate, departureCity, destinationCity);
        List<ItineraryItem> hotelRooms = hotelSessionBeanLocal.searchHotelRooms(flightTickets.get(1).getDateTime(), flightTickets.get(2).getDateTime(), departureCity, destinationCity);
        List<ItineraryItem> rentalCars = carRentalSessionBeanLocal.searchRentalCars(flightTickets.get(1).getDateTime(), flightTickets.get(2).getDateTime(), departureCity, destinationCity);

        itineraryItems = new ArrayList<>();
        itineraryItems.add(flightTickets.get(0));
        itineraryItems.add(flightTickets.get(1));
        itineraryItems.add(rentalCars.get(0));
        itineraryItems.add(hotelRooms.get(0));
        itineraryItems.add(hotelRooms.get(1));
        itineraryItems.add(rentalCars.get(1));
        itineraryItems.add(flightTickets.get(2));
        itineraryItems.add(flightTickets.get(3));

        Integer sequenceNumber = 0;

        for(ItineraryItem itineraryItem:itineraryItems)
        {
            itineraryItem.setSequenceNumber(++sequenceNumber);
        }
        
        Integer totalAmountInt = (random.nextInt(100) + 1) * 100;        
        totalAmount = BigDecimalHelper.createBigDecimal(totalAmountInt.toString());
        
        return itineraryItems;
    }
    
    
    
    @Override
    public Long reserveHoliday(Long customerId, PaymentModeEnum paymentMode, String creditCardNumber) throws CheckoutException
    {
        return checkoutSessionBeanLocal.checkout(customerId, itineraryItems, paymentMode, creditCardNumber, totalAmount);
    }

    
    
    @Override
    public BigDecimal getTotalAmount() 
    {
        return totalAmount;
    }
}
