package ejb.session.stateless;

import entity.Customer;
import entity.ItineraryItem;
import entity.Transaction;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import util.enumeration.PaymentModeEnum;
import util.exception.CheckoutException;
import util.exception.CustomerNotFoundException;
import util.exception.InvalidPaymentModeException;



@Stateless

public class CheckoutSessionBean implements CheckoutSessionBeanLocal
{
    @PersistenceContext(unitName = "HolidayReservationSystemWithJPA-ejbPU")
    private EntityManager em;
    
    @EJB
    private CustomerSessionBeanLocal customerSessionBeanLocal;    
    @EJB
    private CreditCardProcessingSessionBeanLocal creditCardProcessingSessionBeanLocal;
 
    
    
    @Override
    public Long checkout(Long customerId, List<ItineraryItem> itineraryItems, PaymentModeEnum paymentMode, String creditCardNumber, BigDecimal totalAmount) throws CheckoutException
    {
        if(customerId != null && itineraryItems != null && !itineraryItems.isEmpty())
        {
            try 
            {
                Customer customer = customerSessionBeanLocal.retrieveCustomerById(customerId);
                String paymentReferenceNumber = creditCardProcessingSessionBeanLocal.chargeCreditCard(paymentMode, creditCardNumber, totalAmount);                                
                
                Transaction transaction = new Transaction(totalAmount, new Date(), customer);
                transaction.setItineraryItems(itineraryItems);
                em.persist(transaction);
                
                for(ItineraryItem itineraryItem:transaction.getItineraryItems())
                {
                    em.persist(itineraryItem);
                }
                
                em.flush();
                
                return transaction.getTransactionId();
            } 
            catch (CustomerNotFoundException | InvalidPaymentModeException ex) 
            {
                throw new CheckoutException(ex.getMessage());
            }
        }
        else
        {
            throw new CheckoutException("Missing customer data or no holiday to checkout");
        }
    }
}