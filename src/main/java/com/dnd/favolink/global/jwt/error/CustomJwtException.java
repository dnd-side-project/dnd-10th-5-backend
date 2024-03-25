package com.dnd.favolink.global.jwt.error;

import com.dnd.favolink.global.error.exception.BusinessException;
import lombok.Getter;

@Getter
public class CustomJwtException extends BusinessException {
    public CustomJwtException(JwtErrorCode errorCode) {
        super(errorCode);
    }
}
