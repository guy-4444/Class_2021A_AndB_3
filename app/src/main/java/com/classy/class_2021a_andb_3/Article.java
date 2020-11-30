package com.classy.class_2021a_andb_3;

public class Article {

    public enum TYPE {
        NORMAL,
        AD
    }

    private TYPE type = TYPE.NORMAL;
    private String title = "";
    private String subTitle = "";
    private String content = "";
    private String mainImage = "";
    private String button = "";

    public Article() { }

    public TYPE getType() {
        return type;
    }

    public Article setType(TYPE type) {
        this.type = type;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public Article setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getSubTitle() {
        return subTitle;
    }

    public Article setSubTitle(String subTitle) {
        this.subTitle = subTitle;
        return this;
    }

    public String getContent() {
        return content;
    }

    public Article setContent(String content) {
        this.content = content;
        return this;
    }

    public String getMainImage() {
        return mainImage;
    }

    public Article setMainImage(String mainImage) {
        this.mainImage = mainImage;
        return this;
    }

    public String getButton() {
        return button;
    }

    public Article setButton(String button) {
        this.button = button;
        return this;
    }
}
