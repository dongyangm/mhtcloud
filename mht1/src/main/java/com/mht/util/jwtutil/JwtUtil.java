package com.mht.util.jwtutil;

import io.jsonwebtoken.*;

import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;
import java.security.Key;
import java.util.Date;

public class JwtUtil {
	 
    private final static String base64Secret = "MDk4ZjZiY2Q0NjIxZDM3M2NhZGU0ZTgzMjYyN2I0ZjY=";
//    @Value("${system.expiresSecond:172800000}")
//    private  int expiresSecond ;//token过期时间
    private final static int expiresSecond = 7200000;//token过期时间
 
    public  static JwtResult parseJWT(String jsonWebToken) {
    	JwtResult jr = new JwtResult();
        try {
            Claims claims = Jwts.parser()
                    .setSigningKey(DatatypeConverter.parseBase64Binary(base64Secret))
                    .parseClaimsJws(jsonWebToken).getBody();
            jr.setClaims(claims);
            jr.setFlag(0);
//            return claims;
        } catch (ExpiredJwtException ex) {
        	jr.setFlag(1);
        } catch(MalformedJwtException e2){
        	jr.setFlag(2);
        } catch (Exception e){
        	jr.setFlag(3);
        }
        return jr;
    }
 
    public static String createJWT(String username) {
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
 
        long nowMillis = System.currentTimeMillis();
        Date now = new Date(nowMillis);
 
        //生成签名密钥
        byte[] apiKeySecretBytes = DatatypeConverter.parseBase64Binary(base64Secret);
        Key signingKey = new SecretKeySpec(apiKeySecretBytes, signatureAlgorithm.getJcaName());
 
        //添加构成JWT的参数
        JwtBuilder builder = Jwts.builder().setHeaderParam("typ", "JWT")
                .claim("user_name", username)
//                .claim("user_role", roles)
//                .claim("user_privilege", privileges)
                .signWith(signatureAlgorithm, signingKey);
        //添加Token过期时间
        if (expiresSecond >= 0) {
            long expMillis = nowMillis + expiresSecond;
            Date exp = new Date(expMillis);
            builder.setExpiration(exp).setNotBefore(now);
        }
 
        //生成JWT
        return builder.compact();
    }
}

