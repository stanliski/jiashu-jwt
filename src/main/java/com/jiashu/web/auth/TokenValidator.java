package com.jiashu.web.auth;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jiashu.web.auth.constant.ConstantKey;
import com.jiashu.web.entity.dto.Token;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Base64;

/**
 * Created on 2018/4/3 20:04.
 *
 * @author Stanley Huang
 */
@Component
public class TokenValidator {
    private static Logger logger = LoggerFactory.getLogger(TokenValidator.class);
    private static final JwtParser validator = Jwts.parser();

    @Autowired
    private ObjectMapper jsonMapper;

    public TokenValidator() {
        validator.setSigningKey(ConstantKey.SIGNING_KEY);
    }

    public long validToken(String token) {
        Claims claims = validator.parseClaimsJws(token).getBody();
        Integer id =  (Integer) claims.get("id");
        return id.longValue();
    }

    //FIXME: temp code
    public long getUserIdWithoutValidated(String tokenString) {
        String payload = tokenString.split("\\.")[1];
        try {
            byte[] json = Base64.getDecoder().decode(payload);
            Token token = jsonMapper.readValue(json, Token.class);
            return token.getId();
        } catch (IOException ex) {
            logger.error("Fix this in near future!", ex);
            return -1;
        }
    }


}
