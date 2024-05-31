package gr.uninystems.rdi.iot_data_aquisition.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import org.springframework.data.annotation.Id;

/**
 * Represents a Parking Spot in the system.
 *
 * This class is mapped to the "Parking_Spots" table in the database.
 *
 * @author StavrouA
 * @version 1.0
 */
@Entity
public class ParkingSpot {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @jakarta.persistence.Id
    @Column(name = "`ID`")
    private int Id;
    private boolean IsFree;
    private int ZoneID;
    private String ZoneName;
    private int CityID;
    private String CityName;
    private int ParkingSpaceID;
    private String ParkingSpaceName;
    private int RegionID;
    private String RegionName;
    private double Lat;
    private double Lng;
    private boolean IsLocated;
    private boolean IsViolated;
    private String ViolationDate;
    private String ViolationTime;
    private double InViolationTime;
    private int InspectionStatus;
    private String InspectionStatusName;
    private double BatteryStatus;
    private String StatusChangeDate;
    private String LastReport;
    private int Type;
    private boolean DeviceIsOn;
    private int CategoryID;
    private boolean InServiceMode;
    private String Code;
    private String Name;

    public ParkingSpot() {
    }


    @Override
    public String toString() {
        return "Cicicom{" +
                "Id=" + Id +
                ", IsFree=" + IsFree +
                ", ZoneID=" + ZoneID +
                ", ZoneName='" + ZoneName + '\'' +
                ", CityID=" + CityID +
                ", CityName='" + CityName + '\'' +
                ", ParkingSpaceID=" + ParkingSpaceID +
                ", ParkingSpaceName='" + ParkingSpaceName + '\'' +
                ", RegionID=" + RegionID +
                ", RegionName='" + RegionName + '\'' +
                ", Lat=" + Lat +
                ", Lng=" + Lng +
                ", IsLocated=" + IsLocated +
                ", IsViolated=" + IsViolated +
                ", ViolationDate='" + ViolationDate + '\'' +
                ", ViolationTime='" + ViolationTime + '\'' +
                ", InViolationTime=" + InViolationTime +
                ", InspectionStatus=" + InspectionStatus +
                ", InspectionStatusName='" + InspectionStatusName + '\'' +
                ", BatteryStatus=" + BatteryStatus +
                ", StatusChangeDate='" + StatusChangeDate + '\'' +
                ", LastReport='" + LastReport + '\'' +
                ", Type=" + Type +
                ", DeviceIsOn=" + DeviceIsOn +
                ", CategoryID=" + CategoryID +
                ", InServiceMode=" + InServiceMode +
                ", Code='" + Code + '\'' +
                ", Name='" + Name + '\'' +
                '}';
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public boolean isFree() {
        return IsFree;
    }

    public void setFree(boolean free) {
        IsFree = free;
    }

    public int getZoneID() {
        return ZoneID;
    }

    public void setZoneID(int zoneID) {
        ZoneID = zoneID;
    }

    public String getZoneName() {
        return ZoneName;
    }

    public void setZoneName(String zoneName) {
        ZoneName = zoneName;
    }

    public int getCityID() {
        return CityID;
    }

    public void setCityID(int cityID) {
        CityID = cityID;
    }

    public String getCityName() {
        return CityName;
    }

    public void setCityName(String cityName) {
        CityName = cityName;
    }

    public int getParkingSpaceID() {
        return ParkingSpaceID;
    }

    public void setParkingSpaceID(int parkingSpaceID) {
        ParkingSpaceID = parkingSpaceID;
    }

    public String getParkingSpaceName() {
        return ParkingSpaceName;
    }

    public void setParkingSpaceName(String parkingSpaceName) {
        ParkingSpaceName = parkingSpaceName;
    }

    public int getRegionID() {
        return RegionID;
    }

    public void setRegionID(int regionID) {
        RegionID = regionID;
    }

    public String getRegionName() {
        return RegionName;
    }

    public void setRegionName(String regionName) {
        RegionName = regionName;
    }

    public double getLat() {
        return Lat;
    }

    public void setLat(double lat) {
        Lat = lat;
    }

    public double getLng() {
        return Lng;
    }

    public void setLng(double lng) {
        Lng = lng;
    }

    public boolean isLocated() {
        return IsLocated;
    }

    public void setLocated(boolean located) {
        IsLocated = located;
    }

    public boolean isViolated() {
        return IsViolated;
    }

    public void setViolated(boolean violated) {
        IsViolated = violated;
    }

    public String getViolationDate() {
        return ViolationDate;
    }

    public void setViolationDate(String violationDate) {
        ViolationDate = violationDate;
    }

    public String getViolationTime() {
        return ViolationTime;
    }

    public void setViolationTime(String violationTime) {
        ViolationTime = violationTime;
    }

    public double getInViolationTime() {
        return InViolationTime;
    }

    public void setInViolationTime(double inViolationTime) {
        InViolationTime = inViolationTime;
    }

    public int getInspectionStatus() {
        return InspectionStatus;
    }

    public void setInspectionStatus(int inspectionStatus) {
        InspectionStatus = inspectionStatus;
    }

    public String getInspectionStatusName() {
        return InspectionStatusName;
    }

    public void setInspectionStatusName(String inspectionStatusName) {
        InspectionStatusName = inspectionStatusName;
    }

    public double getBatteryStatus() {
        return BatteryStatus;
    }

    public void setBatteryStatus(double batteryStatus) {
        BatteryStatus = batteryStatus;
    }

    public String getStatusChangeDate() {
        return StatusChangeDate;
    }

    public void setStatusChangeDate(String statusChangeDate) {
        StatusChangeDate = statusChangeDate;
    }

    public String getLastReport() {
        return LastReport;
    }

    public void setLastReport(String lastReport) {
        LastReport = lastReport;
    }

    public int getType() {
        return Type;
    }

    public void setType(int type) {
        Type = type;
    }

    public boolean isDeviceIsOn() {
        return DeviceIsOn;
    }

    public void setDeviceIsOn(boolean deviceIsOn) {
        DeviceIsOn = deviceIsOn;
    }

    public int getCategoryID() {
        return CategoryID;
    }

    public void setCategoryID(int categoryID) {
        CategoryID = categoryID;
    }

    public boolean isInServiceMode() {
        return InServiceMode;
    }

    public void setInServiceMode(boolean inServiceMode) {
        InServiceMode = inServiceMode;
    }

    public String getCode() {
        return Code;
    }

    public void setCode(String code) {
        Code = code;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }
}
