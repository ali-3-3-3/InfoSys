package ejb.session.stateless;

import entity.Customer;
import javax.ejb.Local;
import util.exception.CustomerNotFoundException;



@Local

public interface CustomerSessionBeanLocal
{
    public Customer retrieveCustomerById(Long customerId) throws CustomerNotFoundException;

    public Long createNewCustomer(Customer customer);
}