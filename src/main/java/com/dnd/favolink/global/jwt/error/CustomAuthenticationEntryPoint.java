package com.dnd.favolink.global.jwt.error;

import com.dnd.favolink.global.common.response.ErrorResponse;
import com.dnd.favolink.global.error.code.CommonErrorCode;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;
import com.dnd.favolink.global.error.code.ErrorCode;

import java.io.IOException;

@Component
public class CustomAuthenticationEntryPoint implements AuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException {
        String exception = (String)request.getAttribute("exception");

        if (exception == null) {
            setErrorResponse(response, CommonErrorCode.UNAUTHORIZED);
        }
        else if (exception.equals(JwtErrorCode.INVALID_TOKEN.getCode())) {
            setErrorResponse(response, JwtErrorCode.INVALID_TOKEN);
        }
        else if (exception.equals(JwtErrorCode.EXPIRED_TOKEN.getCode())) {
            setErrorResponse(response, JwtErrorCode.EXPIRED_TOKEN);
        }
        else {
            setErrorResponse(response, CommonErrorCode.UNAUTHORIZED);
        }
    }

    private void setErrorResponse(HttpServletResponse response, ErrorCode errorCode) throws IOException {
        response.setContentType("application/json;charset=UTF-8");
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);

        ErrorResponse errorResponse = ErrorResponse.of(errorCode);

        ObjectMapper objectMapper = new ObjectMapper();
        String errorResponseJson = objectMapper.writeValueAsString(errorResponse);

        response.getWriter().print(errorResponseJson);
    }
}
