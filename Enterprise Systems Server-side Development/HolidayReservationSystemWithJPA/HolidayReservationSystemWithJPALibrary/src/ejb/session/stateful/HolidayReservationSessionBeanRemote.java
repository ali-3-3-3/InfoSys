package ejb.session.stateful;

import entity.ItineraryItem;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import javax.ejb.Remote;
import util.enumeration.PaymentModeEnum;
import util.exception.CheckoutException;



@Remote

public interface HolidayReservationSessionBeanRemote
{
    public void remove();
    
    public List<ItineraryItem> searchHolidays(Date departureDate, Date returnDate, String departureCity, String destinationCity, Integer numberOfTravellers);

    public BigDecimal getTotalAmount();

    public Long reserveHoliday(Long customerId, PaymentModeEnum paymentMode, String creditCardNumber) throws CheckoutException;    
}