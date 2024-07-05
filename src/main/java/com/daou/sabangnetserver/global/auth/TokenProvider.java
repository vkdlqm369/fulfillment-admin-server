/*토큰 발급 및 검증 수행 */
package com.daou.sabangnetserver.global.auth;
import io.jsonwebtoken.*;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import lombok.extern.slf4j.Slf4j;
import lombok.RequiredArgsConstructor;
import ch.qos.logback.classic.Logger;
import org.apache.catalina.User;
import org.springframework.stereotype.Component;
import org.springframework.security.core.Authentication;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import java.util.Date;
import java.util.Arrays;
import java.security.Key;
import java.util.Collection;
import java.util.stream.Collectors;
/*위의 패키지 내용 확인하기*/

@Slf4j
@RequiredArgsConstructor
@Component
public class TokenProvider {

    private static final long ACCESS_TOKEN_EXPIRATION = 1000 * 60 * 30; //30분
    private final Key key;


    public TokenProvider(@Value("${jwt.secret}") String secretKey) {
        byte[] keyBytes = Decoders.BASE64.decode(secretKey);
        this.key = Keys.hmacShaKeyFor(keyBytes);
    } //yml에서 secret값 가져오기(key에 저장), Base64로 디코딩, HMAC SHA 키 생성
      //issuer 추가하고 불러오기

    //유저 인증 정보를 가지고 와 AccessToken을 생성하는 메소드
    public TokenInfo generateToken(Authentication authentication) {
        String authorities = authentication.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.joining(","));
        //인증 객체에서 사용자의 권한 정보를 가져옴

        long now = (new Date()).getTime();

        //Access Token 생성
        Date accessTokenSetIn = new Date (now);
        Date accessTokenExpiresIn = new Date (now + ACCESS_TOKEN_EXPIRATION);
        String accessToken = Jwts.builder()
                .subject(authentication.getName())
                .claim("auth", authorities)
                .issuedAt(accessTokenSetIn)//token 발행 시간 정보
                .expiration(accessTokenExpiresIn)//token 만료 시간 정보
                .signWith(key, SignatureAlgorithm.HS256)
                .compact();

        return TokenInfo.builder()
                .grantType("Bearer")
                .accessToken(accessToken)
                .build();
    }

    //JWT 토큰 복호화 메소드
    public Authentication getAuthentication(String accessToken) {
        Claims claims = parseClaims(accessToken);

        if(claims.get("auth") == null) {
            throw new RuntimeException("해당 토큰의 권한 정보가 없습니다.");
        }

        //claim의 권한 정보 가져오기
        Collection<?extends GrantedAuthority> authorities =
                Arrays.stream(claims.get("auth").toString().split(","))
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());

        //UserDetails로 Authentication 리턴
        UserDetails principal = new User(claims.getSubject(), "", authorities); // 유저 정보 설정 필요
        return new UsernamePasswordAuthenticationToken(principal, "", authorities);
    }

    //토큰 정보(유효성) 검증
    public boolean validateToken(String token) {
        Logger log = null;
        try {
            Jwts.parser()
                    .setSigningKey(key)
                    .build()
                    .parseClaimsJws(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

//    public boolean validateToken(String token) {
//        Logger log = null;
//        try {
//            Jwts.parserBuilder()
//                    .setSigningKey(key)
//                    .build()
//                    .parseClaimsJws(token);
//            return true;
//        } catch (io.jsonwebtoken.security.SecurityException | MalformedJwtException e) {
//            log.info("유효하지 않은 토큰입니다", e);
//        } catch (ExpiredJwtException e) {
//            log.info("만료된 토큰입니다", e);
//        } catch (UnsupportedJwtException e) {
//            log.info("지원하지 않는 토큰입니다", e);
//        } catch (IllegalArgumentException e) {
//            log.info("빈 토큰입니다", e);
//        }
//        return false;
//    } //log 초기화 안됨 -> 초기화함
        //log 초기화 함 -> NullPointerError발생 가능

    private Claims parseClaims(String accessToken) {
        try {
            return Jwts.parser().setSigningKey(key).build().parseClaimsJws(accessToken).getBody();
        } catch (ExpiredJwtException e) {
            return e.getClaims();
        }
    }

}

