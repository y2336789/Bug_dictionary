package com.bliss.csc.myapplication;

public class Bug {
    String name;
    String imgUrl;
    String species;
    String cropName;
    String insectKey;

    public Bug(){
    }

    public Bug(String name,String imgUrl, String species, String cropName, String insectKey) {
        this.name = name;
        this.imgUrl = imgUrl;
        this.species = species;
        this.cropName = cropName;
        this.insectKey = insectKey;
    }

    public String getName() {
        return name;
    }
    public String getImgUrl() { return  imgUrl;}
    public String getSpecies() { return species; }
    public String getCropName() { return cropName; }
    public String getInsectKey() { return insectKey; }
    public void setName(String name) {
        this.name=name;
    }
    public void setImgUrl(String imgUrl) { this.imgUrl=imgUrl; }
    public void setSpecies(String species) { this.species=species; }
    public void setCropName(String cropName) {
        this.cropName = cropName;
    }
    public void setInsectKey(String insectKey) {
        this.insectKey = insectKey;
    }
}

