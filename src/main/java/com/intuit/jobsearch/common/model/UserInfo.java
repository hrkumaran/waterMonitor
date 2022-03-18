package com.intuit.jobsearch.common.model;

import com.intuit.jobsearch.common.util.UserType;
import com.intuit.jobsearch.waterMonitor.model.WaterReadingDetails;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@Entity(name = "USER_INFO")
public class UserInfo {

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
        @GenericGenerator(name = "native", strategy = "native")
        @Column(name = "USERID")
        private Long userId;
        @Column(name = "RRNO")
        private Long rrNo;
      //  @OneToMany
       // @JoinColumn(name = "rrNo", referencedColumnName = "rrNo")
     //   private List<WaterReadingDetails> waterReadingDetails;
        @Column(name = "FIRSTNAME")
        private String firstName;
        @Column(name = "LASTNAME")
        private String lastName;
        @Column(name = "ADDRESS")
        private String address;
        @Column(name = "USERTYPE")
        private UserType userType;
        @Temporal(value = TemporalType.TIMESTAMP)
        @Column(name = "CREATED_TIME")
        private Date creationTime;
        @Temporal(value = TemporalType.TIMESTAMP)
        @Column(name = "MODIFIED_TIME")
        private Date updatedTime;
}

