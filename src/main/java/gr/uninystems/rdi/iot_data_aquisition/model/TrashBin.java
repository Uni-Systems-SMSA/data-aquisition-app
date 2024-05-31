package gr.uninystems.rdi.iot_data_aquisition.model;

import jakarta.persistence.*;
import org.springframework.data.annotation.Id;

@Entity
@Table(name="'TRASH_BIN'")
public class TrashBin {
    @org.springframework.data.annotation.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @jakarta.persistence.Id
    @Column(name = "`ID`")
    private Long Id;
    @Column(name = "`NAME`")
    private String name;
    @Column(name = "`LATITUDE`")
    private String lat;
    @Column(name = "`LONGTITUDE`")
    private String lon;
    @Column(name = "`TIMESTAMP`")
    private String timestamp;
    @Column(name = "`FILL_LEVEL`")
    private String fillLevel;
    @Column(name = "`TEMPERATURE`")
    private String temperature;
    @Column(name = "`HUMIDITY`")
    private String Humidity;
    @Column(name = "`LOCKED`")
    private String locked;
    @Column(name = "`BATTERY_LEVEL`")
    private String batteryLevel;

}
