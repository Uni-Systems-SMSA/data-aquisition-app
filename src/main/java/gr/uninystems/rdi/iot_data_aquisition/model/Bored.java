package gr.uninystems.rdi.iot_data_aquisition.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import org.springframework.data.annotation.Id;

@Entity
public class Bored {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @jakarta.persistence.Id
    @Column(name = "`ID`")
    private Long Id;
    @Column(name = "`ACTIVITY`")
    private String activity;
    @Column(name = "`AVAILABILITY`")
    private String availability;
    @Column(name = "`TYPES`")
    private String type;
    @Column(name = "`PARTICIPANTS`")
    private String participants;
    @Column(name = "`PRICE`")
    private String price;
    @Column(name = "`ACCESSIBILITY`")
    private String accessibility;
    @Column(name = "`DURATION`")
    private String duration;
    @Column(name = "`KIDFRIENDLY`")
    private boolean kidFriendly;
    @Column(name = "`LINK`")
    private String link;
    @Column(name = "`KEYS`")
    private Long keys;

    public Bored() {
    }

    @Override
    public String toString() {
        return "Bored{" +
                "Id=" + Id +
                ", activity='" + activity + '\'' +
                ", availability=" + availability +
                ", type='" + type + '\'' +
                ", participants=" + participants +
                ", price=" + price +
                ", accessibility='" + accessibility + '\'' +
                ", duration='" + duration + '\'' +
                ", kidFriendly=" + kidFriendly +
                ", link='" + link + '\'' +
                ", keys=" + keys +
                '}';
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getActivity() {
        return activity;
    }

    public void setActivity(String activity) {
        this.activity = activity;
    }

    public String getAvailability() {
        return availability;
    }

    public void setAvailability(String availability) {
        this.availability = availability;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getParticipants() {
        return participants;
    }

    public void setParticipants(String participants) {
        this.participants = participants;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getAccessibility() {
        return accessibility;
    }

    public void setAccessibility(String accessibility) {
        this.accessibility = accessibility;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public boolean isKidFriendly() {
        return kidFriendly;
    }

    public void setKidFriendly(boolean kidFriendly) {
        this.kidFriendly = kidFriendly;
    }

    public String getLin() {
        return link;
    }

    public void setLink(String lin) {
        this.link = link;
    }

    public Long getKey() {
        return keys;
    }

    public void setKey(Long key) {
        this.keys = keys;
    }
}
