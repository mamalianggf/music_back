package com.gf.music.domain;

public class Song {
    private int id;
    private String name;
    private String singerId;
    private String time;
    private String img;
    private String styleIds;

    public Song(){}

    public Song(int id, String name, String singerId, String time, String img, String styleIds) {
        this.id = id;
        this.name = name;
        this.singerId = singerId;
        this.time = time;
        this.img = img;
        this.styleIds = styleIds;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSingerId() {
        return singerId;
    }

    public void setSingerId(String singerId) {
        this.singerId = singerId;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getStyleIds() {
        return styleIds;
    }

    public void setStyleIds(String styleIds) {
        this.styleIds = styleIds;
    }

    @Override
    public String toString() {
        return "Song{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", singerId='" + singerId + '\'' +
                ", time='" + time + '\'' +
                ", img='" + img + '\'' +
                ", styleIds='" + styleIds + '\'' +
                '}';
    }
}
