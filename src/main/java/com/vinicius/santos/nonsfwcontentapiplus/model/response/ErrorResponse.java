package com.vinicius.santos.nonsfwcontentapiplus.model.response;

public class ErrorResponse {

    private String developerMessage;

    private String userMessage;

    private String moreInfo;

    private int errorCode;

    public ErrorResponse() {
    }

    public ErrorResponse(String developerMessage, String userMessage, String moreInfo, int errorCode) {
        this.developerMessage = developerMessage;
        this.userMessage = userMessage;
        this.moreInfo = moreInfo;
        this.errorCode = errorCode;
    }

    public String getDeveloperMessage() {
        return developerMessage;
    }

    public void setDeveloperMessage(String developerMessage) {
        this.developerMessage = developerMessage;
    }

    public String getUserMessage() {
        return userMessage;
    }

    public void setUserMessage(String userMessage) {
        this.userMessage = userMessage;
    }

    public String getMoreInfo() {
        return moreInfo;
    }

    public void setMoreInfo(String moreInfo) {
        this.moreInfo = moreInfo;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }
}
