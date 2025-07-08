package ejb.session.stateless;

import entity.Customer;
import javax.ejb.Remote;
import util.exception.InvalidLoginCredentialException;



@Remote

public interface CustomerSessionBeanRemote
{
    public Customer login(String email, String password) throws InvalidLoginCredentialException;
    
    public Long createNewCustomer(Customer customer);
}