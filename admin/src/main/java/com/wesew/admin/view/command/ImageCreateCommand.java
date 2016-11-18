package com.wesew.admin.view.command;

/**
 * @author vladyslav.yemelianov
 */
public class ImageCreateCommand {
    private String title;

    private byte[] data;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }
}
