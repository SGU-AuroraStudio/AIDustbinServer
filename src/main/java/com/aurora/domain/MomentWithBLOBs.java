package com.aurora.domain;

public class MomentWithBLOBs extends Moment {
    private byte[] content;

    private byte[] images;

    public MomentWithBLOBs(String id, String userId, String sharingId, byte[] content, byte[] images) {
        super(id, userId, sharingId);
        this.content = content;
        this.images = images;
    }

    public MomentWithBLOBs() {
        super();
    }

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