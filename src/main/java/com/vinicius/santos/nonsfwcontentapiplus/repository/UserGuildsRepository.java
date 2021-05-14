package com.vinicius.santos.nonsfwcontentapiplus.repository;

import com.vinicius.santos.nonsfwcontentapiplus.model.entity.Guild;
import com.vinicius.santos.nonsfwcontentapiplus.model.entity.User;
import com.vinicius.santos.nonsfwcontentapiplus.model.entity.UserGuilds;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserGuildsRepository extends JpaRepository<UserGuilds, Long> {

    List<UserGuilds> findByUserUserId(Long userId);

    UserGuilds findByUserIdAndGuildId(Long userId, Long guildId);

    UserGuilds findUserGuildsByGuildAndUser(Guild guild, User user);

    List<UserGuilds> findByGuildGuildId(Long guildId);

}
