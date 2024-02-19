package com.dnd.favolink.global.redis;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.Duration;

@Getter
@AllArgsConstructor
public enum RedisPrefix {
    REFRESH_TOKEN(Duration.ofDays(7));

    Duration duration;
}
