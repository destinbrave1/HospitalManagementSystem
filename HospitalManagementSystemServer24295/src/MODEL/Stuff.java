/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MODEL;

import java.sql.Blob;
import java.util.List;
import javax.persistence.*;

/**
 *
 * @author destin
 */
@Entity
public class Stuff {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String stuffId;
    private String stuffUsername;
    private String stuffEmail_address;
    private String stuffPhone_number;
    @ManyToOne
    @JoinColumn(name="department_id")
    private Department department;
    private String password;
    private Blob image;
    @OneToMany(mappedBy = "stuff")
    private List<Diagnosis> diagnosis;
    // New attribute for Base64-encoded image data
    private String base64Image;

    public Stuff() {
    }

    public Stuff(String stuffId) {
        this.stuffId = stuffId;
    }

    public Stuff(Integer id, String stuffId, String stuffUsername, String stuffEmail_address, String stuffPhone_number, Department department, String password, Blob image, List<Diagnosis> diagnosis, String base64Image) {
        this.id = id;
        this.stuffId = stuffId;
        this.stuffUsername = stuffUsername;
        this.stuffEmail_address = stuffEmail_address;
        this.stuffPhone_number = stuffPhone_number;
        this.department = department;
        this.password = password;
        this.image = image;
        this.diagnosis = diagnosis;
        this.base64Image = base64Image;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStuffId() {
        return stuffId;
    }

    public void setStuffId(String stuffId) {
        this.stuffId = stuffId;
    }

    public String getStuffUsername() {
        return stuffUsername;
    }

    public void setStuffUsername(String stuffUsername) {
        this.stuffUsername = stuffUsername;
    }

    public String getStuffEmail_address() {
        return stuffEmail_address;
    }

    public void setStuffEmail_address(String stuffEmail_address) {
        this.stuffEmail_address = stuffEmail_address;
    }

    public String getStuffPhone_number() {
        return stuffPhone_number;
    }

    public void setStuffPhone_number(String stuffPhone_number) {
        this.stuffPhone_number = stuffPhone_number;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Blob getImage() {
        return image;
    }

    public void setImage(Blob image) {
        this.image = image;
    }

    public List<Diagnosis> getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(List<Diagnosis> diagnosis) {
        this.diagnosis = diagnosis;
    }

    public String getBase64Image() {
        return base64Image;
    }

    public void setBase64Image(String base64Image) {
        this.base64Image = base64Image;
    }

   
}
