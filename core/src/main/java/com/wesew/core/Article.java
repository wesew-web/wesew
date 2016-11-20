package com.wesew.core;

import com.sun.org.apache.xpath.internal.operations.String;
import com.wesew.core.abs.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Set;

/**
 * @author vladyslav.yemelianov
 */
@Table(name = "ARTICLE")
@Entity
public class Article extends BaseEntity<Integer> {

    @Column
    private String title;

    @Column
    private String body;

    private Set<Image> images = new HashSet<>();

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

    public Integer getId() {
        return id;
    }

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public void setId(Integer id) {
        this.id = id;
    }
}
