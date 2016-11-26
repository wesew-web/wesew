package com.wesew.core;

import com.wesew.core.abs.BaseEntity;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * @author vladyslav.yemelianov
 */
@Entity
@Table(name = "EVENT")
public class Event extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
