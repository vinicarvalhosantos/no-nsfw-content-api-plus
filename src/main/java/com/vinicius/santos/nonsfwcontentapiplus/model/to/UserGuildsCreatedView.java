package com.vinicius.santos.nonsfwcontentapiplus.model.to;

public class UserGuildsCreatedView {

    private Long id;

    private UserView user;

    private GuildView guild;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UserView getUser() {
        return user;
    }

    public void setUser(UserView user) {
        this.user = user;
    }

    public GuildView getGuild() {
        return guild;
    }

    public void setGuild(GuildView guild) {
        this.guild = guild;
    }
}
