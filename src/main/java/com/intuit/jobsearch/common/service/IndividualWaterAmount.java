package com.intuit.jobsearch.common.service;

import com.intuit.jobsearch.common.properties.CommonProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.stereotype.Service;

import static com.intuit.jobsearch.common.util.WaterReadingConstants.*;

@Service
//@ConfigurationPropertiesScan()
public class IndividualWaterAmount implements UserTypeWaterAmount{

  /*  @Value("${INDIVIDUAL_INITIAL_METER_RANGE}")
    private String defaultMergeRange;

    @Value("${INDIVIDUAL_DEFAULT_PRICE}")
    private String defaultWaterAmount;

    @Value("${INDIVIDUAL_INITIAL_METER_PRICE}")
    private String defaultWaterPerLitrePrice;*/
  //  @Value("${individual.meter.reading.firstrange:100}")
    private String defaultMergeRange="100";

    //@Value("${individual.meter.default.price:230}")
    private String defaultWaterAmount="230";

    //@Value("${individual.meter.reading.firstprice:3}")
    private String defaultWaterPerLitrePrice="3";

  @Autowired
  private CommonProperties commonProperties;

    @Override
    public float calculateAmount(long differenceReading) {
        float defaultWaterAmountValue = Float.parseFloat(defaultWaterAmount);
        long defaultMergeRangeValue= Long.parseLong(defaultMergeRange);
        if(differenceReading!=0 && differenceReading>(differenceReading - defaultMergeRangeValue))
        {
            return Float.parseFloat(String.valueOf(((differenceReading - defaultMergeRangeValue) * Long.valueOf(defaultWaterPerLitrePrice))))+defaultWaterAmountValue;
        }
        else if(differenceReading==0 || (differenceReading!=0 && differenceReading<=defaultMergeRangeValue))
        {
            return Float.parseFloat(defaultWaterAmount);
        }
        return -110;
    }
}
