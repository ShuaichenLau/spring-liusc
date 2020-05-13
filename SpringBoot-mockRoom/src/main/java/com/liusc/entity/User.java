package com.liusc.entity;

public class User {

    private String number;  // user_number,
    private String group;  // 3603833,
    private String type;  // 0,
    private String name;  // "student-" + user_number,
    private String actual_name;  // "student",
    private String avatar;  // "https://test-i.gsxcdn.com/1735255_p4p15q30.png",
    private String status;  // 0,
    private String end_type;  // end_type,
    private String version;  // "7.4.8"

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getActual_name() {
        return actual_name;
    }

    public void setActual_name(String actual_name) {
        this.actual_name = actual_name;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getEnd_type() {
        return end_type;
    }

    public void setEnd_type(String end_type) {
        this.end_type = end_type;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    @Override
    public String toString() {
        return "User{" +
                "number='" + number + '\'' +
                ", group='" + group + '\'' +
                ", type='" + type + '\'' +
                ", name='" + name + '\'' +
                ", actual_name='" + actual_name + '\'' +
                ", avatar='" + avatar + '\'' +
                ", status='" + status + '\'' +
                ", end_type='" + end_type + '\'' +
                ", version='" + version + '\'' +
                '}';
    }
}
