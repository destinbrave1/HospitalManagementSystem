/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MODEL;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;
/**
 *
 * @author destin
 */
@Entity
public class Rooms implements Serializable {
    private static final long serialVersionUID = 5149641714150001821L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;
    private String room_no;
    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;
    @OneToMany(mappedBy = "room")
    private List<Inpatients> patient = new ArrayList<>();

    public Rooms() {
    }

    public Rooms(String room_no) {
        this.room_no = room_no;
    }

    public Rooms(Integer Id, String room_no, Department department) {
        this.Id = Id;
        this.room_no = room_no;
        this.department = department;
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer Id) {
        this.Id = Id;
    }

    public String getRoom_no() {
        return room_no;
    }

    public void setRoom_no(String room_no) {
        this.room_no = room_no;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public List<Inpatients> getPatient() {
        return patient;
    }

    public void setPatient(List<Inpatients> patient) {
        this.patient = patient;
    }
    
    
}
