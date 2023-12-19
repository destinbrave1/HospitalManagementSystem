/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MODEL;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

/**
 *
 * @author destin
 */
@Entity
public class Diagnosis implements Serializable {
    private static final long serialVersionUID = 5149641714150001821L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;
    private Date date;
    @ManyToOne
    @JoinColumn(name="patient_id")
    private Inpatients patient;
    @ManyToOne
    @JoinColumn(name="stuff_id")
    private Stuff stuff;

    public Diagnosis() {
    }

    public Diagnosis(Integer Id, Date date, Inpatients patient, Stuff stuff) {
        this.Id = Id;
        this.date = date;
        this.patient = patient;
        this.stuff = stuff;
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer Id) {
        this.Id = Id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Inpatients getPatient() {
        return patient;
    }

    public void setPatient(Inpatients patient) {
        this.patient = patient;
    }

    public Stuff getStuff() {
        return stuff;
    }

    public void setStuff(Stuff stuff) {
        this.stuff = stuff;
    }
    
    
}
