package com.vinicius.santos.nonsfwcontentapiplus.service.impl;

import com.vinicius.santos.nonsfwcontentapiplus.model.entity.Guild;
import com.vinicius.santos.nonsfwcontentapiplus.model.entity.User;
import com.vinicius.santos.nonsfwcontentapiplus.model.entity.UserGuilds;
import com.vinicius.santos.nonsfwcontentapiplus.model.to.*;
import com.vinicius.santos.nonsfwcontentapiplus.repository.GuildRepository;
import com.vinicius.santos.nonsfwcontentapiplus.repository.UserGuildsRepository;
import com.vinicius.santos.nonsfwcontentapiplus.repository.UserRepository;
import com.vinicius.santos.nonsfwcontentapiplus.service.UserGuildsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserGuildsServiceImpl implements UserGuildsService {

    @Autowired
    UserGuildsRepository userGuildsRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    GuildRepository guildRepository;

    @Override
    public UserGuildsCreatedView createUserGuilds(UserGuilds userGuilds) throws Exception {
        try {
            Guild guild = guildRepository.findByGuildId(userGuilds.getGuild().getGuildId());
            User user = userRepository.findUserByUserId(userGuilds.getUser().getUserId());
            if (guild != null && user != null) {
                userGuilds.setUser(user);
                userGuilds.setGuild(guild);
                return this.convertEntityToView(userGuildsRepository.save(userGuilds));
            }
            return null;
        } catch (Exception ex) {
            throw new Exception("FAIL_CREATE_USER_GUILDS", ex);
        }
    }

    @Override
    public UserGuilds deleteUserFromGuilds(Long userId, Long guildId) throws Exception {
        try {
            Guild guild = guildRepository.findGuildByGuildId(guildId);
            User user = userRepository.findUserByUserId(userId);
            UserGuilds userGuilds = userGuildsRepository.findUserGuildsByGuildAndUser(guild, user);
            userGuildsRepository.delete(userGuilds);
            return null;
        } catch (Exception ex) {
            throw new Exception("FAIL_DELETE_USER_GUILDS", ex);
        }
    }

    @Override
    public UserGuildsView getUserGuilds(Long userId) throws Exception {
        try {
            UserGuildsView userGuildsView = null;
            User user = userRepository.findUserByUserId(userId);
            if (user != null) {
                userGuildsView = new UserGuildsView();
                userGuildsView.setId(user.getId());
                userGuildsView.setUserId(user.getUserId());
                userGuildsView.setUsername(user.getUsername());
                userGuildsView.setUserTag(user.getUserTag());

                List<UserGuilds> userGuildsList = userGuildsRepository.findByUserUserId(userId);
                List<GuildView> guildViewList = new ArrayList<>();
                GuildView guildView;
                for (UserGuilds userGuilds : userGuildsList) {
                    guildView = new GuildView();
                    guildView.setId(userGuilds.getGuild().getId());
                    guildView.setGuildId(userGuilds.getGuild().getGuildId());
                    guildView.setGuildName(userGuilds.getGuild().getGuildName());
                    guildView.setOwnerId(userGuilds.getGuild().getOwnerId());

                    guildViewList.add(guildView);
                }

                userGuildsView.setGuilds(guildViewList);

            }
            return userGuildsView;
        } catch (Exception ex) {
            throw new Exception("FAIL_GET_GUILD_USERS", ex);
        }
    }

    @Override
    public GuildUsersView getGuildUsers(Long guildId) throws Exception {
        try {
            Guild guild = guildRepository.findGuildByGuildId(guildId);
            if (guild != null) {
                GuildUsersView guildUsersView = new GuildUsersView();

                guildUsersView.setId(guild.getId());
                guildUsersView.setGuildId(guild.getGuildId());
                guildUsersView.setGuildName(guild.getGuildName());
                guildUsersView.setOwnerId(guild.getOwnerId());

                UserView userView;
                List<UserView> userViewList = new ArrayList<>();

                List<UserGuilds> userGuildsList = userGuildsRepository.findByGuildGuildId(guildId);
                for (UserGuilds userGuilds : userGuildsList) {
                    userView = new UserView();
                    userView.setId(userGuilds.getUser().getId());
                    userView.setUserId(userGuilds.getUser().getUserId());
                    userView.setUsername(userGuilds.getUser().getUsername());
                    userView.setUserTag(userGuilds.getUser().getUserTag());

                    userViewList.add(userView);
                }

                guildUsersView.setUsers(userViewList);
                return guildUsersView;
            }
            return null;
        } catch (Exception ex) {
            throw new Exception("FAIL_GET_GUILD_USERS", ex);
        }
    }

    private UserGuildsCreatedView convertEntityToView(UserGuilds userGuilds) throws Exception {
        try {
            UserGuildsCreatedView userGuildsCreatedView = new UserGuildsCreatedView();
            UserView userView = new UserView();
            GuildView guildView = new GuildView();
            userView.setId(userGuilds.getUser().getId());
            userView.setUserId(userGuilds.getUser().getUserId());
            userView.setUsername(userGuilds.getUser().getUsername());
            userView.setUserTag(userGuilds.getUser().getUserTag());
            guildView.setId(userGuilds.getGuild().getId());
            guildView.setGuildId(userGuilds.getGuild().getGuildId());
            guildView.setGuildName(userGuilds.getGuild().getGuildName());
            guildView.setOwnerId(userGuilds.getGuild().getOwnerId());
            userGuildsCreatedView.setId(userGuilds.getId());

            userGuildsCreatedView.setUser(userView);
            userGuildsCreatedView.setGuild(guildView);

            return userGuildsCreatedView;
        } catch (Exception ex) {
            throw new Exception("FAIL_CONVERT_ETITY_TO_VIEW", ex);
        }
    }
}
