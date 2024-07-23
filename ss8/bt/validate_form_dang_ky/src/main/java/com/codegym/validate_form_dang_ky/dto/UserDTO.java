package com.codegym.validate_form_dang_ky.dto;


import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class UserDTO {

    @NotNull(message = "Tên không được để trống")
    @Size(min = 5, max = 45, message = "Phải có độ dài tối thiểu 5, độ dài tối đa là 45")
    private String firstName;

    @NotNull(message = "Tên không được để trống")
    @Size(min = 5, max = 45, message = "Phải có độ dài tối thiểu 5, độ dài tối đa là 45")
    private String lastName;

    @NotNull(message = "Số điện thoại không được để trống")
    @Pattern(regexp = "^[0-9]$", message = "Số điện thoại không được chứa chữ")
    private String phoneNumber;

    @Min(value = 18, message = "Tuổi phải lớn hơn 18")
    private int age;

    @Pattern(regexp = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,100}$", message = "Email chưa đúng định dạng")
    private String email;

    public UserDTO() {
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
