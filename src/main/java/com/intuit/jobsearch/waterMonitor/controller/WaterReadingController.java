package com.intuit.jobsearch.waterMonitor.controller;

import com.intuit.jobsearch.waterMonitor.WaterReadingService;
import com.intuit.jobsearch.waterMonitor.model.WaterReadingDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class WaterReadingController {

    @Autowired
    WaterReadingService waterReadingService;

    @RequestMapping(value="getAllWaterReading", method= RequestMethod.GET)
    public ResponseEntity<List<WaterReadingDetails>> getAllUserWaterReading()
    {
        return new ResponseEntity<List<WaterReadingDetails>>(waterReadingService.getAllUserWaterReading(), HttpStatus.OK);
    }

    @RequestMapping(value="addWaterReadingCheck", method= RequestMethod.POST, produces = "application/json", consumes = "application/json")
    public ResponseEntity<Object> addWaterReading(WaterReadingDetails waterReadingDetails)  throws Exception
    {
        waterReadingService.generateWaterConsumptionDetails(waterReadingDetails);
        return new ResponseEntity<>(waterReadingDetails, HttpStatus.OK);
    }

}
