package org.example.app.network;

import java.util.List;

public class ResponseDataList<T> {
    private String status;
    private boolean success;
    private List<T> data;

    public ResponseDataList(String status, boolean success, List<T> data) {
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

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }
}
