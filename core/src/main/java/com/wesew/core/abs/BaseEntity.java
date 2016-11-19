package com.wesew.core.abs;

import java.time.LocalDateTime;

/**
 * @author vladyslav.yemelianov
 */
public abstract class BaseEntity<T> {

    private T id;

    private StatusEntity status;

    private LocalDateTime creationTime;

    public T getId() {
        return id;
    }

    public void setId(T id) {
        this.id = id;
    }

    public StatusEntity getStatus() {
        return status;
    }

    public void setStatus(StatusEntity status) {
        this.status = status;
    }

    public LocalDateTime getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(LocalDateTime creationTime) {
        this.creationTime = creationTime;
    }
}
