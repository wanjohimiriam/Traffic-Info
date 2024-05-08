package com.example.trafficapp;

public class News {
    private int itemImage;
    private String heading;
    private String headingtwo;
    private String headingthree;

    public News(int itemImage, String heading, String headingtwo, String headingthree) {
        this.itemImage = itemImage;
        this.heading = heading;
        this.headingtwo = headingtwo;
        this.headingthree = headingthree;
    }

    public int getItemImage() {
        return itemImage;
    }

    public void setItemImage(int itemImage) {
        this.itemImage = itemImage;
    }

    public String getHeading() {
        return heading;
    }

    public void setHeading(String heading) {
        this.heading = heading;
    }

    public String getHeadingtwo() {
        return headingtwo;
    }

    public void setHeadingtwo(String headingtwo) {
        this.headingtwo = headingtwo;
    }

    public String getHeadingthree() {
        return headingthree;
    }

    public void setHeadingthree(String headingthree) {
        this.headingthree = headingthree;
    }
}
