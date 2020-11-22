package com.example.practice7.model;

public class MemberDTO {
    private String name, email, phone, addr;

    public MemberDTO() {
    }
    public MemberDTO(String name, String email, String phone, String addr) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.addr = addr;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }
}
