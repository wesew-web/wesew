package com.wesew.core;

import com.wesew.core.abs.BaseEntity;
import com.wesew.core.abs.StatusEntity;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * @author vladyslav.yemelianov
 */
@Table(name = "IMAGE")
@Entity
public class Image extends BaseEntity {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;

    @Column
    private String title;

    @Column
    private String url;

    public String getId() {
        return id;
    }

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

        if (id != null ? !id.equals(image.id) : image.id != null) return false;
        if (title != null ? !title.equals(image.title) : image.title != null) return false;
        return url != null ? url.equals(image.url) : image.url == null;

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (id != null ? id.hashCode() : 0);
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (url != null ? url.hashCode() : 0);
        return result;
    }

    public static final class Builder {
        protected String id;
        private String title;
        private String url;
        private StatusEntity status;
        private LocalDateTime creationTime;

        private Builder() {
        }

        public static Builder anImage() {
            return new Builder();
        }

        public Builder title(String title) {
            this.title = title;
            return this;
        }

        public Builder id(String id) {
            this.id = id;
            return this;
        }

        public Builder url(String url) {
            this.url = url;
            return this;
        }

        public Builder status(StatusEntity status) {
            this.status = status;
            return this;
        }

        public Builder creationTime(LocalDateTime creationTime) {
            this.creationTime = creationTime;
            return this;
        }

        public Image build() {
            Image image = new Image();
            image.setTitle(title);
            image.setId(id);
            image.setUrl(url);
            image.setStatus(status);
            image.setCreationTime(creationTime);
            return image;
        }
    }
}
