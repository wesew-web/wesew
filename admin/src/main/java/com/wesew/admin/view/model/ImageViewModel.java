package com.wesew.admin.view.model;

/**
 * @author vladyslav.yemelianov
 */
public class ImageViewModel {
    private String id;

    private String title;

    private String path;

    private String status;

    private String creationTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(String creationTime) {
        this.creationTime = creationTime;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("id='").append(id).append('\'');
        sb.append(", title='").append(title).append('\'');
        sb.append(", path='").append(path).append('\'');
        sb.append(", status='").append(status).append('\'');
        sb.append(", creationTime='").append(creationTime).append('\'');
        return sb.toString();
    }
}
