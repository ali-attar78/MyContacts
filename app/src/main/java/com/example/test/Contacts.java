package com.example.test;

public class Contacts {
    String name , phone;
//hi there
    public Contacts(String name,String phone){
        this.name=name;
        this.phone=phone;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}

