package entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;



@Entity

public class ItineraryItem implements Serializable
{
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long itineraryItemId;
    @Column(nullable = false)
    private Integer sequenceNumber;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    private Date dateTime;
    @Column(nullable = false, length = 128)
    private String activity;

    
    
    public ItineraryItem()
    {
    }

    
    
    public ItineraryItem(Integer sequenceNumber, Date dateTime, String activity)
    {
        this();
        
        this.sequenceNumber = sequenceNumber;
        this.dateTime = dateTime;
        this.activity = activity;
    }
    
    
    
    @Override
    public int hashCode()
    {
        int hash = 0;
        hash += (this.itineraryItemId != null ? this.itineraryItemId.hashCode() : 0);
        
        return hash;
    }

    
    
    @Override
    public boolean equals(Object object)
    {
        if (!(object instanceof ItineraryItem)) 
        {
            return false;
        }
        
        ItineraryItem other = (ItineraryItem) object;
        
        if ((this.itineraryItemId == null && other.itineraryItemId != null) || (this.itineraryItemId != null && !this.itineraryItemId.equals(other.itineraryItemId))) 
        {
            return false;
        }
        
        return true;
    }

    
    
    @Override
    public String toString() 
    {
        return "entity.ItineraryItem[ itineraryItemId=" + this.itineraryItemId + " ]";
    }

    
    
    public Long getItineraryItemId() {
        return itineraryItemId;
    }

    public void setItineraryItemId(Long itineraryItemId) {
        this.itineraryItemId = itineraryItemId;
    }

    public Integer getSequenceNumber() {
        return sequenceNumber;
    }

    public void setSequenceNumber(Integer sequenceNumber) {
        this.sequenceNumber = sequenceNumber;
    }

    public Date getDateTime() {
        return dateTime;
    }

    public void setDateTime(Date dateTime) {
        this.dateTime = dateTime;
    }

    public String getActivity() {
        return activity;
    }

    public void setActivity(String activity) {
        this.activity = activity;
    }
}