package com.dnd.favolink.global.jwt;

import com.dnd.favolink.global.jwt.error.CustomJwtException;
import com.dnd.favolink.global.jwt.error.JwtErrorCode;
import com.dnd.favolink.global.redis.RedisService;
import io.jsonwebtoken.*;
import jakarta.annotation.PostConstruct;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.stereotype.Component;
import java.util.Base64;
import java.util.Date;
import org.springframework.security.core.Authentication;

import static com.dnd.favolink.global.redis.RedisPrefix.REFRESH_TOKEN;

@Slf4j
@Component
@RequiredArgsConstructor
public class JwtTokenProvider {
    @Value("${jwt.secret}")
    private String secretKey;
    @Value("${jwt.access-token-valid-minute}")
    private long accessTokenValidTime;
    @Value("${jwt.refresh-token-valid-minute}")
    private long refreshTokenValidTime;

    private final RedisService redisService;

    @PostConstruct
    protected void init() {
        secretKey = Base64.getEncoder().encodeToString(secretKey.getBytes());
        accessTokenValidTime = accessTokenValidTime * 60 * 1000L;
        refreshTokenValidTime = refreshTokenValidTime * 60 * 1000L;
    }

    public String createAccessToken(Long id) {
        Claims claims = Jwts.claims().setSubject(id.toString());
        Date now = new Date();
        return Jwts.builder()
                .setClaims(claims)
                .setIssuedAt(now)
                .setExpiration(new Date(now.getTime() + accessTokenValidTime))
                .signWith(SignatureAlgorithm.HS256, secretKey)
                .compact();
    }

    public String createRefreshToken(Long id) {
        Claims claims = Jwts.claims().setSubject(id.toString());
        Date now = new Date();
        String token = Jwts.builder()
                .setClaims(claims)
                .setIssuedAt(now)
                .setExpiration(new Date(now.getTime() + refreshTokenValidTime))
                .signWith(SignatureAlgorithm.HS256, secretKey)
                .compact();
        redisService.save(REFRESH_TOKEN, id.toString(), token, REFRESH_TOKEN.getDuration());
        return token;
    }

    public Authentication getAuthentication(String token) {
        Long userId = getUserId(token);
        return new UsernamePasswordAuthenticationToken(userId, null, AuthorityUtils.NO_AUTHORITIES);
    }

    public Long getUserId(String token) {
        return Long.parseLong(Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token).getBody().getSubject());
    }

    public String resolveAccessToken(HttpServletRequest request) {
        String authorization = request.getHeader("Authorization");
        if (authorization == null) {
            return null;
        }
        return authorization.substring("Bearer ".length());
    }

    public boolean validateToken(String jwtToken) {
        if (jwtToken == null) {
            throw new CustomJwtException(JwtErrorCode.EMPTY_TOKEN);
        }

        try {
            Jws<Claims> claims = Jwts.parser().setSigningKey(secretKey).parseClaimsJws(jwtToken);
            return !claims.getBody().getExpiration().before(new Date());
        } catch (SignatureException | MalformedJwtException e) {
            log.info("JWT 토큰이 유효하지 않습니다.");
            throw new CustomJwtException(JwtErrorCode.INVALID_TOKEN);
        } catch (ExpiredJwtException e) {
            log.info("JWT 토큰이 만료되었습니다.");
            throw new CustomJwtException(JwtErrorCode.EXPIRED_TOKEN);
        } catch (UnsupportedJwtException e) {
            log.info("지원하지 않는 JWT 토큰입니다.");
            throw new CustomJwtException(JwtErrorCode.INVALID_TOKEN);
        } catch (IllegalArgumentException e) {
            log.info("JWT 토큰이 잘못되었습니다.");
        }
        return false;
    }
}
