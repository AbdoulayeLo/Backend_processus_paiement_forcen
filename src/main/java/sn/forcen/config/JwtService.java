package sn.forcen.config;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;

@Service
public class JwtService {

//#3
    private static final String SECRET_KEY="5f96d723508a13105519e20e1c0d3a4a";
//#1
    public String extractUsername(String token) {
        return extractClaim(token,Claims::getSubject);
    }
//#5
    public <T> T extractClaim(String token , Function<Claims,T> claimsTResolver){
        final  Claims claims = extractAllClaims(token);
        return claimsTResolver.apply(claims);
    }
//#7
    public String generateToken(UserDetails userDetails) {
        return generateToken(new HashMap<>(), userDetails);
}
//#6
    public String generateToken(Map<String, Objects> extraClaims, UserDetails userDetails){
        return Jwts
                .builder()
                .setClaims(extraClaims)
                .setSubject(userDetails.getUsername())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis()+1000 * 60 * 24))
                .signWith(getSignInKey(), SignatureAlgorithm.HS256)
                .compact();

    }
//#8
    public boolean isTokenValid(String token, UserDetails userDetails) {
        final String username = extractUsername(token);
        return (username.equals(userDetails.getUsername())) && !isTokenExpired(token);
    }
//#9
    private boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }
//#10
    private Date extractExpiration(String token) {
        return  extractClaim(token, Claims::getExpiration);
    }

    //#2
    private Claims extractAllClaims(String token){
        return Jwts
                .parserBuilder()
                .setSigningKey(getSignInKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

//#4
    private Key getSignInKey() {
         byte[] keyBytes = Decoders.BASE64.decode(SECRET_KEY);
        return Keys.hmacShaKeyFor(keyBytes);
    }
}
