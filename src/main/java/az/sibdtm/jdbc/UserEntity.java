package az.sibdtm.jdbc;

import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class UserEntity {


    private String name;
    private String surname;
    private String username;
    private String password;
    private String email;
    private String extraEmail;
    private Set<String> phoneList=new HashSet<>();
    private Date date;
    public UserEntity() {
    }

    public UserEntity(String name, String surname, String username, String password, String email, String extraEmail, Set<String> phoneList, Date date) {
        this.name = name;
        this.surname = surname;
        this.username = username;
        this.password = password;
        this.email = email;
        this.extraEmail = extraEmail;
        this.phoneList = phoneList;
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



    public Set<String> getPhoneList() {
        return phoneList;
    }

    public void setPhoneList(Set<String> phoneList) {
        this.phoneList = phoneList;
    }

    public Date getDate() {
        return date;
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
}
