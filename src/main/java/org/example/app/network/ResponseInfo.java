package org.example.app.network;

public class ResponseInfo {
    private String status;
    private boolean success;
    private String message;

    public ResponseInfo(String status, boolean success, String message) {
        this.status = status;
        this.success = success;
        this.message = message;
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

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
