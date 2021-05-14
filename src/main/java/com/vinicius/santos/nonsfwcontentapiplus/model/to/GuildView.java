package com.vinicius.santos.nonsfwcontentapiplus.model.to;

public class GuildView {

    private Long id;

    private Long guildId;

    private String guildName;

    private Long ownerId;

    public GuildView() {
    }

    public GuildView(Long id, Long guildId, String guildName, Long ownerId) {
        this.id = id;
        this.guildId = guildId;
        this.guildName = guildName;
        this.ownerId = ownerId;
    }

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
}
