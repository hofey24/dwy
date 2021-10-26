package com.hofey.dwy.demo.jwt;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import lombok.extern.slf4j.Slf4j;

/**
 * @Author: hofey
 * @Date: 2021/10/26 15:56
 * @Description:
 */
@Slf4j
public class JwtTest {

    public static String JWT_SECRET ="secret";


    public static void createJwtToken(){
        try {
            Algorithm algorithm = Algorithm.HMAC256(JWT_SECRET);
            String token = JWT.create().withClaim("userid","1")
                    .withClaim("userName","kobe")
                    .sign(algorithm);

            System.out.println(token);
        } catch (JWTCreationException exception){
            //Invalid Signing configuration / Couldn't convert Claims.
        }
    }
    
    /**
     * @Author: hofey
     * @Date: 2021/10/26 16:16
     * @Description: 校验token
     * @Param
     */
    public static void verifierToken(String token){
        try {
            Algorithm algorithm = Algorithm.HMAC256(JWT_SECRET);
            JWTVerifier verifier = JWT.require(algorithm)
                    .build(); //Reusable verifier instance
            DecodedJWT jwt = verifier.verify(token);
            System.out.println(jwt.getClaim("userid").asString());
            System.out.println(jwt.getClaim("userName").asString());
        } catch (JWTVerificationException exception){
            //Invalid signature/claims
            log.error(exception.getMessage(),exception);
        }
    }


    public static void main(String[] args) {
        //createJwtToken();
        verifierToken("eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJ1c2VyTmFtZSI6ImtvYmUiLCJ1c2VyaWQiOiIxIn0.FmBWWmR1JeyLTAFFrqX2ljs237icBtudT1vSmHgeu2I");

    }




}
