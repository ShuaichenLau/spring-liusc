package com.liusc.entity;

public class LoginData {

    private String message_type;  // "login_req",
    private String speak_state;  // 0,
    private String token;  // token,
    private User user;  //
    private Long start_time;  // 1557578220000,
    private Long end_time;  // 1557580020000,
    private Support support;  //
    private String class_id;  // CLASS_ID,
    private String user_id;  // user_id

    public String getMessage_type() {
        return message_type;
    }

    public void setMessage_type(String message_type) {
        this.message_type = message_type;
    }

    public String getSpeak_state() {
        return speak_state;
    }

    public void setSpeak_state(String speak_state) {
        this.speak_state = speak_state;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Long getStart_time() {
        return start_time;
    }

    public void setStart_time(Long start_time) {
        this.start_time = start_time;
    }

    public Long getEnd_time() {
        return end_time;
    }

    public void setEnd_time(Long end_time) {
        this.end_time = end_time;
    }

    public Support getSupport() {
        return support;
    }

    public void setSupport(Support support) {
        this.support = support;
    }

    public String getClass_id() {
        return class_id;
    }

    public void setClass_id(String class_id) {
        this.class_id = class_id;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }
}
