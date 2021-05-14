package com.vinicius.santos.nonsfwcontentapiplus.service.impl;

import com.vinicius.santos.nonsfwcontentapiplus.model.entity.Guild;
import com.vinicius.santos.nonsfwcontentapiplus.repository.GuildRepository;
import com.vinicius.santos.nonsfwcontentapiplus.service.GuildService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GuildServiceImpl implements GuildService {

    @Autowired
    GuildRepository guildRepository;

    @Override
    public Guild createGuild(Guild guild) {
        return guildRepository.save(guild);
    }
}
