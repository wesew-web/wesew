package com.wesew.core;

import com.wesew.core.abs.BaseEntity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * @author vladyslav.yemelianov
 */
@Entity
@Table(name = "EVENT")
public class Event extends BaseEntity<Integer> {

    @Column
    private String title;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "EVENT_HAS_IMAGE",
            joinColumns = {
                    @JoinColumn(name = "event_id", nullable = false)
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "image_id", nullable = false)
            })
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

    public Integer getId() {
        return id;
    }

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public void setId(Integer id) {
        this.id = id;
    }
}
