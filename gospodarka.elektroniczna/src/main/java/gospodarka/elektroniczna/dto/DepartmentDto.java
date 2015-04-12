package gospodarka.elektroniczna.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Encja reprezentująca oddział.
 * 
 * @author Adam Kopaczewski
 *
 * Copyright © 2015 Adam Kopaczewski
 */
@Entity
@Table(name = "DEPARTMENTS")
public class DepartmentDto extends AbstractDto implements Serializable {
    /**
     * UID.
     */
    private static final long serialVersionUID = -4652417286804055194L;
    /**
     * Id oddziału.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID", nullable = false)
    private int id;
    /**
     * Nazwa oddziału.
     */
    @Column(name = "NAME", nullable = false, length = 255, unique = true)
    private String name;
    
    
    /**
     * Konstruktor
     */
    public DepartmentDto() {
        id = UNLOADED_ID;
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
