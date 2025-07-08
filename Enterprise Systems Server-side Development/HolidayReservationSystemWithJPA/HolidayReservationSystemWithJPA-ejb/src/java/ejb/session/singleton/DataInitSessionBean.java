package ejb.session.singleton;

import ejb.session.stateless.CustomerSessionBeanLocal;
import entity.Customer;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ejb.LocalBean;
import javax.ejb.Startup;
import util.exception.CustomerNotFoundException;



@Singleton
@LocalBean
@Startup

public class DataInitSessionBean 
{    
    @EJB
    private CustomerSessionBeanLocal customerSessionBeanLocal;
    
    
    
    public DataInitSessionBean() 
    {
    }
    
    
    
    @PostConstruct
    public void postConstruct()
    {
        try
        {
            customerSessionBeanLocal.retrieveCustomerById(1l);
        }
        catch(CustomerNotFoundException ex)
        {
            loadTestData();
        }
    }
    
    
    
    private void loadTestData()
    {
        customerSessionBeanLocal.createNewCustomer(new Customer("Customer One", "customer1@gmail.com", "password"));
        customerSessionBeanLocal.createNewCustomer(new Customer("Customer Two", "customer2@gmail.com", "password"));
        customerSessionBeanLocal.createNewCustomer(new Customer("Customer Three", "customer3@gmail.com", "password"));
    }
}
