package domain;

import java.util.Date;

/**
 * Record, which contains records from each line from statistics
 */
public class Record {
    private final String locationId;
    private final String directionId;
    private final Date measuredFrom; //ISO-8601 date
    private final Date measuredTo; //ISO-8601 date
    private final long numberOfRecords;

    public Record(String locationId, String directionId, Date measuredFrom, Date measuredTo, long numberOfRecords) {
        this.locationId = locationId;
        this.directionId = directionId;
        this.measuredFrom = measuredFrom;
        this.measuredTo = measuredTo;
        this.numberOfRecords = numberOfRecords;
    }

    public String getLocationId() {
        return locationId;
    }

    public String getDirectionId() {
        return directionId;
    }

    public Date getMeasuredFrom() {
        return measuredFrom;
    }

    public Date getMeasuredTo() {
        return measuredTo;
    }

    public long getNumberOfRecords() {
        return numberOfRecords;
    }
}
