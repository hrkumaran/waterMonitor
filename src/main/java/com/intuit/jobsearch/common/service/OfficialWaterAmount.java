package com.intuit.jobsearch.common.service;

import com.intuit.jobsearch.common.properties.CommonProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Service;

import static com.intuit.jobsearch.common.util.WaterReadingConstants.*;

@Service
//@ConfigurationProperties(prefix="concession.meter.reading")
public class OfficialWaterAmount implements UserTypeWaterAmount{

 /*   @Value("${OFFICIAL_INITIAL_METER_RANGE}")
    private String defaultMergeRange;

    @Value("${OFFICIAL_DEFAULT_PRICE}")
    private String defaultWaterAmount;

    @Value("${OFFICIAL_INITIAL_METER_PRICE}")
    private String defaultWaterPerLitrePrice;*/
    private String defaultMergeRange="150";

    //@Value("${individual.meter.default.price:230}")
    private String defaultWaterAmount="200";

    //@Value("${individual.meter.reading.firstprice:3}")
    private String defaultWaterPerLitrePrice="2.3";

    //@Autowired
            //private CommonProperties commonProperties;
    @Override
    public float calculateAmount(long differenceReading) {
        Float defaultWaterAmountValue = Float.parseFloat(defaultWaterAmount);
        long defaultMergeRangeValue= Long.getLong(defaultMergeRange);
        if(differenceReading!=0 && differenceReading>(differenceReading - defaultMergeRangeValue))
        {
            return Float.parseFloat(String.valueOf(((differenceReading - defaultMergeRangeValue) * Long.valueOf(defaultWaterPerLitrePrice))))+defaultWaterAmountValue;
        }
        else if(differenceReading==0 || (differenceReading!=0 && differenceReading<=defaultMergeRangeValue))
        {
            return Float.parseFloat(defaultWaterAmount);
        }
        return -130;
    }
}
