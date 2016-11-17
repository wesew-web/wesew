package com.wesew.core.abs;

/**
 * @author vladyslav.yemelianov
 */
public abstract class IntIdEntity extends TimeEntity {

    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
