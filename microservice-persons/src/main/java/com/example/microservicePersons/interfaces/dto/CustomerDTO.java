package com.example.microservicePersons.interfaces.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public class CustomerDTO {

    private Long id;

    @NotNull(message = "The name is mandatory")
    @NotEmpty(message = "The name is mandatory")
    private String name;

    @NotNull(message = "The address is mandatory")
    private String address;

    @NotNull(message = "The phone is mandatory")
    private String phone;

    @NotNull(message = "The password is mandatory")
    private String password;

    @NotNull(message = "The status is mandatory")
    private String status;

    private String gender;

    private Integer age;

    private String identification;

    public CustomerDTO() {
    }

    public CustomerDTO(Long id, String name, String address, String phone, String password, String status, String gender, Integer age, String identification) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.password = password;
        this.status = status;
        this.gender = gender;
        this.age = age;
        this.identification = identification;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getIdentification() {
        return identification;
    }

    public void setIdentification(String identification) {
        this.identification = identification;
    }
}
