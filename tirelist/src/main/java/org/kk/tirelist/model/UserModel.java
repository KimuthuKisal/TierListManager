package org.kk.tirelist.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name="users")
public class UserModel {
    // Attributes
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "First Name cannot be empty.")
    @Column(name="first_name", nullable=false)
    private String firstName;
    @NotBlank
    @Column(name="last_name", nullable=false)
    private String lastName;
    @NotBlank
    @Column(name="user_name", nullable=false, unique = true)
    private String userName;
    @NotBlank
    @Column(name="user_email", nullable=false, unique = true)
    private String userEmail;
    @NotBlank
    @Column(name="nic", nullable=false, unique = true)
    private String nic;
    @Column(name="dob")
    private LocalDate dob;
    @Column(name="contact_number")
    private String contactNumber;
    @Column(name="address")
    private String address;
    @Column(name="profile_image")
    private String profileImage;
    @Column(name="working_status")
    private String workingStatus;
    @Column(name="user_account_status")
    private int userAccountStatus;    // Active=1, Inactive=0, Deleted=-1, Suspended=-2 etc...
    @Column(name="created_on")
    private LocalDateTime createdOn;
    @Column(name="deleted_on")
    private LocalDateTime deletedOn;

    // Constructor
    public UserModel(
        @JsonProperty("firstName") String firstName,
        @JsonProperty("lastName") String lastName,
        @JsonProperty("userName") String userName,
        @JsonProperty("userEmail") String userEmail,
        @JsonProperty("nic") String nic,
        @JsonProperty("dob") LocalDate dob,
        @JsonProperty("contactNumber") String contactNumber,
        @JsonProperty("address") String address,
        @JsonProperty("profileImage") String profileImage,
        @JsonProperty("workingStatus") String workingStatus,
        @JsonProperty("userAccountStatus") int userAccountStatus,
        @JsonProperty("createdOn") @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss") LocalDateTime createdOn,
        @JsonProperty("deletedOn") @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss") LocalDateTime deletedOn
    ) {
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
    }

    public UserModel() {
    }

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

    // // Setters
    // public Long setId(Long id) { this.id = id; }
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
