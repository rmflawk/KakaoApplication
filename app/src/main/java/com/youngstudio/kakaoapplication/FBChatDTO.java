package com.youngstudio.kakaoapplication;

public class FBChatDTO {

    public static String userName;
    public static String message;

    public FBChatDTO() {}
    public FBChatDTO(String userName, String message) {
        this.userName = userName;
        this.message = message;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getUserName() {
        return userName;
    }

    public String getMessage() {
        return message;
    }
}