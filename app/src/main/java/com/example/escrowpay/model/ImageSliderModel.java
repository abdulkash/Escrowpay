package com.example.escrowpay.model;

public class ImageSliderModel {
    private int sliderImage;
    private String headerCaption;
    private String subtitleCaption;

    public ImageSliderModel(int sliderImage, String headerCaption, String subtitleCaption) {
        this.sliderImage = sliderImage;
        this.headerCaption = headerCaption;
        this.subtitleCaption = subtitleCaption;
    }

    public int getSliderImage() {
        return sliderImage;
    }

    public void setSliderImage(int sliderImage) {
        this.sliderImage = sliderImage;
    }

    public String getHeaderCaption() {
        return headerCaption;
    }

    public void setHeaderCaption(String headerCaption) {
        this.headerCaption = headerCaption;
    }

    public String getSubtitleCaption() {
        return subtitleCaption;
    }

    public void setSubtitleCaption(String subtitleCaption) {
        this.subtitleCaption = subtitleCaption;
    }
}
