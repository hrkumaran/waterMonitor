package com.intuit.jobsearch.waterMonitor;

import com.intuit.jobsearch.waterMonitor.model.WaterReadingDetails;
import com.intuit.jobsearch.waterMonitor.repository.WaterReadingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WaterReadingService {

    @Autowired
    private WaterReadingRepository waterReadingRepository;

    public List<WaterReadingDetails> getAllUserWaterReading() {
        return waterReadingRepository.findAll();
    }

    public WaterReadingDetails generateWaterConsumptionDetails(WaterReadingDetails waterReadingDetails) throws Exception
    {
        WaterReadingDetails waterReadingDetailsResults =  waterReadingRepository.save(waterReadingDetails);
    return waterReadingDetailsResults;
    }
}
