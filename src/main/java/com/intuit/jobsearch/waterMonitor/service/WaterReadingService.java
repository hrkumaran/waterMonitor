package com.intuit.jobsearch.waterMonitor.service;

import com.intuit.jobsearch.common.model.UserInfo;
import com.intuit.jobsearch.common.repository.UserInfoRepository;
import com.intuit.jobsearch.common.service.UserTypeWaterAmountFactory;
import com.intuit.jobsearch.common.util.UserType;
import com.intuit.jobsearch.waterMonitor.controller.WaterReadingController;
import com.intuit.jobsearch.waterMonitor.model.WaterReadingDetails;
import com.intuit.jobsearch.waterMonitor.repository.WaterReadingRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import java.util.List;

@Service

public class WaterReadingService {

    Logger logger = LoggerFactory.getLogger(WaterReadingController.class);

    @Autowired
    private WaterReadingRepository waterReadingRepository;

    @Autowired
    private UserInfoRepository userInfoRepository;

    UserTypeWaterAmountFactory userTypeWaterAmountFactory= new UserTypeWaterAmountFactory();

    public List<WaterReadingDetails> getAllUserWaterReading() {
        return waterReadingRepository.findAll();
    }

    public WaterReadingDetails generateWaterConsumptionDetails(WaterReadingDetails waterReadingDetails) throws Exception
    {
        WaterReadingDetails waterReadingDetailsResults = null;
        try {
            UserInfo userInfo = userInfoRepository.getById(waterReadingDetails.getUserId());
            WaterReadingDetails  preivouswaterReadingDetails = waterReadingRepository.findWaterReadingDetailsByRRNO(waterReadingDetails.getRrNo());
            Long differenceReading = waterReadingDetails.getCurrentMeterReading() - preivouswaterReadingDetails.getPreviousMeterReading();
            float amount = calculateUsageAmount(differenceReading,userInfo.getUserType());
            waterReadingDetails.setWaterConsumptionLitre(differenceReading);
            waterReadingDetails.setAmount(amount);
            waterReadingDetails.setPreviousMeterReading(preivouswaterReadingDetails.getPreviousMeterReading());
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

    private float calculateUsageAmount(Long differenceReading, UserType userType) {

           return userTypeWaterAmountFactory.getUserTypeWaterAmount(userType.getValue()).calculateAmount(differenceReading);
    }

    public WaterReadingDetails getUserWaterReadingbyId(Long userId) {
        WaterReadingDetails waterReadingDetailsResults = null;
        try {


            waterReadingDetailsResults = waterReadingRepository.getById(userId);
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
