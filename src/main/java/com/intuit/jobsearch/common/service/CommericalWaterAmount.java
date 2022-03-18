package com.intuit.jobsearch.common.service;

import com.intuit.jobsearch.common.properties.CommonProperties;
import com.intuit.jobsearch.common.util.UserType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.stereotype.Service;

import static com.intuit.jobsearch.common.util.WaterReadingConstants.*;

@Service
public class CommericalWaterAmount implements UserTypeWaterAmount{

   /* @Value("${COMMERICAL_INITIAL_METER_RANGE}")
    private String defaultMergeRange;

    @Value("${COMMERICAL_DEFAULT_PRICE}")
    private String defaultWaterAmount;

    @Value("${COMMERICAL_INITIAL_METER_PRICE}")
    private String defaultWaterPerLitrePrice;*/

    private String defaultMergeRange="100";

    //@Value("${individual.meter.default.price:230}")
    private String defaultWaterAmount="350";

    //@Value("${individual.meter.reading.firstprice:3}")
    private String defaultWaterPerLitrePrice="5";

    @Autowired
    private CommonProperties commonProperties;
    @Override
    public float calculateAmount(long differenceReading) {
        Float defaultWaterAmountValue = Float.parseFloat(commonProperties.defaultWaterAmount);
        long defaultMergeRangeValue= Long.getLong(commonProperties.defaultMergeRange);
        if(differenceReading!=0 && differenceReading>(differenceReading - defaultMergeRangeValue))
        {
            return Float.parseFloat(String.valueOf(((differenceReading - defaultMergeRangeValue) * Long.valueOf(commonProperties.defaultWaterPerLitrePrice))))+defaultWaterAmountValue;
        }
        else if(differenceReading==0 || (differenceReading!=0 && differenceReading<=defaultMergeRangeValue))
        {
            return Float.parseFloat(commonProperties.defaultWaterAmount);
        }
        return -120;
    }
}
