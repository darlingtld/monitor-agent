package com.emc.pojo.send;

import java.util.Date;

/**
 * Created by tangl9 on 2015-10-28.
 */
public class Message {

    private String id = String.valueOf(System.nanoTime());
    private Date timestamp = new Date();
    private MessageType messageType;
    private Object details;
    private String errorMsg = "";

    @Override
    public String toString() {
        return "Message{" +
                "id='" + id + '\'' +
                ", timestamp=" + timestamp +
                ", messageType=" + messageType +
                ", details=" + details +
                ", errorMsg='" + errorMsg + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public Object getDetails() {
        return details;
    }

    public void setDetails(Object details) {
        this.details = details;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public MessageType getMessageType() {
        return messageType;
    }

    public void setMessageType(MessageType messageType) {
        this.messageType = messageType;
    }
}
