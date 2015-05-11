package gospodarka.elektroniczna.dto.storehouse;



import java.io.Serializable;
import java.util.Date;

import org.apache.commons.lang3.builder.ToStringBuilder;


public class PPZDocument implements Serializable {
	
    /**
	 * 
	 */
	private static final long serialVersionUID = 9213708960529183737L;
	/**
     * Data.
     */
	
    private Date date;
    /**
     * Liczba.
     */
    private int number;
    /**
     * Przewidywana data realizacji
     */
    private Date dateEnd;
    /**
     * status
     */
    private String state;
    /**
     * Uzasadnienie
     */
    private String reason;

    
    /**
     * Konstruktor.
     */
    public PPZDocument() {
    }
    
    
    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    // GETTERY I SETTERY
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }


	public Date getDateEnd() {
		return dateEnd;
	}


	public void setDateEnd(Date dateEnd) {
		this.dateEnd = dateEnd;
	}


	public String getState() {
		return state;
	}


	public void setState(String state) {
		this.state = state;
	}


	public String getReason() {
		return reason;
	}


	public void setReason(String reason) {
		this.reason = reason;
	}
}
