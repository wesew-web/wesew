package com.wesew.core.abs;

import java.time.LocalDateTime;

/**
 * @author vladyslav.yemelianov
 */
public abstract class TimeEntity {

    private LocalDateTime creationTime;

    public LocalDateTime getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(LocalDateTime creationTime) {
        this.creationTime = creationTime;
    }
}
