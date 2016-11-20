package com.wesew.core;

import com.wesew.core.abs.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Table;

/**
 * @author vladyslav.yemelianov
 */
@Table(name = "IMAGE")
@Entity
public class Image extends BaseEntity<String> {

    @Column
    private String title;

    @Column
    private String url;

    public String getId() {
        return id;
    }

    @GeneratedValue(generator = "uuid2")
    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
