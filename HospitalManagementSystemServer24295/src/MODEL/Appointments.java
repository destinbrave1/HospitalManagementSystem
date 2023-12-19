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
public class Appointments implements Serializable {
    private static final long serialVersionUID = 5149641714150001821L;
     @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String  patient_national_id;
    private String  inpatient_name;
    private String  date_of_birth;
    private String inpatient_sickness;
    private String inpatient_amount_paid;
    @ManyToOne
    @JoinColumn(name="department_id")
    private Department department;
    @ManyToOne
    @JoinColumn(name="room_no")
    private Rooms room;
    private String inpatient_phone_number;
    private Date inpatient_date_in;
    @OneToMany(mappedBy = "patient")
    private List<Diagnosis> diagnosis = new ArrayList<>();

    public Appointments() {
    }

    public Appointments(String patient_national_id) {
        this.patient_national_id = patient_national_id;
    }

    public Appointments(Integer id, String patient_national_id, String inpatient_name, String date_of_birth, String inpatient_sickness, String inpatient_amount_paid, Department department, Rooms room, String inpatient_phone_number, Date inpatient_date_in) {
        this.id = id;
        this.patient_national_id = patient_national_id;
        this.inpatient_name = inpatient_name;
        this.date_of_birth = date_of_birth;
        this.inpatient_sickness = inpatient_sickness;
        this.inpatient_amount_paid = inpatient_amount_paid;
        this.department = department;
        this.room = room;
        this.inpatient_phone_number = inpatient_phone_number;
        this.inpatient_date_in = inpatient_date_in;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPatient_national_id() {
        return patient_national_id;
    }

    public void setPatient_national_id(String patient_national_id) {
        this.patient_national_id = patient_national_id;
    }

    public String getInpatient_name() {
        return inpatient_name;
    }

    public void setInpatient_name(String inpatient_name) {
        this.inpatient_name = inpatient_name;
    }

    public String getDate_of_birth() {
        return date_of_birth;
    }

    public void setDate_of_birth(String date_of_birth) {
        this.date_of_birth = date_of_birth;
    }

    public String getInpatient_sickness() {
        return inpatient_sickness;
    }

    public void setInpatient_sickness(String inpatient_sickness) {
        this.inpatient_sickness = inpatient_sickness;
    }

    public String getInpatient_amount_paid() {
        return inpatient_amount_paid;
    }

    public void setInpatient_amount_paid(String inpatient_amount_paid) {
        this.inpatient_amount_paid = inpatient_amount_paid;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Rooms getRoom() {
        return room;
    }

    public void setRoom(Rooms room) {
        this.room = room;
    }

    public String getInpatient_phone_number() {
        return inpatient_phone_number;
    }

    public void setInpatient_phone_number(String inpatient_phone_number) {
        this.inpatient_phone_number = inpatient_phone_number;
    }

    public Date getInpatient_date_in() {
        return inpatient_date_in;
    }

    public void setInpatient_date_in(Date inpatient_date_in) {
        this.inpatient_date_in = inpatient_date_in;
    }

    public List<Diagnosis> getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(List<Diagnosis> diagnosis) {
        this.diagnosis = diagnosis;
    }

   
}
