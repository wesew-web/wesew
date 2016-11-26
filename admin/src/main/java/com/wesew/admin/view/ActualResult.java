package com.wesew.admin.view;

/**
 * @author vladyslav.yemelianov
 */
public class ActualResult {
    private int status;

    private Object data;

    private Object error;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Object getError() {
        return error;
    }

    public void setError(Object error) {
        this.error = error;
    }

    public enum Status {
        OK(1), ERROR(0);

        private final int code;

        Status(int code) {
            this.code = code;
        }

        public int getCode() {
            return code;
        }
    }
}
