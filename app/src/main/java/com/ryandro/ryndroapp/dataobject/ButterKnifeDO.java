package com.ryandro.ryndroapp.dataobject;

/**
 * Created by WIN 1O on 04-04-2018.
 */

public class ButterKnifeDO {
    private String messageTime = "";
    private String messageBy = "";
    private String message = "";
    private boolean isAvailable ;

    public ButterKnifeDO(String messageTime, String messageBy, String message, boolean isAvailable) {
        this.messageTime = messageTime;
        this.messageBy = messageBy;
        this.message = message;
        this.isAvailable = isAvailable;
    }

    public String getMessageTime() {
        return messageTime;
    }

    public void setMessageTime(String messageTime) {
        this.messageTime = messageTime;
    }

    public String getMessageBy() {
        return messageBy;
    }

    public void setMessageBy(String messageBy) {
        this.messageBy = messageBy;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }
}
