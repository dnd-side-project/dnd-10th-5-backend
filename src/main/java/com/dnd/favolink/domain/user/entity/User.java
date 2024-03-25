package com.dnd.favolink.domain.user.entity;

import com.dnd.favolink.global.common.entity.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;

    private String oauthId;

    private String nickname;

    private String profileImg;

    private LoginType loginType;

    @Builder
    public User(String oauthId, String nickname, String profileImg, LoginType loginType) {
        this.oauthId = oauthId;
        this.nickname = nickname;
        this.profileImg = profileImg;
        this.loginType = loginType;
    }
}
