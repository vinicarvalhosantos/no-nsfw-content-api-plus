package com.vinicius.santos.nonsfwcontentapiplus.model.entity;

import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "guild", indexes = @Index(columnList = "guildId"))
public class Guild implements Domain {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column(unique = true, nullable = false)
    private Long guildId;

    @Column(nullable = false)
    private String guildName;

    @Column(nullable = false)
    private Long ownerId;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    @ApiModelProperty(hidden = true)
    private Collection<UserGuilds> users;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getGuildId() {
        return guildId;
    }

    public void setGuildId(Long guildId) {
        this.guildId = guildId;
    }

    public String getGuildName() {
        return guildName;
    }

    public void setGuildName(String guildName) {
        this.guildName = guildName;
    }

    public Long getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Long ownerId) {
        this.ownerId = ownerId;
    }

    public Collection<UserGuilds> getUsers() {
        return users;
    }

    public void setUsers(Collection<UserGuilds> users) {
        this.users = users;
    }
}
