package com.gf.music.domain;

public class EiInfo {
    private int status;
    private Object message;

    public EiInfo(){}

    public EiInfo(int status, Object message) {
        this.status = status;
        this.message = message;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Object getMessage() {
        return message;
    }

    public void setMessage(Object message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "EiInfo{" +
                "status='" + status + '\'' +
                ", message=" + message +
                '}';
    }
}
