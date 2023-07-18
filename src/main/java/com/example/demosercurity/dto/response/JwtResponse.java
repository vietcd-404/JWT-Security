package com.example.demosercurity.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;
import java.util.GregorianCalendar;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class JwtResponse {
    String token;
    private String type = "Bearer";
    private String name;
    private Collection<? extends GrantedAuthority> roles;

//    public JwtResponse(String token, String name, Collection<? extends GrantedAuthority> authorities) {
//    }

    public JwtResponse(String token, String name, Collection<? extends GrantedAuthority> authorities) {
        this.token = token;
        this.name = name;
        this.roles = authorities;
    }
}
