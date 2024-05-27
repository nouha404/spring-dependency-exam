package org.ohara.maVraiDep.data.security.services;

import org.springframework.security.core.GrantedAuthority;

import java.security.Key;
import java.util.Collection;
import java.util.Date;
import java.util.Map;
import io.jsonwebtoken.Claims;
import org.springframework.security.core.userdetails.UserDetails;

public interface JwtService {
    //String generateToken(String username, Collection<? extends GrantedAuthority> authorities);
    String createToken(String username, Map<String, Object> clains);
    String createToken(String username);
    Key getSignKey();
    Claims extractAllClaim(String token);
    String  extractUsername(String token);
    Date extractExpiration(String token);
    Boolean isTokenExpired(String token);
    Boolean validateToken(String token, UserDetails userDetails);
}
