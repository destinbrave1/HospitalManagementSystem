package MODEL;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

@Entity
public class Stuff implements Serializable {
    private static final long serialVersionUID = 5149641714150001821L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String stuffId;
    private String stuffUsername;
    private String stuffEmail_address;
    private String stuffPhone_number;

    @ManyToOne
    @JoinColumn(name="depart_id")
    private Department department;
    private String stuffFunction;
    private String password;
    @Column(name = "image", columnDefinition = "LONGBLOB", length = Integer.MAX_VALUE)
    private byte[] image;

    @OneToMany(mappedBy = "stuff", cascade = CascadeType.ALL)
    private transient List<Diagnosis> diagnosis = new ArrayList<>();

    public Stuff() {
    }

    public Stuff(String stuffId) {
        this.stuffId = stuffId;
    }

    public Stuff(Integer id, String stuffId, String stuffUsername, String stuffEmail_address, String stuffPhone_number, Department department, String password, byte[] image) {
        this.id = id;
        this.stuffId = stuffId;
        this.stuffUsername = stuffUsername;
        this.stuffEmail_address = stuffEmail_address;
        this.stuffPhone_number = stuffPhone_number;
        this.department = department;
        this.password = password;
        this.image = image;
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

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public List<Diagnosis> getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(List<Diagnosis> diagnosis) {
        this.diagnosis = diagnosis;
    }

    public String getStuffFunction() {
        return stuffFunction;
    }

    public void setStuffFunction(String stuffFunction) {
        this.stuffFunction = stuffFunction;
    }

    
}
