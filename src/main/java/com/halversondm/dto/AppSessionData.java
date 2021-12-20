package com.halversondm.dto;

import java.io.Serializable;
import java.util.Date;

public class AppSessionData implements Serializable {

    String name;
    Date time;

    public AppSessionData() {
        time = new Date();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "AppSessionData{" +
                "name='" + name + '\'' +
                ", time=" + time +
                '}';
    }
}
