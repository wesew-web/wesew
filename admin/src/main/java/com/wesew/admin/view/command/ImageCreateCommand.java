package com.wesew.admin.view.command;

import org.hibernate.validator.constraints.NotBlank;
/**
 * @author vladyslav.yemelianov
 */
public class ImageCreateCommand {
    @NotBlank
    private String title;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

}
