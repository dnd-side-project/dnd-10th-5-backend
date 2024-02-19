package com.dnd.favolink.domain.user.repository;

import com.dnd.favolink.domain.user.entity.LoginType;
import com.dnd.favolink.domain.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByOauthIdAndLoginType(String oauthId, LoginType loginType);
}
