package com.vinicius.santos.nonsfwcontentapiplus.repository;

import com.vinicius.santos.nonsfwcontentapiplus.model.entity.Guild;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GuildRepository extends JpaRepository<Guild, Long> {

    Guild findByGuildId(Long id);

    Guild findGuildByGuildId(Long guildId);

}
