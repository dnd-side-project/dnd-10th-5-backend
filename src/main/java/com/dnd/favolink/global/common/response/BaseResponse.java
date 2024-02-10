package com.dnd.favolink.global.common.response;

import org.springframework.http.ResponseEntity;

public class BaseResponse {
    public static <T> ResponseEntity<T> ok(final T data) {
        return ResponseEntity.ok().body(data);
    }
}
