package com.intuit.jobsearch.waterMonitor.model;

import com.intuit.jobsearch.common.model.UserInfo;
import lombok.Data;
import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@Entity(name = "WATER_READING_DETAILS")
public class WaterReadingDetails {

    @Id
    @Column(name = "RRNO")
    private Long rrNo;
    @Column(name = "USERID")
    private Long userId;
    @Column(name = "CURRENT_METER_READING")
    private Long currentMeterReading;
    @Column(name = "PREVIOUS_METER_READING")
    private Long previousMeterReading;
    @Column(name = "WATER_CONSUMPTION_LITRE")
    private Long waterConsumptionLitre;
    //@Size(message = "amount is mandatory")
    @Column(name = "AMOUNT")
    private float amount;
    @Temporal(value = TemporalType.TIMESTAMP)
    @Column(name = "CREATED_TIME")
    private Date creationTime;
    @Temporal(value = TemporalType.TIMESTAMP)
    @Column(name = "MODIFIED_TIME")
    private Date updatedTime;
    @Temporal(value = TemporalType.DATE)
    @Column(name = "BILLEDMONTH")
    private Date billedMonth;


}
