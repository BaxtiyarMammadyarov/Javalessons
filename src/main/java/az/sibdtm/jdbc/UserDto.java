package az.sibdtm.jdbc;


import org.json.simple.JSONObject;

import java.sql.Date;


public class UserDto {

private int id;
    private String name;
    private String surname;
    private String username;
    private String password;
    private String email;
    private String extraEmail;
    private JSONObject phoneList;
    private  String address;
    private Date date;
    public UserDto() {
    }

    public UserDto(int id, String name, String surname, String username, String password, String email, String extraEmail, JSONObject phoneList, String address, Date date) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.username = username;
        this.password = password;
        this.email = email;
        this.extraEmail = extraEmail;
        this.phoneList = phoneList;
        this.address = address;
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public JSONObject getPhoneList() {
        return phoneList;
    }

    public void setPhoneList(JSONObject phoneList) {
        this.phoneList = phoneList;
    }

    public Date getDate() {
        return date;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getExtraEmail() {
        return extraEmail;
    }

    public void setExtraEmail(String extraEmail) {
        this.extraEmail = extraEmail;
    }

    @Override
    public String toString() {
        return "UserEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", extraEmail='" + extraEmail + '\'' +
                ", phoneList=" + phoneList +
                ", date=" + date +
                '}';
    }
}
