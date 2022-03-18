package com.intuit.jobsearch.common.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import static com.intuit.jobsearch.common.util.WaterReadingConstants.*;

@Service
public class OfficialWaterAmount implements UserTypeWaterAmount{

    @Value(OFFICIAL_INITIAL_METER_RANGE)
    private String defaultMergeRange;

    @Value(OFFICIAL_DEFAULT_PRICE)
    private String defaultWaterAmount;

    @Value(OFFICIAL_INITIAL_METER_PRICE)
    private String defaultWaterPerLitrePrice;

    @Override
    public float calculateAmount(Long differenceReading) {
        long defaultMergeRangeValue= Long.getLong(defaultMergeRange);
        if(differenceReading!=0 && differenceReading>(differenceReading - defaultMergeRangeValue))
        {
            return Float.parseFloat(((differenceReading - defaultMergeRangeValue) * Long.valueOf(defaultWaterPerLitrePrice))+defaultWaterAmount);
        }
        else if(differenceReading==0 || (differenceReading!=0 && differenceReading<=Long.getLong(defaultMergeRange)))
        {
            return Float.parseFloat(defaultWaterAmount);
        }
        return -130;
    }
}
