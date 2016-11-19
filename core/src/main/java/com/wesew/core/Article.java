package com.wesew.core;

import com.sun.org.apache.xpath.internal.operations.String;
import com.wesew.core.abs.BaseEntity;

import java.util.Set;

/**
 * @author vladyslav.yemelianov
 */
public class Article extends BaseEntity<Integer> {

    private String title;

    private String body;

    private Set<Image> images;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Set<Image> getImages() {
        return images;
    }

    public void setImages(Set<Image> images) {
        this.images = images;
    }
}
