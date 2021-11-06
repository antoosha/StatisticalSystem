package korolov.project.domain;

import java.time.LocalDateTime;

/**
 * Record, which contains records from each line from statistics
 */

public class Record {
    private String locationId;
    private String directionId;
    private LocalDateTime measuredFrom;
    private LocalDateTime measuredTo;
    private int numberOfRecords;

    public Record(String locationId, String directionId, LocalDateTime measuredFrom, LocalDateTime measuredTo, int numberOfRecords) {
        this.locationId = locationId;
        this.directionId = directionId;
        this.measuredFrom = measuredFrom;
        this.measuredTo = measuredTo;
        this.numberOfRecords = numberOfRecords;
    }

    public Record() {
    }

    public String getLocationId() {
        return locationId;
    }

    public String getDirectionId() {
        return directionId;
    }

    public LocalDateTime getMeasuredFrom() {
        return measuredFrom;
    }

    public LocalDateTime getMeasuredTo() {
        return measuredTo;
    }

    public int getNumberOfRecords() {
        return numberOfRecords;
    }

    public void setLocationId(String locationId) {
        this.locationId = locationId;
    }

    public void setDirectionId(String directionId) {
        this.directionId = directionId;
    }

    public void setMeasuredFrom(LocalDateTime measuredFrom) {
        this.measuredFrom = measuredFrom;
    }

    public void setMeasuredTo(LocalDateTime measuredTo) {
        this.measuredTo = measuredTo;
    }

    public void setNumberOfRecords(int numberOfRecords) {
        this.numberOfRecords = numberOfRecords;
    }

    @Override
    public String toString() {
        return "Record{" +
                "locationId='" + locationId + '\'' +
                ", directionId='" + directionId + '\'' +
                ", measuredFrom='" + measuredFrom.toString()+  '\'' +
                ", measuredTo='" + measuredTo.toString() + '\'' +
                ", numberOfRecords=" + numberOfRecords +
                '}';
    }
}
