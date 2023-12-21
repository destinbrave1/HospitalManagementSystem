/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MODEL;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.*;

/**
 *
 * @author destin
 */
@Entity
public class Department implements Serializable {
    private static final long serialVersionUID = 5149641714150001821L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;
    private String dep_id;
    @Column(name = "dep_name", length = 255)
    private String dep_name;
    private Date started_date = new Date();
    @OneToMany(mappedBy = "department", cascade = CascadeType.ALL)
    private List<Rooms> room = new ArrayList<>();
    @OneToMany(mappedBy = "department", cascade = CascadeType.ALL)
    private List<Inpatients> patient = new ArrayList<>();
    @OneToMany(mappedBy = "department", cascade = CascadeType.ALL)
    private List<Stuff> stuff = new ArrayList<>();
    @OneToMany(mappedBy = "department", cascade = CascadeType.ALL)
    private List<Appointments> appointments = new ArrayList<>();
    @OneToMany(mappedBy = "department", cascade = CascadeType.ALL)
    private List<Discharged> discharge = new ArrayList<>();
    
    public List<Appointments> getAppointments() {
        return appointments;
    }

    public void setAppointments(List<Appointments> appointments) {
        this.appointments = appointments;
    }
    

    public Department() {
    }

    public Department(String dep_id) {
        this.dep_id = dep_id;
    }

    public Department(Integer Id, String dep_id, String dep_name, Date started_date) {
        this.Id = Id;
        this.dep_id = dep_id;
        this.dep_name = dep_name;
        this.started_date = started_date;
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer Id) {
        this.Id = Id;
    }

    public String getDep_id() {
        return dep_id;
    }

    public void setDep_id(String dep_id) {
        this.dep_id = dep_id;
    }

    public String getDep_name() {
        return dep_name;
    }

    public void setDep_name(String dep_name) {
        this.dep_name = dep_name;
    }

    public Date getStarted_date() {
        return started_date;
    }

    public void setStarted_date(Date started_date) {
        this.started_date = started_date;
    }

    public List<Rooms> getRoom() {
        return room;
    }

    public void setRoom(List<Rooms> room) {
        this.room = room;
    }

    public List<Inpatients> getPatient() {
        return patient;
    }

    public void setPatient(List<Inpatients> patient) {
        this.patient = patient;
    }

    public List<Stuff> getStuff() {
        return stuff;
    }

    public void setStuff(List<Stuff> stuff) {
        this.stuff = stuff;
    }
    
}
