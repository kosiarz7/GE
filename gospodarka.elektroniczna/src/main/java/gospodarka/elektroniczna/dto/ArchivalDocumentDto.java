package gospodarka.elektroniczna.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "ARCHIVAL_DOCUMENTS")
public class ArchivalDocumentDto extends CurrentDocumentDto {
    /**
     * UID.
     */
    private static final long serialVersionUID = 2695669872008110323L;
    /**
     * Data przekazania dokumentu.
     */
    @Column(name = "DATE_OF_DISPATCH", nullable = false)
    private Date dateOfDispatch;

    /**
     * Konstruktor.
     */
    public ArchivalDocumentDto() {
        super();
    }

    // SETTERY I GETTERY
    public Date getDateOfDispatch() {
        return dateOfDispatch;
    }

    public void setDateOfDispatch(Date dateOfDispatch) {
        this.dateOfDispatch = dateOfDispatch;
    }
}
