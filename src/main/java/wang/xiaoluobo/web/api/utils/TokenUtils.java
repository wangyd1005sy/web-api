package wang.xiaoluobo.web.api.utils;

import com.alibaba.fastjson.JSON;
import com.nimbusds.jose.JOSEException;
import com.nimbusds.jose.JWSAlgorithm;
import com.nimbusds.jose.JWSHeader;
import com.nimbusds.jose.JWSVerifier;
import com.nimbusds.jose.crypto.MACSigner;
import com.nimbusds.jose.crypto.MACVerifier;
import com.nimbusds.jwt.JWTClaimsSet;
import com.nimbusds.jwt.SignedJWT;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public final class TokenUtils {

    private static final byte[] SECRET = "QWERTpoiuyasdfghjklMNBVCXZ1234567890".getBytes();

    private static final long EXPIRE_TIME = 30 * 24 * 60 * 60 * 1000L;

    public static void main(String[] args) {
        String token = buildJWT(1L, "wangyandong", 1L);
        System.out.println(token);

        System.out.println(JSON.toJSONString(checkToken("eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ3eS13ZWIiLCJpc3MiOiJodHRwOlwvXC93d3cueGlhb2x1b2JvLndhbmciLCJpZCI6MSwiZXhwIjoxNTkwMjg0NjY5LCJ1c2VybmFtZSI6Indhbmd5YW5kb25nIiwiZ3JvdXAiOjF9.nAp1qItiO2UFUUGj1M8_uAPqFCf28rfzeUrG1T9mKS0")));
    }

    public static String buildJWT(Long id, String username, Long group) {
        try {
            MACSigner macSigner = new MACSigner(SECRET);
            JWTClaimsSet claimsSet = new JWTClaimsSet.Builder()
                    .subject("my-web-learning")
                    .issuer("http://www.xiaoluobo.wang")
                    .expirationTime(new Date(System.currentTimeMillis() + EXPIRE_TIME))
                    .claim("id", id)
                    .claim("username", username)
                    .claim("group", group)
                    .build();

            SignedJWT signedJWT = new SignedJWT(new JWSHeader(JWSAlgorithm.HS256), claimsSet);
            signedJWT.sign(macSigner);
            return signedJWT.serialize();
        } catch (JOSEException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static List<String> checkToken(String token) {
        try {
            List<String> list = new ArrayList<>();
            SignedJWT jwt = SignedJWT.parse(token);
            JWSVerifier verifier = new MACVerifier(SECRET);
            if (!jwt.verify(verifier)) {
                return list;
            }

            Date expirationTime = jwt.getJWTClaimsSet().getExpirationTime();
            if (new Date().after(expirationTime)) {
                return list;
            }

            Object id = jwt.getJWTClaimsSet().getClaim("id");
            Object username = jwt.getJWTClaimsSet().getClaim("username");
            Object group = jwt.getJWTClaimsSet().getClaim("group");
            if (Objects.isNull(id) || Objects.isNull(username) || Objects.isNull(group)) {
                return list;
            }

            list.add(String.valueOf(id));
            list.add(String.valueOf(username));
            list.add(String.valueOf(group));
            return list;
        } catch (ParseException | JOSEException e) {
            e.printStackTrace();
        }
        return null;
    }
}
