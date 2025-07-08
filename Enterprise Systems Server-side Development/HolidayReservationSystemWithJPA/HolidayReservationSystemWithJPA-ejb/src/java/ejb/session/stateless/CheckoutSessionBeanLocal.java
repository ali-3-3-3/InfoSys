package ejb.session.stateless;

import entity.ItineraryItem;
import java.math.BigDecimal;
import java.util.List;
import javax.ejb.Local;
import util.enumeration.PaymentModeEnum;
import util.exception.CheckoutException;



@Local

public interface CheckoutSessionBeanLocal
{   
    public Long checkout(Long customerId, List<ItineraryItem> itineraryItems, PaymentModeEnum paymentMode, String creditCardNumber, BigDecimal totalAmount) throws CheckoutException;
}