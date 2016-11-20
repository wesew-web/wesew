package com.wesew.core;

import com.wesew.core.abs.BaseEntity;

import java.util.HashSet;
import java.util.Set;

/**
 * @author vladyslav.yemelianov
 */
public class Event extends BaseEntity<Integer> {

    private String title;

    private Set<Image> images = new HashSet<>();

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Set<Image> getImages() {
        return images;
    }

    public void setImages(Set<Image> images) {
        this.images = images;
    }

}
