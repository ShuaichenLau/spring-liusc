package com.liusc.entity;

public class Support {

    private int points_decoder;  //2,
    private int link_type_consistency;  //0,
    private int teacher_preferred_link_type;  //1

    public int getPoints_decoder() {
        return points_decoder;
    }

    public void setPoints_decoder(int points_decoder) {
        this.points_decoder = points_decoder;
    }

    public int getLink_type_consistency() {
        return link_type_consistency;
    }

    public void setLink_type_consistency(int link_type_consistency) {
        this.link_type_consistency = link_type_consistency;
    }

    public int getTeacher_preferred_link_type() {
        return teacher_preferred_link_type;
    }

    public void setTeacher_preferred_link_type(int teacher_preferred_link_type) {
        this.teacher_preferred_link_type = teacher_preferred_link_type;
    }
}
