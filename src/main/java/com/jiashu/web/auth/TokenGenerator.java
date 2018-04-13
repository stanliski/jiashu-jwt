package com.jiashu.web.auth;


import com.jiashu.web.auth.constant.ConstantKey;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.UUID;

/**
 * Created on 2018/4/3 20:04.
 *
 * @author Stanley Huang
 */
@Component
public class TokenGenerator {
    private static Logger logger = LoggerFactory.getLogger(TokenGenerator.class);

    public String generateToken(long id, String address) {
        return Jwts.builder()
                .setExpiration(new Date(System.currentTimeMillis() + ConstantKey.LIFE_SPAN_IN_MINUTE * 60 * 1000))
                .claim("id", id)
                .claim("address", address)
                .claim("nonce",UUID.randomUUID().toString())
                .signWith(SignatureAlgorithm.HS256, ConstantKey.SIGNING_KEY)
                .compact();
    }
}
