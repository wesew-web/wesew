package com.wesew.core.abs;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

/**
 * @author vladyslav.yemelianov
 */
@MappedSuperclass
public abstract class BaseEntity<T> {

    @Id
    protected T id;

    @Column
    @Enumerated(EnumType.STRING)
    private StatusEntity status;

    @Column(name = "creation_time")
    private LocalDateTime creationTime;

    public abstract T getId();

    public abstract void setId(T id);

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
