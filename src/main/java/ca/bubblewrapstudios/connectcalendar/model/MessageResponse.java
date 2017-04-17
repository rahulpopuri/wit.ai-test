package ca.bubblewrapstudios.connectcalendar.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;

public class MessageResponse {

    @SerializedName("msg_id")
    private String messageId;
    @SerializedName("_text")
    private String text;
    @SerializedName("entities")
    private Entities entities;

    public String getMessageId() {
        return messageId;
    }

    public String getText() {
        return text;
    }

    public Entities getEntities() {
        return entities;
    }

    @Override
    public String toString() {
        return "MessageResponse{" +
                "messageId='" + messageId + '\'' +
                ", text='" + text + '\'' +
                ", entities=" + entities +
                '}';
    }
}
