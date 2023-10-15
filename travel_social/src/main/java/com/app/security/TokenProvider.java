package com.app.security;

import com.app.config.AppProperties;
import com.app.entity.Account;
import com.auth0.jwt.algorithms.Algorithm;
import io.jsonwebtoken.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.function.Function;

@Component
public class TokenProvider {
    String secretKey = "travel social";
    int expiredTokenMsec = 60 * 60 * 1000;
    public final Logger logger = LoggerFactory.getLogger(TokenProvider.class);
    private AppProperties appProperties;

    public TokenProvider(AppProperties appProperties) {
        this.appProperties = appProperties;
    }

    public String generateToken(Account account) {
        Date now = new Date();
        Date expiredDate = new Date(now.getTime() + expiredTokenMsec);
        Algorithm algorithm = Algorithm.HMAC256(secretKey.getBytes());

//        return JWT.create().withSubject(account.getUser_name())
//                .withExpiresAt(expiredDate)
//                .withClaim("roles",account.getRole())
//                .sign(algorithm);

        return Jwts.builder()
                .setSubject(account.getAccountName())
                .claim("role",account.getRole())
                .setIssuedAt(now)
                .setExpiration(expiredDate)
                .signWith(SignatureAlgorithm.HS256, secretKey)
                .compact();
    }
    public String genarateRefershTolen(Account account) {
        Algorithm algorithm = Algorithm.HMAC256(secretKey.getBytes());
        Date now = new Date();
        Date expiredDate = new Date(now.getTime() + expiredTokenMsec);
//        return JWT.create().withSubject(account.getUser_name())
//                .withExpiresAt(expiredDate)
//                .sign(algorithm);
        return    Jwts.builder()
                .setSubject(account.getAccountName())
                .setExpiration(expiredDate)
                .signWith(SignatureAlgorithm.HS256, secretKey)
                .compact();
    }
    public String getUsernameFromToken(String token) {
        Claims claims = Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token).getBody();
        return claims.getSubject();
    }
    public Date getExpirationDateFromToken(String token) {
        return getClaimFromToken(token, Claims::getExpiration);
    }
    public <T> T getClaimFromToken(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = getAllClaimsFromToken(token);
        return claimsResolver.apply(claims);
    }
    private Claims getAllClaimsFromToken(String token) {
        return Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token).getBody();
    }
    private Boolean isTokenExpired(String token) {
        final Date expiration = getExpirationDateFromToken(token);
        return expiration.before(new Date());
    }
    public Boolean validateToken(String token, UserDetails userDetails) {
        final String username = getUsernameFromToken(token);
        return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
    }
    public boolean validateToken(String authToken) {
        try {
            Jwts.parser().setSigningKey(secretKey).parseClaimsJws(authToken);
            return true;
        } catch (SignatureException ex) {
            logger.error("Invalid JWT signature");
            return false;
        } catch (MalformedJwtException ex) {
            logger.error("Invalid JWT token");
            return false;
        } catch (ExpiredJwtException ex) {
            logger.error("Expired JWT token");
            return false;
        } catch (UnsupportedJwtException ex) {
            logger.error("Unsupported JWT token");
            return false;
        } catch (IllegalArgumentException ex) {
            logger.error("JWT claims string is empty.");
            return false;
        }
    }

}
