package com.example.myapplication;

public class Virus {
    String name;
    String imgUrl;
    String target;
    String virusKey;

    public Virus() {

    }
    public Virus(String name, String imgUrl, String target, String virusKey) {
        this.name = name;
        this.imgUrl = imgUrl;
        this.target = target;
        this.virusKey = virusKey;
    }
    public String getName() {
        return name;
    }
    public String getImgUrl() { return  imgUrl;}
    public String getTarget() { return target; }
    public String getVirusKey() { return virusKey; }

    public void setName(String name) {
        this.name=name;
    }
    public void setImgUrl(String imgUrl) { this.imgUrl=imgUrl; }
    public void setTarget(String target) { this.target=target; }
    public void setVirusKey(String virusKey) {
        this.virusKey = virusKey;
    }

}
