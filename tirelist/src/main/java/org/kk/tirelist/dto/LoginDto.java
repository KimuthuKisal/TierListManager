package org.kk.tirelist.dto;
import jakarta.validation.constraints.NotBlank;

public class LoginDto {

    @NotBlank
    private String userName;
    @NotBlank
    private String password;

    public LoginDto(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public LoginDto() {
    }

    public String getUserName() { return userName; }
    public void setUserName(String userName) { this.userName = userName; }
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

}
