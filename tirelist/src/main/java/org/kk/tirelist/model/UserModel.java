package org.kk.tirelist.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name="Users")
public class UserModel {
    // Attributes
    @Id
    @Column(name="UserId")
    @GeneratedValue(strategy = GenerationTYpe.IDENTITY)
    private final int id;
    @NotBlank(message = "First Name cannot be empty.")
    @Column(name="firstName")
    private final String firstName;
    @NotBlank
    @Column(name="lastName")
    private final String lastName;
    @NotBlank
    @Column(name="userName")
    private final String userName;
    @NotBlank
    @Column(name="userEmail")
    private final String userEmail;
    @NotBlank
    @Column(name="nic")
    private final String nic;
    @Column(name="dob")
    private final LocalDate dob;
    @Column(name="contactNumber")
    private final String contactNumber;
    @Column(name="address")
    private final String address;
    @Column(name="profileImage")
    private final String profileImage;
    @Column(name="workingStatus")
    private final String workingStatus;
    @Column(name="userAccountStatus")
    private final int userAccountStatus;    // Active=1, Inactive=0, Deleted=-1, Suspended=-2 etc...
    @Column(name="createdOn")
    private final LocalDateTime createdOn;

    // Constructor
    public UserModel(
        @JsonProperty("id") int id,
        @JsonProperty("firstName")String firstName,
        @JsonProperty("lastName")String lastName,
        @JsonProperty("userName")String userName,
        @JsonProperty("userEmail")String userEmail,
        @JsonProperty("nic")String nic,
        @JsonProperty("dob")LocalDate dob,
        @JsonProperty("contactNumber")String contactNumber,
        @JsonProperty("address")String address,
        @JsonProperty("profileImage")String profileImage,
        @JsonProperty("workingStatus")String workingStatus,
        @JsonProperty("userAccountStatus")int userAccountStatus,
        @JsonProperty("createdOn")LocalDateTime createdOn
    ) {
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
    }

    // Getters
    public int getId() { return id; }
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
}
