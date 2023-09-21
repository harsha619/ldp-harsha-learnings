package com.sso.security.config;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Base64;
import java.util.function.Function;

@Service
public class JwtService {
    private static  final  String SECRET_KEY="295f1e3f6fb6d95941c1ad56c88e9a887987e4c4c0a8fb47bbac756e81464333";
    public String extractUsername(String token) {
        return null;
    }
    public <T> T extractClaim(String token, Function<Claims,T> claimsResolver){
        final  Claims claims= extractAllClaims(token);
        return claimsResolver.apply(claims);
    }
    public Claims extractAllClaims(String token){
        return Jwts.parserBuilder()
                .setSigningKey(getSigningKey())
                .build()
                .parseClaimsJwt(token)
                .getBody();
    }

    private Key getSigningKey() {
        byte[] keyBytes= Decoders.BASE64.decode(SECRET_KEY);
        return Keys.hmacShaKeyFor(keyBytes);
    }

}
