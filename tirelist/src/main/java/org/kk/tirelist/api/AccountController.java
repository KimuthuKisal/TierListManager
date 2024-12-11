package org.kk.tirelist.api;

import com.nimbusds.jose.jwk.source.ImmutableSecret;
import jakarta.validation.Valid;
import org.kk.tirelist.dto.CreateUserDto;
import org.kk.tirelist.dto.LoginDto;
import org.kk.tirelist.model.UserModel;
import org.kk.tirelist.repository.UserRepository;
import org.kk.tirelist.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.jose.jws.MacAlgorithm;
import org.springframework.security.oauth2.jwt.JwsHeader;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.security.oauth2.jwt.NimbusJwtEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashMap;

@RestController
@RequestMapping("api/v1/user")
public class AccountController {
    @Value("${security.jwt.secret-key}")
    private String jwtSecretKey;
    @Value("${security.jwt.issuer}")
    private String jwtIssuer;
    @Value("${security.jwt.token-expiry}")
    private Long jwtTokenExpiry;

    private UserRepository userRepository;
    private AuthenticationManager authenticationManager;

    @Autowired
    public AccountController(UserRepository userRepository, AuthenticationManager authenticationManager) {
        this.userRepository = userRepository;
        this.authenticationManager = authenticationManager;
    }

    public enum UserAccountStatus {
        INACTIVE,
        ACTIVE,
        DELETED,
        SUSPENDED
    }

    @GetMapping("profile")
    public ResponseEntity<Object> profile(Authentication authentication) {
        var response = new HashMap<String, Object>();
        response.put("Username", authentication.getName());
        response.put("Authorities", authentication.getAuthorities());
        UserModel currUser = userRepository.findByUserName(authentication.getName());
        response.put("User", currUser);
        return ResponseEntity.ok(response);
    }

    @PostMapping("register")
    public ResponseEntity<Object> register(@Valid @RequestBody CreateUserDto createUserDto, BindingResult result) {
        if (result.hasErrors()) {
            var errorList = result.getAllErrors();
            var errorMap = new HashMap<String, String>();
            for (int i=0; i< errorList.size(); i++) {
                var error = (FieldError) errorList.get(i);
                errorMap.put(error.getField(), error.getDefaultMessage());
            }
            return ResponseEntity.badRequest().body(errorMap);
        }

        var bCryptEncoder = new BCryptPasswordEncoder();

        UserModel user = new UserModel();
        user.setFirstName(createUserDto.getFirstName());
        user.setLastName(createUserDto.getLastName());
        user.setUserName(createUserDto.getUserName());
        user.setUserEmail(createUserDto.getUserEmail());
        user.setNic(createUserDto.getNic());
        user.setDob(createUserDto.getDob());
        user.setContactNumber(createUserDto.getContactNumber());
        user.setAddress(createUserDto.getAddress());
        user.setProfileImage(createUserDto.getProfileImage());
        user.setWorkingStatus(createUserDto.getWorkingStatus());
        user.setUserAccountStatus(UserAccountStatus.ACTIVE.ordinal());
        user.setCreatedOn(LocalDateTime.now());
        user.setRole("webuser");
        user.setPassword(bCryptEncoder.encode(createUserDto.getPassword()));

        try {
            var userWithSameUserName = userRepository.findByUserName(createUserDto.getUserName());
            if (userWithSameUserName != null) {
                return ResponseEntity.badRequest().body("Username already exists. Try different username.");
            }
            var userWithSameUserEmail = userRepository.findByUserEmail(createUserDto.getUserEmail());
            if (userWithSameUserEmail != null) {
                return ResponseEntity.badRequest().body("User Email already exists. Try different email.");
            }
            userRepository.save(user);

//            return ResponseEntity.ok("User added");
            String jwtToken = createJwtToken(user);
            var response = new HashMap<String, Object>();
            response.put("token", jwtToken);
            response.put("user", user);
            return ResponseEntity.ok(response);
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        return ResponseEntity.badRequest().body("Error");
    }

    @PostMapping("login")
    public ResponseEntity<Object> login (@Valid @RequestBody LoginDto loginDto, BindingResult result) {
        if (result.hasErrors()) {
            var errorList = result.getAllErrors();
            var errorMap = new HashMap<String, String>();
            for (int i=0; i< errorList.size(); i++) {
                var error = (FieldError) errorList.get(i);
                errorMap.put(error.getField(), error.getDefaultMessage());
            }
            return ResponseEntity.badRequest().body(errorMap);
        }

        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginDto.getUserName(), loginDto.getPassword()));
            UserModel currUser = userRepository.findByUserName(loginDto.getUserName());
            String jwtToken = createJwtToken(currUser);
            var response = new HashMap<String, Object>();
            response.put("token", jwtToken);
            response.put("user", currUser);
            return ResponseEntity.ok(response);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return ResponseEntity.badRequest().body("Username or Password Incorrect.");
    }

    private String createJwtToken(UserModel user) {
        Instant now = Instant.now();
        JwtClaimsSet claims = JwtClaimsSet.builder()
                .issuer(jwtIssuer)
                .issuedAt(now)
                .expiresAt(now.plusSeconds(jwtTokenExpiry))
                .subject(user.getUserName())
                .claim("role", user.getRole())
                .build();

        var encoder = new NimbusJwtEncoder(new ImmutableSecret<>(jwtSecretKey.getBytes()));
        var params = JwtEncoderParameters.from(JwsHeader.with(MacAlgorithm.HS256).build(), claims);
        return encoder.encode(params).getTokenValue();
    }
}
