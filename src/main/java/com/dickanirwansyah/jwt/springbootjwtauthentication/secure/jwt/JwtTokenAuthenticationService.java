package com.dickanirwansyah.jwt.springbootjwtauthentication.secure.jwt;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import static java.util.Collections.emptyList;

public class JwtTokenAuthenticationService {

    //10 HARI
    static final long KADALUARSA_TOKEN = 864_000_000;
    //SECRET TOKEN
    static final String SECRET_TOKEN = "IniSecretToken";
    //PREFIX TOKEN
    static final String PREFIX_TOKEN = "Bearer";
    //HEADER
    static final String HEADER_STRING = "Authorization";

    static void addAuthentication(HttpServletResponse response, String username){

        String JWT = Jwts.builder()
                .setSubject(username)
                .setExpiration(new Date(System.currentTimeMillis() + KADALUARSA_TOKEN))
                .signWith(SignatureAlgorithm.HS512, SECRET_TOKEN)
                .compact();
        //OUTPUT RESPONSE KETIKA DI HADER
        response.addHeader(HEADER_STRING, PREFIX_TOKEN+ " "+JWT);
    }

    static Authentication getAuthentication(HttpServletRequest request){

        String token = request.getHeader(HEADER_STRING);
        if(token!=null){
            String user = Jwts.parser()
                    .setSigningKey(SECRET_TOKEN)
                    .parseClaimsJws(token.replace(PREFIX_TOKEN, ""))
                    .getBody()
                    .getSubject();

            return user!=null
                    ? new UsernamePasswordAuthenticationToken(user, null, emptyList())
                    :null;
        }
        return null;
    }
}
