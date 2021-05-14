package com.vinicius.santos.nonsfwcontentapiplus.model.to;

import java.util.List;

public class UserGuildsView {

    private Long id;

    private Long userId;

    private String username;

    private String userTag;

    private List<GuildView> guilds;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserTag() {
        return userTag;
    }

    public void setUserTag(String userTag) {
        this.userTag = userTag;
    }

    public List<GuildView> getGuilds() {
        return guilds;
    }

    public void setGuilds(List<GuildView> guilds) {
        this.guilds = guilds;
    }
}
