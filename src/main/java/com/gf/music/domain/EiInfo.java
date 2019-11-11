package com.gf.music.domain;

import java.util.HashMap;

public class EiInfo {
    private int status;
    private Object message;
    private HashMap result;

    public EiInfo() {
    }

    public EiInfo(int status, Object message) {
        this.status = status;
        this.message = message;
    }

    public EiInfo(int status, Object message, HashMap result) {
        this.status = status;
        this.message = message;
        this.result = result;
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

    public HashMap getResult() {
        return result;
    }

    public void setResult(HashMap result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "EiInfo{" +
                "status=" + status +
                ", message=" + message +
                ", result=" + result +
                '}';
    }
}
