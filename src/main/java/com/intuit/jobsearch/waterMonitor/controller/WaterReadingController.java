package com.intuit.jobsearch.waterMonitor.controller;

import com.intuit.jobsearch.waterMonitor.service.WaterReadingService;
import com.intuit.jobsearch.waterMonitor.model.WaterReadingDetails;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class WaterReadingController {

    @Autowired
    WaterReadingService waterReadingService;

    Logger logger = LoggerFactory.getLogger(WaterReadingController.class);

    @RequestMapping(value="getAllWaterReading", method= RequestMethod.GET)
    public ResponseEntity<List<WaterReadingDetails>> getAllUserWaterReading()
    {
        return new ResponseEntity<List<WaterReadingDetails>>(waterReadingService.getAllUserWaterReading(), HttpStatus.OK);
    }

    @RequestMapping(value="addWaterReadingCheck", method= RequestMethod.POST, produces = "application/json", consumes = "application/json")
    public ResponseEntity<Object> addWaterReading(@RequestBody WaterReadingDetails waterReadingDetails)  throws Exception
    {
        if(waterReadingDetails!=null)
        {
            logger.info("waterReadingDetails Amount="+waterReadingDetails.getAmount());
            logger.info("waterReadingDetails BilledDate="+waterReadingDetails.getBilledMonth());
            logger.info("waterReadingDetails ReadingLitres="+waterReadingDetails.getWaterConsumptionLitres());
        }
        else
        {
            logger.error("waterReadingDetails is null");
        }
        waterReadingService.generateWaterConsumptionDetails(waterReadingDetails);


        return new ResponseEntity<>(waterReadingDetails, HttpStatus.OK);
    }

}
