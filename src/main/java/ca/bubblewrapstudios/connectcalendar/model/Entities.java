package ca.bubblewrapstudios.connectcalendar.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Entities {

    @SerializedName("event")
    private List<IntentValue> event;
    @SerializedName("positive")
    private List<IntentValue> positive;

    public List<IntentValue> getEvent() {
        return event;
    }

    public void setEvent(List<IntentValue> event) {
        this.event = event;
    }

    public List<IntentValue> getPositive() {
        return positive;
    }

    public void setPositive(List<IntentValue> positive) {
        this.positive = positive;
    }

    @Override
    public String toString() {
        return "Entities{" +
                "event=" + event +
                ", positive=" + positive +
                '}';
    }
}
