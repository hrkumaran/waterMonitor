package com.intuit.jobsearch.common.properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
@Configuration
@ConfigurationProperties(prefix = "commerical")
public class CommonProperties {

 //   commerical.meter.reading.secondprice=4
//    commerical.meter.reading.secondrange=100

   // @Value("${meter.reading.firstrange}")
    public String defaultMergeRange;

  //  @Value("${meter.default.price}")
    public String defaultWaterAmount;

  //  @Value("${meter.reading.firstprice}")
    public String defaultWaterPerLitrePrice;

}
