package com.example.jsonimagelisttest.model;

public class Job {
    private int num;
    private String img;
    private String originalImage;
    private String subject;
    private String content;

    public Job() {
    }

    public Job(int num, String img, String originalImage, String subject, String content) {
        this.num = num;
        this.img = img;
        this.originalImage = originalImage;
        this.subject = subject;
        this.content = content;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getOriginalImage() {
        return originalImage;
    }

    public void setOriginalImage(String originalImage) {
        this.originalImage = originalImage;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
