package com.timecapsule.pojo;

import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class Capsule {
    private int capsuleId;
    private String capsuleName;
    private int capsuleTypeId;
    private String capsulePath;
    private String openPassword;
    private String capsuleUploadTime;
    private String capsuleOpenTime;
    private String name;
    private int userId;
    private String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }



    public Capsule() {
    }

    public Capsule(int capsuleId, String capsuleName,
                   int capsuleTypeId, String capsulePath, String openPassword,
                   String capsuleUploadTime, String capsuleOpenTime, String name,int userId) {
        this.capsuleId = capsuleId;
        this.capsuleName = capsuleName;
        this.capsuleTypeId = capsuleTypeId;
        this.capsulePath = capsulePath;
        this.openPassword = openPassword;
        this.capsuleUploadTime = capsuleUploadTime;
        this.capsuleOpenTime = capsuleOpenTime;
        this.name = name;
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "Capsule{" +
                "capsuleId=" + capsuleId +
                ", capsuleName='" + capsuleName + '\'' +
                ", capsuleTypeId=" + capsuleTypeId +
                ", capsulePath='" + capsulePath + '\'' +
                ", openPassword='" + openPassword + '\'' +
                ", capsuleUploadTime=" + capsuleUploadTime +
                ", capsuleOpenTime=" + capsuleOpenTime +
                ", name='" + name + '\'' +
                '}';
    }

    public int getCapsuleId() {
        return capsuleId;
    }

    public String getCapsuleName() {
        return capsuleName;
    }

    public void setCapsuleName(String capsuleName) {
        this.capsuleName = capsuleName;
    }

    public int getCapsuleTypeId() {
        return capsuleTypeId;
    }

    public void setCapsuleTypeId(int capsuleTypeId) {
        this.capsuleTypeId = capsuleTypeId;
    }

    public String getCapsulePath() {
        return capsulePath;
    }

    public void setCapsulePath(String capsulePath) {
        this.capsulePath = capsulePath;
    }

    public String getOpenPassword() {
        return openPassword;
    }

    public void setOpenPassword(String openPassword) {
        this.openPassword = openPassword;
    }

    public String getCapsuleUploadTime() {
        return capsuleUploadTime;
    }

    public void setCapsuleUploadTime(String capsuleUploadTime) {
        this.capsuleUploadTime = capsuleUploadTime;
    }

    public String getCapsuleOpenTime() {
        return capsuleOpenTime;
    }

    public void setCapsuleOpenTime(String capsuleOpenTime) {
        this.capsuleOpenTime = capsuleOpenTime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

}
