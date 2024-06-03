package org.example.app.network;

public class ResponseData<T> {
    private String status;
    private boolean success;
    private T data;

    public ResponseData(String status, boolean success, T data) {
        this.status = status;
        this.success = success;
        this.data = data;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
