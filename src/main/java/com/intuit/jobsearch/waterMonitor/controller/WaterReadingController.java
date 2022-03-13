package com.intuit.jobsearch.waterMonitor.controller;

import com.intuit.jobsearch.waterMonitor.service.WaterReadingService;
import com.intuit.jobsearch.waterMonitor.model.WaterReadingDetails;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


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
    public ResponseEntity<Object> addWaterReading(@Valid @RequestBody WaterReadingDetails waterReadingDetails)  throws Exception
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

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(
            MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }

}
