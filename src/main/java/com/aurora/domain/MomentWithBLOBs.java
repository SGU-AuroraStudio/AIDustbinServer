package com.aurora.domain;

public class MomentWithBLOBs extends Moment {
    private byte[] content;

    private byte[] images;

    public byte[] getContent() {
        return content;
    }

    public void setContent(byte[] content) {
        this.content = content;
    }

    public byte[] getImages() {
        return images;
    }

    public void setImages(byte[] images) {
        this.images = images;
    }
}