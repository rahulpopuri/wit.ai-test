package ca.bubblewrapstudios.connectcalendar.model;

import com.google.gson.annotations.SerializedName;

public class IntentValue implements Comparable<IntentValue> {

    @SerializedName("confidence")
    private float confidence;
    @SerializedName("type")
    private String type;
    @SerializedName("value")
    private String value;

    @Override
    public String toString() {
        return "IntentValue{" +
                "confidence=" + confidence +
                ", type='" + type + '\'' +
                ", value='" + value + '\'' +
                '}';
    }

    public float getConfidence() {
        return confidence;
    }

    public String getType() {
        return type;
    }

    public String getValue() {
        return value;
    }

    @Override
    public int compareTo(IntentValue o) {
        Float o1Confidence = getConfidence();
        Float o2Confidence = o.getConfidence();
        return o1Confidence.compareTo(o2Confidence);
    }
}
