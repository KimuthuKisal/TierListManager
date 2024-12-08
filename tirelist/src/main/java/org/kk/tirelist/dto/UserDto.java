package org.kk.tirelist.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class UserDto {
    private final Long id;
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
    private int userAccountStatus;
    private LocalDateTime createdOn;
    private LocalDateTime deletedOn;

    public UserDto(Long id, String firstName, String lastName, String userName, String userEmail, String nic, LocalDate dob, String contactNumber, String address, String profileImage, String workingStatus, int userAccountStatus, LocalDateTime createdOn, LocalDateTime deletedOn) {
        this.id = id;
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
        this.userAccountStatus = userAccountStatus;
        this.createdOn = createdOn;
        this.deletedOn = deletedOn;
    };

    // Getters
    public Long getId() { return id; }
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
    public int getUserAccountStatus() { return userAccountStatus; }
    public LocalDateTime getCreatedOn() { return createdOn; }
    public LocalDateTime getDeletedOn() { return deletedOn; }

    // Setters
    // public void setId(Long id) { this.id = id; }
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
    public void setUserAccountStatus(int userAccountStatus) { this.userAccountStatus = userAccountStatus; }
    public void setCreatedOn(LocalDateTime createdOn) { this.createdOn = createdOn; }
    public void setDeletedOn(LocalDateTime deletedOn) { this.deletedOn = deletedOn; }
}
