package com.vinicius.santos.nonsfwcontentapiplus.repository;

import com.vinicius.santos.nonsfwcontentapiplus.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findUserByUserId(Long userId);

}
