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
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    @Column(name = "USERID")
    private Long id;

    //@Size(message = "waterConsumptionLitres is mandatory")
    @Range(min=0, max=90)
    @Column(name = "WATERCONSUMPTIONLITRES")
    private Long waterConsumptionLitres;
    //@Size(message = "amount is mandatory")
    @Range(min=0, max=90)
    @Column(name = "AMOUNT")
    private String amount;
    @Temporal(value = TemporalType.TIMESTAMP)
    @Column(name = "CREATED_TIME")
    private Date creationTime;
    @Temporal(value = TemporalType.TIMESTAMP)
    @Column(name = "UPDATED_TIME")
    private Date updatedTime;
    @Temporal(value = TemporalType.DATE)
    @Column(name = "BILLEDMONTH")
    private Date billedMonth;


}
