package gr.uninystems.rdi.iot_data_aquisition.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;

@Entity
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @jakarta.persistence.Id
    private Long eventId;
    private String sensorId;
    private LocalDateTime timestamp;
    private String eventType;
    private String eventData;

    // Default constructor
    public Event() {
    }

    // Parameterized constructor
    public Event(Long eventId, String sensorId, LocalDateTime timestamp, String eventType, String eventData) {
        this.eventId = eventId;
        this.sensorId = sensorId;
        this.timestamp = timestamp;
        this.eventType = eventType;
        this.eventData = eventData;
    }

    public Long getEventId() {
        return eventId;
    }

    public void setEventId(Long eventId) {
        this.eventId = eventId;
    }

    public String getSensorId() {
        return sensorId;
    }

    public void setSensorId(String sensorId) {
        this.sensorId = sensorId;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public String getEventData() {
        return eventData;
    }

    public void setEventData(String eventData) {
        this.eventData = eventData;
    }

    @Override
    public String toString() {
        return "Event{" +
                "eventId='" + eventId + '\'' +
                ", sensorId='" + sensorId + '\'' +
                ", timestamp=" + timestamp +
                ", eventType='" + eventType + '\'' +
                ", eventData='" + eventData + '\'' +
                '}';
    }
}
