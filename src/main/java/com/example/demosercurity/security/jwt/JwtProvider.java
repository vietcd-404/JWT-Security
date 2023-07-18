package com.example.demosercurity.security.jwt;

import com.example.demosercurity.security.userpincal.UserPrinciple;
import io.jsonwebtoken.*;
import org.aspectj.weaver.tools.UnsupportedPointcutPrimitiveException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Date;

@Component
public class JwtProvider {
    private static final Logger logger = LoggerFactory.getLogger(JwtProvider.class);
    private String jwtSecret = "vietcd@gmail.com";
    private int jwtExpiration = 86400;



    public String createToken(Authentication authentication) {
        UserPrinciple userPrinciple = (UserPrinciple) authentication.getPrincipal();
        return Jwts.builder().setSubject(userPrinciple.getUsername()).setIssuedAt(new Date()).setExpiration(new Date(new Date().getTime() + jwtExpiration * 1000))
                .signWith(SignatureAlgorithm.HS512, jwtSecret)
                .compact();
    }

    public boolean validateToken(String token) {
        try {
            Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token);
            return true;
        } catch (SignatureException e) {
            e.printStackTrace();
            logger.error("Ivaild JWT sinature -> Message: {}", e);
        } catch (MalformedJwtException e) {
            logger.error("The token invaild format -> Message: {}", e);
        } catch (UnsupportedPointcutPrimitiveException e) {
            logger.error("Unsupported Jwt token -> Message: {}", e);
        } catch (ExpiredJwtException e) {
            logger.error("Expired Jwt token -> Message: {}", e);
        } catch (IllegalArgumentException e) {
            logger.error("Jwt claims string is empty -> Message: {}", e);
        }
        return false;
    }

    public String getUserNameFromToken(String token){
        String userName = Jwts.parser().setSigningKey(jwtSecret)
                .parseClaimsJws(token).getBody().getSubject();
        return userName;
    }
}
