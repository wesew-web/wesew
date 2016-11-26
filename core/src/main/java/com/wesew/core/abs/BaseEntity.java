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
public abstract class BaseEntity {

    @Column
    @Enumerated(EnumType.STRING)
    private StatusEntity status;

    @Column(name = "creation_time")
    private LocalDateTime creationTime;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BaseEntity that = (BaseEntity) o;

        if (status != that.status) return false;
        return creationTime != null ? creationTime.equals(that.creationTime) : that.creationTime == null;

    }

    @Override
    public int hashCode() {
        int result = status != null ? status.hashCode() : 0;
        result = 31 * result + (creationTime != null ? creationTime.hashCode() : 0);
        return result;
    }
}
