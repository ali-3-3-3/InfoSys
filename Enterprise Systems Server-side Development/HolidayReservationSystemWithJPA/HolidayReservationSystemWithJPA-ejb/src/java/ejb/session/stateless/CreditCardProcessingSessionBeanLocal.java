package ejb.session.stateless;

import java.math.BigDecimal;
import javax.ejb.Local;
import util.enumeration.PaymentModeEnum;
import util.exception.InvalidPaymentModeException;



@Local

public interface CreditCardProcessingSessionBeanLocal
{    
    public String chargeCreditCard(PaymentModeEnum paymentMode, String creditCardNumber, BigDecimal amount) throws InvalidPaymentModeException;
}