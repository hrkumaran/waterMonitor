package com.intuit.jobsearch.waterMonitor.controller;

import com.intuit.jobsearch.waterMonitor.model.WaterReadingDetails;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WaterReadingController {

    @RequestMapping(value="addWaterReading", method= RequestMethod.POST, produces = "application/json", consumes = "application/json")
    public ResponseEntity<Object> addWaterReading(WaterReadingDetails waterReadingDetails)
    {

        return new ResponseEntity<>("SUCCESS", HttpStatus.OK);
    }

    @RequestMapping(value="addWaterReadingCheck", method= RequestMethod.POST, produces = "application/json", consumes = "application/json")
    public ResponseEntity<Object> addWaterReading(String waterReadingDetails)
    {
        return new ResponseEntity<>("SUCCESS", HttpStatus.OK);
    }

}
