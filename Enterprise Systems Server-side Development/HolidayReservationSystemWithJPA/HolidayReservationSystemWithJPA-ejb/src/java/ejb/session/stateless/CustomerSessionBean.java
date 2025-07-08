package ejb.session.stateless;

import entity.Customer;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import util.exception.CustomerNotFoundException;
import util.exception.InvalidLoginCredentialException;



@Stateless

public class CustomerSessionBean implements CustomerSessionBeanLocal, CustomerSessionBeanRemote 
{
    @PersistenceContext(unitName = "HolidayReservationSystemWithJPA-ejbPU")
    private EntityManager em;
    
    
    
    public CustomerSessionBean() 
    {
    }
    
    
    
    @PostConstruct
    public void postConstruct()
    {
    }
    
    
    
    @PreDestroy
    public void preDestroy()
    {
    }
    
    
    
    @Override
    public Customer retrieveCustomerById(Long customerId) throws CustomerNotFoundException
    {
        Customer customer = em.find(Customer.class, customerId);
        
        if(customer != null)
        {
            return customer;
        }
        else
        {
            throw new CustomerNotFoundException("Customer does not exist: " + customerId);
        }
    }
    
    
    
    public Customer login(String email, String password) throws InvalidLoginCredentialException
    {
        try
        {
            Query query = em.createQuery("SELECT c FROM Customer c WHERE c.email = :inEmail");
            query.setParameter("inEmail", email);
            Customer customer = (Customer)query.getSingleResult();
            
            if(customer.getPassword().equals(password))
            {
                return customer;
            }
            else
            {
                throw new InvalidLoginCredentialException("Invalid login credential");
            }
        }
        catch(NoResultException ex)
        {
            throw new InvalidLoginCredentialException("Invalid login credential");
        }
    }
    
    
    
    @Override
    public Long createNewCustomer(Customer customer)
    {
        em.persist(customer);
        em.flush();
        
        return customer.getCustomerId();
    }
}