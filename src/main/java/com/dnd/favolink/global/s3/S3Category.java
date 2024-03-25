package com.dnd.favolink.global.s3;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum S3Category {
    PROFILE_IMAGE("profile-image");

    String category;
}
