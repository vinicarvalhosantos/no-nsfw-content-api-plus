package com.vinicius.santos.nonsfwcontentapiplus.service;


import com.vinicius.santos.nonsfwcontentapiplus.model.entity.UserGuilds;
import com.vinicius.santos.nonsfwcontentapiplus.model.to.GuildUsersView;
import com.vinicius.santos.nonsfwcontentapiplus.model.to.UserGuildsCreatedView;
import com.vinicius.santos.nonsfwcontentapiplus.model.to.UserGuildsView;

public interface UserGuildsService {

    UserGuildsCreatedView createUserGuilds(UserGuilds userGuilds) throws Exception;

    UserGuilds deleteUserFromGuilds(Long userId, Long guildId) throws Exception;

    UserGuildsView getUserGuilds(Long userId) throws Exception;

    GuildUsersView getGuildUsers(Long guildId) throws Exception;

}
