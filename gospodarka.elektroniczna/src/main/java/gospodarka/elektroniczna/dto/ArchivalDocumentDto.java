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

@Entity
@Table(name = "ARCHIVAL_DOCUMENTS")
public class ArchivalDocumentDto extends AbstractDto implements Serializable {
    /**
     * UID.
     */
    private static final long serialVersionUID = 2695669872008110323L;
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
     * Data przekazania dokumentu.
     */
    @Column(name = "DATE_OF_DISPATCH", nullable = false)
    private Date dateOfDispatch;
    /**
     * Zawartość dokumentu.
     */
    @Column(name = "CONTENT", nullable = false)
    private byte[] content;

    /**
     * Konstruktor.
     */
    public ArchivalDocumentDto() {
    }

    /**
     * Konstruktor.
     * 
     * @param currDto bieżący dokument.
     */
    public ArchivalDocumentDto(CurrentDocumentDto currDto) {
        content = currDto.getContent();
        dateOfRecipt = currDto.getDateOfRecipt();
        header = currDto.getHeader();
        sourceDepartment = currDto.getSourceDepartment();
        targetDepartment = currDto.getTargetDepartment();
    }

    // SETTERY I GETTERY
    public Date getDateOfDispatch() {
        return dateOfDispatch;
    }

    public void setDateOfDispatch(Date dateOfDispatch) {
        this.dateOfDispatch = dateOfDispatch;
    }

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

    public byte[] getContent() {
        return content;
    }

    public void setContent(byte[] content) {
        this.content = content;
    }
}
