/*application.yml에 작성한 값 매핑*/
package com.daou.sabangnetserver.global.auth;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;


@Getter
@Setter
@Component
@Data
@ConfigurationProperties("jwt")
public class JwtProperties {
    private String issuer;
    private String secretKey;
}