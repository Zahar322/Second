package com.example.second.model;

import java.io.Serializable;

public class Media implements Serializable {

    private String contentType;

    private String name;

    private String originalName;

    private byte[] content;

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOriginalName() {
        return originalName;
    }

    public void setOriginalName(String originalName) {
        this.originalName = originalName;
    }

    public byte[] getContent() {
        return content;
    }

    public void setContent(byte[] content) {
        this.content = content;
    }

    public String imagePath() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("/image/")
                .append(getOriginalName())
                .append("/")
                .append(getContentType().replaceFirst("/", "9"));

        return stringBuilder.toString();
    }
}
