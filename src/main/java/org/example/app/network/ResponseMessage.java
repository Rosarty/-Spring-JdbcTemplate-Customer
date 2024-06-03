package org.example.app.network;


public enum ResponseMessage {
    DELETED("Deleted."),
    SMTH_WRONG("Something wrong.");

    private final String responseMsg;

    ResponseMessage(String responseMsg) {
        this.responseMsg = responseMsg;
    }

    public String getResponseMsg() {
        return responseMsg;
    }
}
