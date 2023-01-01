package com.example.book_store.dto;

import com.example.book_store.model.User;
import com.example.book_store.validation.TimeValidation;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class CustomerDto implements Validator {

    private Integer id;
    @NotBlank(message = "please input your name")
    @Size(min = 4, max = 32, message = "Name should be more than 4 and less than 28 characters")
    private String name;

    @NotBlank(message = "please input the phone number")
    @Pattern(regexp = "^((0|[(]84[)][+])9\\d{8})$", message = "please input the vietnam phone number")
    private String phoneNumber;

    @NotBlank(message = "Input the day of birth")
    private String dayOfBirth;

    @NotBlank(message = "input the email")
    @Email(message = "please input the correct format")
    private String email;

    @NotBlank(message = "input the gender")
    private Integer gender;
    @NotBlank(message = "input the address")

    private String address;

    private boolean isDelete;

    private User user;

    public CustomerDto() {
    }

    public CustomerDto(Integer id, String name, String phoneNumber, String dayOfBirth, String email, Integer gender, String address, boolean isDelete, User user) {
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.dayOfBirth = dayOfBirth;
        this.email = email;
        this.gender = gender;
        this.address = address;
        this.isDelete = isDelete;
        this.user = user;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getDayOfBirth() {
        return dayOfBirth;
    }

    public void setDayOfBirth(String dayOfBirth) {
        this.dayOfBirth = dayOfBirth;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public boolean isDelete() {
        return isDelete;
    }

    public void setDelete(boolean delete) {
        isDelete = delete;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        CustomerDto customerDto = (CustomerDto) target;
        TimeValidation.checkAge(customerDto, errors);
    }
}
