package com.vinicius.santos.nonsfwcontentapiplus.model.to;

public class UserView {

    private Long id;

    private Long userId;

    private String username;

    private String userTag;

    public UserView() {
    }

    public UserView(Long id, Long userId, String username, String userTag) {
        this.id = id;
        this.userId = userId;
        this.username = username;
        this.userTag = userTag;
    }

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
}
