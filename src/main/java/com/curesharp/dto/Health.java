package com.curesharp.dto;

public class Health {
    private String status;

    public Health(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
