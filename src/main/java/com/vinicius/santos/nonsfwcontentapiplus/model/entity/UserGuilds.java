package com.vinicius.santos.nonsfwcontentapiplus.model.entity;

import javax.persistence.*;

@Entity
@Table(name = "user_guilds", indexes = @Index(columnList = "user_id, guild_id"))
public class UserGuilds implements Domain{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @ManyToOne(optional = false)
    private User user;

    @ManyToOne(optional = false)
    private Guild guild;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Guild getGuild() {
        return guild;
    }

    public void setGuild(Guild guild) {
        this.guild = guild;
    }
}
