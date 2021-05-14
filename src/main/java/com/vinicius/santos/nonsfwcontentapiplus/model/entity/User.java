package com.vinicius.santos.nonsfwcontentapiplus.model.entity;

import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "user", indexes = @Index(columnList = "userId"))
public class User implements Domain {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column(unique = true, nullable = false)
    private Long userId;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String userTag;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "guild")
    @ApiModelProperty(hidden = true)
    private Collection<UserGuilds> guilds;

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

    public Collection<UserGuilds> getGuilds() {
        return guilds;
    }

    public void setGuilds(Collection<UserGuilds> guilds) {
        this.guilds = guilds;
    }
}
