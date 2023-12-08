/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MODEL;

import java.sql.Blob;

/**
 *
 * @author destin
 */

public class UserAccounts {

    private Integer id;
    private String useriD;
    private String username;
    private String email_address;
    private String phone_number;
    private String department;
    private String password;
    private String repeat_password;
    private Blob image;

    // New attribute for Base64-encoded image data
    private String base64Image;

    public UserAccounts() {
    }

    public UserAccounts(String useriD, String username, String email_address, String phone_number, String password, String repeat_password, Blob image) {
        this.useriD = useriD;
        this.username = username;
        this.email_address = email_address;
        this.phone_number = phone_number;
        this.password = password;
        this.repeat_password = repeat_password;
        this.image = image;
    }

    public String getUseriD() {
        return useriD;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail_address() {
        return email_address;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public String getDepartment() {
        return department;
    }

    public String getPassword() {
        return password;
    }

    public String getRepeat_password() {
        return repeat_password;
    }

    public Blob getImage() {
        return image;
    }

    // New getter and setter for Base64-encoded image data
    public String getBase64Image() {
        return base64Image;
    }

    public void setBase64Image(String base64Image) {
        this.base64Image = base64Image;
    }

    public void setUseriD(String useriD) {
        this.useriD = useriD;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setEmail_address(String email_address) {
        this.email_address = email_address;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRepeat_password(String repeat_password) {
        this.repeat_password = repeat_password;
    }

    public void setImage(Blob image) {
        this.image = image;
    }

}
