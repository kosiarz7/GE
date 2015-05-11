package gospodarka.elektroniczna.documents;

import java.io.Serializable;
import java.util.Date;
import java.util.Random;

import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * Twstowy dokument.
 * 
 * @author Adam Kopaczewski
 *
 *         Copyright © 2015 Adam Kopaczewski
 */
public class TestDocument extends AbstractDocument implements Serializable {

    /**
     * UID.
     */
    private static final long serialVersionUID = 6176618099177411087L;
    /**
     * Data.
     */
    private Date date;
    /**
     * Liczba.
     */
    private int number;

    
    /**
     * Konstruktor.
     */
    public TestDocument() {
        number = new Random().nextInt(100_000) + 200;
        date = new Date();
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
}
