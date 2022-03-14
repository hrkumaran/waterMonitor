package com.intuit.jobsearch.waterMonitor.model;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.usertype.UserType;
import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Date;

@Data
@Entity(name = "WATER_READING_DETAILS")
public class WaterReadingDetails {

    @Id
    @Column(name = "RRNO")
    private Long rrNo;

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
