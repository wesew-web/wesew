package com.wesew.core.abs;


/**
 * @author vladyslav.yemelianov
 */
public abstract class StringIdEntity extends TimeEntity {

    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
