package com.lokesh.loginsignup.database;

public class userEntity {

    String first_name,last_name,email,phone_no,username,password;

    public userEntity(String first_name, String last_name, String email, String phone_no, String username, String password) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.phone_no = phone_no;
        this.username = username;
        this.password = password;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone_no() {
        return phone_no;
    }

    public void setPhone_no(String phone_no) {
        this.phone_no = phone_no;
    }

    public String getUsername() {
        return username;
    }


}
