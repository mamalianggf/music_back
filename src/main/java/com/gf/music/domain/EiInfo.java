package com.gf.music.domain;

public class EiInfo {
    private int status;
    private Object message;
    private int token;

    public EiInfo() {
    }

    public EiInfo(int status, Object message, int token) {
        this.status = status;
        this.message = message;
        this.token = token;
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

    public int getToken() {
        return token;
    }

    public void setToken(int token) {
        this.token = token;
    }

    @Override
    public String toString() {
        return "EiInfo{" +
                "status=" + status +
                ", message=" + message +
                ", token=" + token +
                '}';
    }
}
