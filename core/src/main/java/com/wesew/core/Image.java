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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Image image = (Image) o;

        if (title != null ? !title.equals(image.title) : image.title != null) return false;
        return url != null ? url.equals(image.url) : image.url == null;

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (url != null ? url.hashCode() : 0);
        return result;
    }
}
