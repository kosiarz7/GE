package gospodarka.elektroniczna.dto;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Encja dokumentu do rozpatrzenia.
 * 
 * @author Adam Kopaczewski
 *
 *         Copyright © 2015 Adam Kopaczewski
 */
@Entity
@Table(name = "CURRENT_DOCUMENTS")
public class LightCurrentDocumentDto extends AbstractDto implements Serializable {
    /**
     * UID.
     */
    private static final long serialVersionUID = 994947943059178171L;
    /**
     * Id bieżącego dokumentu.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID", nullable = false)
    private int id;
    /**
     * Nagłówek dokumentu.
     */
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "HEADER_ID", nullable = false)
    private DocumentHeaderDto header;
    /**
     * Oddział, który wysłał dany dokument.
     */
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "SOURCE_DEPARTMENT_ID", nullable = false)
    private DepartmentDto sourceDepartment;
    /**
     * Oddział, który otrzymał dany dokument.
     */
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "TARGET_DEPARTMENT_ID", nullable = false)
    private DepartmentDto targetDepartment;
    /**
     * Data otrzymania dokumentu przez oddział docelowy.
     */
    @Column(name = "DATE_OF_RECIPT", nullable = false)
    private Date dateOfRecipt;

    
    /**
     * Konstruktor.
     */
    public LightCurrentDocumentDto() {
    }

    // GETTERY I SETTERY
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public DocumentHeaderDto getHeader() {
        return header;
    }

    public void setHeader(DocumentHeaderDto header) {
        this.header = header;
    }

    public DepartmentDto getSourceDepartment() {
        return sourceDepartment;
    }

    public void setSourceDepartment(DepartmentDto sourceDepartment) {
        this.sourceDepartment = sourceDepartment;
    }

    public DepartmentDto getTargetDepartment() {
        return targetDepartment;
    }

    public void setTargetDepartment(DepartmentDto targetDepartment) {
        this.targetDepartment = targetDepartment;
    }

    public Date getDateOfRecipt() {
        return dateOfRecipt;
    }

    public void setDateOfRecipt(Date dateOfRecipt) {
        this.dateOfRecipt = dateOfRecipt;
    }
}