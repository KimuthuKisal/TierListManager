package org.kk.tirelist.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class CreateUserDto {
    private String firstName;
    private String lastName;
    private String userName;
    private String userEmail;
    private String nic;
    private LocalDate dob;
    private String contactNumber;
    private String address;
    private String profileImage;
    private String workingStatus;

    public CreateUserDto(String firstName, String lastName, String userName, String userEmail, String nic, LocalDate dob, String contactNumber, String address, String profileImage, String workingStatus, int userAccountStatus, LocalDateTime createdOn, LocalDateTime deletedOn) {
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
}
