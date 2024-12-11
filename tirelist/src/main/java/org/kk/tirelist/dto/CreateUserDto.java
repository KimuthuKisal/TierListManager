package org.kk.tirelist.dto;

import javax.validation.constraints.NotEmpty;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class CreateUserDto {
    @NotBlank
    private String firstName;
    @NotBlank
    private String lastName;
    @NotBlank
    private String userName;
    @NotBlank
    private String userEmail;
    @NotBlank
    private String nic;
    @NotBlank
    private LocalDate dob;
    private String contactNumber;
    private String address;
    private String profileImage;
    private String workingStatus;
    @NotBlank
    @Size(min=8, message = "Password should be contain at least 8 characters.")
    @Pattern(
        regexp = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\W).+$",
        message = "Password must contain at least 1 uppercase letter, 1 lowercase letter, and 1 special character."
    )
    private String password;

    public CreateUserDto(String firstName, String lastName, String userName, String userEmail, String nic, LocalDate dob, String contactNumber, String address, String profileImage, String workingStatus, int userAccountStatus, LocalDateTime createdOn, LocalDateTime deletedOn, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.userEmail = userEmail;
        this.nic = nic;
        this.dob = dob;
        this.contactNumber = contactNumber;
        this.address = address;
        this.profileImage = profileImage;
        this.workingStatus = workingStatus;
        this.password = password;
    };

    // Getters
    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public String getUserName() { return userName; }
    public String getUserEmail() { return userEmail; }
    public String getNic() { return nic; }
    public LocalDate getDob() { return dob; }
    public String getContactNumber() { return contactNumber; }
    public String getAddress() { return address; }
    public String getProfileImage() { return profileImage; }
    public String getWorkingStatus() { return workingStatus; }
    public String getPassword() { return password; }

    // Setters
    public void setFirstName(String firstName) { this.firstName = firstName; }
    public void setLastName(String lastName) { this.lastName = lastName; }
    public void setUserName(String userName) { this.userName = userName; }
    public void setUserEmail(String userEmail) { this.userEmail = userEmail; }
    public void setNic(String nic) { this.nic = nic; }
    public void setDob(LocalDate dob) { this.dob = dob; }
    public void setContactNumber(String contactNumber) { this.contactNumber = contactNumber; }
    public void setAddress(String address) { this.address = address; }
    public void setProfileImage(String profileImage) { this.profileImage = profileImage; }
    public void setWorkingStatus(String workingStatus) { this.workingStatus = workingStatus; }
    public void setPassword(String password) { this.password = password; }

}
