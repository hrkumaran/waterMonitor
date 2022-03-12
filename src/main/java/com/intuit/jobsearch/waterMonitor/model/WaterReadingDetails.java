package com.intuit.jobsearch.waterMonitor.model;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.usertype.UserType;
import javax.persistence.*;
import java.util.Date;

@Entity(name = "WATER_READING_DETAILS")
public class WaterReadingDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    @Column(name = "USERID")
    private Long id;
    @Column(name = "WATERCONSUMPTIONLITRES")
    private Long waterConsumptionLitres;
    //@JsonIgnore
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getWaterConsumptionLitres() {
        return waterConsumptionLitres;
    }

    public void setWaterConsumptionLitres(Long waterConsumptionLitres) {
        this.waterConsumptionLitres = waterConsumptionLitres;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public Date getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(Date creationTime) {
        this.creationTime = creationTime;
    }

    public Date getUpdatedTime() {
        return updatedTime;
    }

    public void setUpdatedTime(Date updatedTime) {
        this.updatedTime = updatedTime;
    }

    public Date getBilledMonth() {
        return billedMonth;
    }

    public void setBilledMonth(Date billedMonth) {
        this.billedMonth = billedMonth;
    }
}
