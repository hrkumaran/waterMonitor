package com.intuit.jobsearch.waterMonitor.service;

import com.intuit.jobsearch.waterMonitor.controller.WaterReadingController;
import com.intuit.jobsearch.waterMonitor.model.WaterReadingDetails;
import com.intuit.jobsearch.waterMonitor.repository.WaterReadingRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WaterReadingService {

    Logger logger = LoggerFactory.getLogger(WaterReadingController.class);

    @Autowired
    private WaterReadingRepository waterReadingRepository;

    public List<WaterReadingDetails> getAllUserWaterReading() {
        return waterReadingRepository.findAll();
    }

    public WaterReadingDetails generateWaterConsumptionDetails(WaterReadingDetails waterReadingDetails) throws Exception
    {
        WaterReadingDetails waterReadingDetailsResults = null;
        try {


            waterReadingDetailsResults = waterReadingRepository.save(waterReadingDetails);
          logger.info("WaterReadingDetailsResults=" + waterReadingDetailsResults);
      }
      catch (Exception e)
      {
          logger.info("Exception=" + e);
          e.printStackTrace();
      }
    return waterReadingDetailsResults;
    }
}
