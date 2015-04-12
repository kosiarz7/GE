package gospodarka.elektroniczna.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * Encja reprezentująca typ dokumentu.
 * 
 * @author Adam Kopaczewski
 *
 * Copyright © 2015 Adam Kopaczewski
 */
@Entity
@Table(name = "DOCUMENT_TYPES")
public class DocumentTypeDto extends AbstractDto implements Serializable {

    /**
     * UID.
     */
    private static final long serialVersionUID = -4174190135043302353L;
    /**
     * Id typu dokumentu.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID", nullable = false)
    private int id;
    /**
     * Nazwa typu dokumentu.
     */
    @Column(name = "TYPE_NAME", nullable = false, length = 255, unique = true)
    private String name;
    
    
    /**
     * Konstruktor.
     */
    public DocumentTypeDto() {
        id = UNLOADED_ID;
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
    
    // GETTERY I SETTERY
    @Override
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
